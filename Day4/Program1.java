public class Program1 {
    public static String reverseUsingStringBuilder(String input) {

        StringBuilder sb = new StringBuilder(input);
        
        sb.reverse();
        
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "hello";
        String reversed = reverseUsingStringBuilder(input);
        System.out.println("Reversed string: " + reversed);
    }
}
