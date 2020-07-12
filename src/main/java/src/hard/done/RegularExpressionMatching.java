package hard.done;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();
        boolean firstMatch = (!s.isEmpty()) && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p)));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
//        System.out.println(new RegularExpressionMatching().isMatch("aa", "a"));
//        System.out.println(new RegularExpressionMatching().isMatch("aa", "a*"));
//        System.out.println(new RegularExpressionMatching().isMatch("ab", ".*"));
//        System.out.println(new RegularExpressionMatching().isMatch("aab", "c*a*b"));
        System.out.println(new RegularExpressionMatching().isMatch("mississippi", "mis*is*p*."));
//        System.out.println(new RegularExpressionMatching().isMatch("abcd", "d*"));
//        System.out.println(new RegularExpressionMatching().isMatch("aaa", "a*a"));
//        System.out.println(new RegularExpressionMatching().isMatch("aab", "c*a*b*"));

    }
}
