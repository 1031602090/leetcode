package completed;

/**
 * @see <a href="https://leetcode.com/problems/length-of-last-word/"></a>
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        String[] a = s.split(" ");
        for (int i = a.length - 1; i >= 0; i--) {
            int t = count(a[i]);
            if (t != 0) return t;
        }
        return 0;
    }

    private static int count(String s) {
        boolean f = false;
        int count = 0;
        for(char c:s.toCharArray()){
            if( (c >= 'a' && c<='z') || (c>='A' && c<='Z')){
                f = true;
                count++;
            }else if(f){
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(count("32*qwdsads"));
        System.out.println(lengthOfLastWord("Hello 32*qwdsads"));
    }
}
