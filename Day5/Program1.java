import java.util.Arrays;
import java.util.Random;

public class Program1 {

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};
        int target = -1;

        for (int size : datasetSizes) {
            int[] data = generateRandomArray(size);
            System.out.println("\nDataset Size: " + size);

            long startLinear = System.nanoTime();
            linearSearch(data, target);
            long endLinear = System.nanoTime();
            double timeLinear = (endLinear - startLinear) / 1_000_000.0;

            Arrays.sort(data);

            long startBinary = System.nanoTime();
            binarySearch(data, target);
            long endBinary = System.nanoTime();
            double timeBinary = (endBinary - startBinary) / 1_000_000.0;

            System.out.printf("Linear Search Time: %.4f ms\n", timeLinear);
            System.out.printf("Binary Search Time: %.4f ms\n", timeBinary);
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size * 2);
        }
        return array;
    }
}
