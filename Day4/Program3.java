public class Program3 {
    public static String concatenateUsingStringBuffer(String[] strings) {
        StringBuffer sb = new StringBuffer();

        for (String str : strings) {
            sb.append(str);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] input = {"Hello", " ", "World", "!", " Have", " a", " nice", " day."};
        String result = concatenateUsingStringBuffer(input);
        System.out.println("Concatenated string: " + result);
    }
}
