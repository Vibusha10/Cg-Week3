import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program8 {
    public static void main(String[] args) {
        String fileName = "output.txt";

        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fw = new FileWriter(fileName);

            String inputLine;
            System.out.println("Enter text (type 'exit' to finish):");

            while (!(inputLine = br.readLine()).equalsIgnoreCase("exit")) {
                fw.write(inputLine + System.lineSeparator());
            }

            fw.close();
            br.close();
            isr.close();
            System.out.println("Input successfully written to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
