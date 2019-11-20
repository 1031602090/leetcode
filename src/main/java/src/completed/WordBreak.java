package completed;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreak_2("catsandog", Arrays.asList("cats", "dog", "and")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() == 0)
            return false;
        if (s.length() == 0)
            return true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (wordDict.contains(sb.toString()) && wordBreak(s.substring(i + 1), wordDict))
                return true;
        }
        return false;
    }

    public static boolean wordBreak_1(String s, List<String> wordDict) {
        LinkedList<Integer> pos = new LinkedList<>();
        pos.add(0);
        boolean[] visited = new boolean[s.length()];
        while (!pos.isEmpty()) {
            int t = pos.poll();
            if (t == s.length())
                return true;
            if (!visited[t]) {
                for (int i = t + 1; i <= s.length(); i++) {
                    String w = s.substring(t, i);
                    if (wordDict.contains(w))
                        pos.offer(i);
                }
                visited[t] = true;
            }
        }
        return false;
    }

    public static boolean wordBreak_2(String s, List<String> wordDict) {
        return wordBreak_2Helper(s, wordDict, 0, new boolean[s.length()+1]);
    }

    public static boolean wordBreak_2Helper(String s, List<String> wordDict, int start, boolean[] visited) {
        if (start == s.length())
            return true;
        if(visited[start])
            return false;
        for (int i = start + 1; i <= s.length(); i++) {
            if (!visited[i])
                if (wordDict.contains(s.substring(start, i)))
                    if(wordBreak_2Helper(s, wordDict, i, visited))
                        return true;
                    else
                        visited[start] = true;
        }
        return false;
    }

    public static boolean wordBreak_3(String s, List<String> wordDict) {

        return false;
    }

}