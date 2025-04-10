public class Program11 {
    
    public static void main(String[] args) {
        String[] sentences = {
            "The sky is blue.",
            "The sun is shining.",
            "I am learning Java.",
            "The moon is bright."
        };
        
        String word = "Java";
        String result = findSentenceWithWord(sentences, word);
        
        System.out.println(result);
    }
    
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }
}