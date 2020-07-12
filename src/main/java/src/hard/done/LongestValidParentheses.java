package hard.done;

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));
    }

    public int longestValidParentheses(String s) {
        int maxLen = 0;
        int[] dp = new int[s.length()];
        dp[0] = 0;
        OUTER:
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                continue;
            int t = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(j) == ')' && dp[j] == 0) {
                    if(t == 1){
                        dp[i] = i - j;
                    }
                    maxLen = Math.max(maxLen, dp[i]);
                    continue OUTER;
                }
                if (s.charAt(j) == '(' && dp[j] == 0 && t == 0) {
                    t = 1;
                    dp[i] = i - j + 1;
                    dp[j] = 1;
                }
                if (s.charAt(j) == '(' && dp[j] == 0 && t == 1) {
                    dp[i] = i - j;
                    t = 2;
                    break;
                }
            }
            if (t == 1) {
                dp[i] = i + 1;
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    static class Node {
        int val;
        int pos;

        public Node(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }
    }
}
