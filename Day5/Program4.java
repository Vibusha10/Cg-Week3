import java.io.*;

public class Program4 {

    public static void main(String[] args) {
        String fileName = "largefile.txt";

        long startReader = System.nanoTime();
        int charsFileReader = readUsingFileReader(fileName);
        long endReader = System.nanoTime();
        System.out.println("FileReader Time: " + (endReader - startReader) / 1_000_000 + " ms");

        long startStream = System.nanoTime();
        int charsStreamReader = readUsingInputStreamReader(fileName);
        long endStream = System.nanoTime();
        System.out.println("InputStreamReader Time: " + (endStream - startStream) / 1_000_000 + " ms");

        System.out.println("Characters read (FileReader): " + charsFileReader);
        System.out.println("Characters read (InputStreamReader): " + charsStreamReader);
    }

    private static int readUsingFileReader(String fileName) {
        int count = 0;
        try (FileReader reader = new FileReader(fileName);
             BufferedReader br = new BufferedReader(reader)) {
            while (br.read() != -1) {
                count++;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return count;
    }

    private static int readUsingInputStreamReader(String fileName) {
        int count = 0;
        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {
            while (br.read() != -1) {
                count++;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return count;
    }
}
