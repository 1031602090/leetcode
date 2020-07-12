package completed;

public class CompressString {
    public static void main(String[] args) {

    }

    public String compressString(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            int c = 1;
            char s = S.charAt(i);
            while (s == S.charAt(i+1)){
                i++;
                c++;
            }
            sb.append(s).append(c);
        }
        return sb.length() < S.length() ? sb.toString() : S;
    }
}
