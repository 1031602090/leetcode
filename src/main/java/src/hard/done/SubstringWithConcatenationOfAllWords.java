package hard.done;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring("ababaab", new String[]{"ab", "ba", "ba"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        if (s.isEmpty() || words.length == 0) {
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int oneLen = words[0].length(), strLen = words.length * oneLen;
        for (int i = 0; i < s.length() - strLen + 1; i++) {
            Map<String, Integer> tem_map = new HashMap<>();
            String subStr = s.substring(i, strLen + i);
            for (int j = 0; j < strLen; j += oneLen) {
                String substring = subStr.substring(j, oneLen + j);
                tem_map.put(substring, tem_map.getOrDefault(substring, 0) + 1);
            }
            if (tem_map.equals(map)) {
                ans.add(i);
            }
        }
        return ans;

    }
}
