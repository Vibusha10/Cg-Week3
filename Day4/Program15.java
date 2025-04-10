public class Program15 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5, 5, 5, 6};
        int target = 2;
        
        int[] result = findFirstAndLast(arr, target);
        
        System.out.println("First occurrence: " + result[0]);
        System.out.println("Last occurrence: " + result[1]);
    }
    
    public static int[] findFirstAndLast(int[] arr, int target) {
        int[] result = {-1, -1};
        result[0] = findFirstOccurrence(arr, target);
        if (result[0] != -1) {
            result[1] = findLastOccurrence(arr, target);
        }
        return result;
    }
    
    private static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int firstOccurrence = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                firstOccurrence = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return firstOccurrence;
    }
    
    private static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int lastOccurrence = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                lastOccurrence = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return lastOccurrence;
    }
}
