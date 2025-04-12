public class Program3 {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        for (int n : sizes) {
            System.out.println("\nConcatenation Count: " + n);

            if (n <= 10000) {
                long startString = System.nanoTime();
                String resultString = "";
                for (int i = 0; i < n; i++) {
                    resultString += "a";
                }
                long endString = System.nanoTime();
                System.out.printf("String Time: %.4f ms\n", (endString - startString) / 1_000_000.0);
            } else {
                System.out.println("String Time: Skipped (too slow for large N)");
            }

            long startBuilder = System.nanoTime();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                builder.append("a");
            }
            long endBuilder = System.nanoTime();
            System.out.printf("StringBuilder Time: %.4f ms\n", (endBuilder - startBuilder) / 1_000_000.0);

            long startBuffer = System.nanoTime();
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < n; i++) {
                buffer.append("a");
            }
            long endBuffer = System.nanoTime();
            System.out.printf("StringBuffer Time: %.4f ms\n", (endBuffer - startBuffer) / 1_000_000.0);
        }
    }
}
