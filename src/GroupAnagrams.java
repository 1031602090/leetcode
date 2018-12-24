import java.util.ArrayList;
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
        boolean[] tmp = new boolean[a.length()];
        for(int i=0;i<a.length();i++){
            if(tmp[i] || a.indexOf(b.charAt(i)) == -1){
                break;
            }
            tmp[i] = true;
        }
        for(boolean f:tmp){
            if(!f) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(rep("bob","bob"));
//        System.out.println(groupAnagrams(new String[]{"hos","boo","nay","deb","wow","bop","bob","brr","hey","rye","eve","elf","pup","bum","iva","lyx","yap","ugh","hem","rod","aha","nam","gap","yea","doc","pen","job","dis","max","oho","jed","lye","ram","pup","qua","ugh","mir","nap","deb","hog","let","gym","bye","lon","aft","eel","sol","jab"}));
    }
}
