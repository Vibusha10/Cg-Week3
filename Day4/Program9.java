import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program9 {

    public static void main(String[] args) {
        String text = "hello";
        int iterations = 1_000_000;

        long startBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;

        long startBuffer = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;

        System.out.println("Time taken by StringBuilder: " + timeBuilder / 1_000_000 + " ms");
        System.out.println("Time taken by StringBuffer: " + timeBuffer / 1_000_000 + " ms");

        String fileName = "largeFile.txt";

        long startFileReader = System.nanoTime();
        int wordCountFileReader = countWordsUsingFileReader(fileName);
        long endFileReader = System.nanoTime();
        long timeFileReader = endFileReader - startFileReader;

        long startInputStreamReader = System.nanoTime();
        int wordCountInputStreamReader = countWordsUsingInputStreamReader(fileName);
        long endInputStreamReader = System.nanoTime();
        long timeInputStreamReader = endInputStreamReader - startInputStreamReader;

        System.out.println("Time taken by FileReader: " + timeFileReader / 1_000_000 + " ms");
        System.out.println("Time taken by InputStreamReader: " + timeInputStreamReader / 1_000_000 + " ms");
        System.out.println("Word count using FileReader: " + wordCountFileReader);
        System.out.println("Word count using InputStreamReader: " + wordCountInputStreamReader);
    }

    private static int countWordsUsingFileReader(String fileName) {
        int wordCount = 0;
        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        return wordCount;
    }

    private static int countWordsUsingInputStreamReader(String fileName) {
    int wordCount = 0;
    try (FileReader fr = new FileReader(fileName);
         BufferedReader br = new BufferedReader(fr)) {

        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }
    } catch (IOException e) {
        System.out.println("Error occurred while reading the file: " + e.getMessage());
        e.printStackTrace();
    }
    return wordCount;
    }
}


