package hard.todo;

import java.util.Arrays;

public class WildcardMatching {

    /*
    * "mississippi"
"m??*ss*?i*pi"
    *
    *
    * */

    public static void main(String[] args) {
        System.out.println(isMatch("adceb", "*a*b"));
        System.out.println(!isMatch("acdcb", "a*c?b"));
        System.out.println(!isMatch("cb", "?a"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(!isMatch("aa", "a"));
        System.out.println(isMatch("a", "a*"));
        System.out.println(!isMatch("mississippi", "m??*ss*?i*pi"));
        System.out.println(!isMatch("a", "aa"));
        System.out.println(isMatch("a", "?*"));
//mississi ppi
// m??*ss*?i*pi

    }

    public static boolean isMatch(String s, String p) {
        if (s.isEmpty() || p.isEmpty()) {
            return s.isEmpty() && p.replaceAll("\\*", "").isEmpty();
        }
        s = s + "#";
        p = p + "#";
        int[][] memo = new int[p.length()][s.length()];
        memo[p.length() - 1][s.length() - 1] = 1;
        for (int i = p.length() - 2; i >= 0; i--) {
            char c = p.charAt(i);
            for (int j = s.length() - 2; j >= 0; j--) {
                if (c == '*') {
                    if (memo[i + 1][j + 1] == 1 || memo[i + 1][j] == 1) {
                        if(memo[i + 1][j + 1] == 1)
                            j++;
                        while (j >= 0) {
                            memo[i][j] = 1;
                            j--;
                        }
                    }
                } else if (c == '?') {
                    memo[i][j] = memo[i + 1][j + 1];
                } else if (c == s.charAt(j)) {
                    memo[i][j] = memo[i + 1][j + 1];
                }
            }
        }
        for (int[] ints : memo) {
//            System.out.println(Arrays.toString(ints));
        }
        return memo[0][0] == 1;
    }
}
