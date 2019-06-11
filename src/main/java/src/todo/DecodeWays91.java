package todo;

/**
 * @author hang
 * @link <a href="https://leetcode.com/problems/decode-ways/"></a>
 */
public class DecodeWays91 {
    public static void main(String[] args) {
        System.out.println(numDecodings2("22106"));
    }

    public static int numDecodings2(String s){
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        if(s.length() == 1) return 1;
        int res = 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            if (s.charAt(i) > '2' && s.charAt(i + 1) == 0) return 0;
            if (s.charAt(i) <= '2' && s.charAt(i+1) == '0'){
                i--;
                continue;
            }
            if( s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))
                res++;
        }
        return res;
    }

    public static int numDecodings(String s) {
        int i = 0;
        while (i<s.length() && s.charAt(i) != '0') i++;
        if(s.length() == 0 || s.length() == i) return 0;
        return numDecodingsHelper(s, i);
    }

    private static int numDecodingsHelper(String s, int i) {
        if (i >= s.length() - 1) return 1;
        int a = 0, b;
        if(s.charAt(i) == '0'){
            return 0;
        }
        if ((s.charAt(i) == '2' && s.charAt(i + 1) <= '6') || s.charAt(i) == '1') {
            a = numDecodingsHelper(s, i + 2);
        }
        b = numDecodingsHelper(s, i + 1);
        return a + b;
    }
}
