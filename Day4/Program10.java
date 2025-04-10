public class Program10 {
    
    public static void main(String[] args) {
        int[] numbers = {4, 3, -2, 1, 6, -8, 7};
        
        int index = findFirstNegative(numbers);
        
        if (index != -1) {
            System.out.println("First negative number is at index: " + index);
        } else {
            System.out.println("No negative number found");
        }
    }
    
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}
