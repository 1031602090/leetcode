import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/group-anagrams/"></a>
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        for (String s : strs) {
            boolean f = true;
            for (List<String> strList : res) {
                boolean b = true;
                String t = strList.get(0);
                if(t.equals(s)){
                    f = false;
                    strList.add(s);
                    break;
                }
                if(t.length() != s.length()){
                    continue;
                }
                b = rep(s,t);
                if(b){
                    strList.add(s);
                    f = false;
                    break;
                }
            }
            if(!f) continue;
            List<String> g = new ArrayList<>();
            g.add(s);
            res.add(g);
        }
        return res;
    }
    private static boolean rep(String a,String b){
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        for(int i=0;i<x.length;i++){
            if(x[i]!=y[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(rep("bob","bbo"));
//        System.out.println(groupAnagrams(new String[]{}));
    }
}
