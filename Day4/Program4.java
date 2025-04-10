public class Program4 {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "hello";

        long startBuilder = System.nanoTime();
        StringBuilder sbBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbBuilder.append(text);
        }
        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;

        long startBuffer = System.nanoTime();
        StringBuffer sbBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbBuffer.append(text);
        }
        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;

        System.out.println("Time taken by StringBuilder: " + timeBuilder / 1_000_000 + " ms");
        System.out.println("Time taken by StringBuffer: " + timeBuffer / 1_000_000 + " ms");
    }
}