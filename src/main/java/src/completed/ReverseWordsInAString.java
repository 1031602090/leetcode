package completed;

public class ReverseWordsInAString {

    public static String reverseWords(String s) {
        s = s.trim();
        String[] split = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i > 0; i--) {
            sb.append(split[i]).append(" ");
        }
        if (split.length > 0)
            sb.append(split[0]);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world!  "));
        System.out.println(reverseWords("a good   example"));
    }
}
