package completed;

/**
* @link https://leetcode.com/problems/count-and-say/
* */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
    public static String countAndSay(int n) {
        if( n == 1) return "1";
        if( n == 2 ) return "11";
        String x = countAndSay(n-1);
        char c='c';
        StringBuilder res = new StringBuilder();
        int f = 1;
        for (int i=0;i<x.length();i++){
            if(c!=x.charAt(i)){
                res.append(f).append(c);
                c = x.charAt(i);
                f=1;
            }else {
                f++;
            }
        }
        res.append(f).append(c);
        return res.toString().substring(2);
    }
}
