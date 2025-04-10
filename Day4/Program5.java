import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program5 {
    public static void main(String[] args) {
        String fileName = "sample.txt";

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
