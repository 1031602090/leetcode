package todo;

import java.util.Arrays;

public class FindWordsThatCanBeFormedByCharacters {
    public static void main(String[] args) {
        System.out.println(new FindWordsThatCanBeFormedByCharacters().countCharacters(new String[]{"hello", "world", "leetcode"},
                "welldonehoneyr"));
    }

    public int countCharacters(String[] words, String chars) {
        boolean[] used = new boolean[chars.length()];
        int ans = 0;
        for (String word : words) {
            Arrays.fill(used, false);
            int i = -1;
            for (char c : word.toCharArray()) {
                int s = 0;
                while ((i = chars.indexOf(c, s)) >= 0 && used[i] && (s = i + 1) > -1) ;
                if (i < 0)
                    break;
                used[i] = true;
            }
            if (i >= 0)
                ans += word.length();
        }
        return ans;
    }
}
