package todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("aaaa","aaa")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.size() == 0)
            return false;
        if(s.length() == 0)
            return true;
        StringBuilder sb = new StringBuilder();
        boolean r = false;
        for(int i=0;i<s.length();i++){
            var f = new ArrayList<>();
            sb.append(s.charAt(i));
            if(wordDict.contains(sb.toString()))
                r = r || wordBreak(s.substring(i+1),wordDict);
        }
        return r;
    }
}