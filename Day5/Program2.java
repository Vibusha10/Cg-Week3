import java.util.Arrays;
import java.util.Random;

public class Program2 {

    public static void main(String[] args) {
        int[] sizes = {1000, 10000};

        for (int size : sizes) {
            int[] array1 = generateRandomArray(size);
            int[] array2 = Arrays.copyOf(array1, array1.length);
            int[] array3 = Arrays.copyOf(array1, array1.length);

            System.out.println("\nDataset Size: " + size);

            long startBubble = System.nanoTime();
            bubbleSort(array1);
            long endBubble = System.nanoTime();
            System.out.printf("Bubble Sort Time: %.4f ms\n", (endBubble - startBubble) / 1_000_000.0);

            long startMerge = System.nanoTime();
            mergeSort(array2, 0, array2.length - 1);
            long endMerge = System.nanoTime();
            System.out.printf("Merge Sort Time: %.4f ms\n", (endMerge - startMerge) / 1_000_000.0);

            long startQuick = System.nanoTime();
            quickSort(array3, 0, array3.length - 1);
            long endQuick = System.nanoTime();
            System.out.printf("Quick Sort Time: %.4f ms\n", (endQuick - startQuick) / 1_000_000.0);
        }

        int size = 1_000_000;
        int[] arrayMerge = generateRandomArray(size);
        int[] arrayQuick = Arrays.copyOf(arrayMerge, arrayMerge.length);

        System.out.println("\nDataset Size: " + size);

        long startMerge = System.nanoTime();
        mergeSort(arrayMerge, 0, arrayMerge.length - 1);
        long endMerge = System.nanoTime();
        System.out.printf("Merge Sort Time: %.4f ms\n", (endMerge - startMerge) / 1_000_000.0);

        long startQuick = System.nanoTime();
        quickSort(arrayQuick, 0, arrayQuick.length - 1);
        long endQuick = System.nanoTime();
        System.out.printf("Quick Sort Time: %.4f ms\n", (endQuick - startQuick) / 1_000_000.0);
    }

    static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size * 2);
        }
        return array;
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}