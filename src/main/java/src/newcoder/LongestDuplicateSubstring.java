package newcoder;

public class LongestDuplicateSubstring {
    public static void main(String[] args) {
        String banana = new LongestDuplicateSubstring().longestDupSubstring("banana");
        System.out.println(banana);
    }

    public String longestDupSubstring(String s) {
        int l = 0, r = 0;
        String res = "";
        while (r < s.length()) {
            String t = s.substring(l, r + 1);
            int i = s.indexOf(t, l + 1);
            if(t.length() > res.length())
                res = t;
            if (i > 0)
                r++;
            else
                l++;
            if (l > r)
                r = l;
        }
        return res;
    }
}
