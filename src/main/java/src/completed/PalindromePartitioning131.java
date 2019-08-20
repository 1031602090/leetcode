package completed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning131 {

    public static void main(String[] args) {
        new PalindromePartitioning131().partition("aab").forEach(System.out::println);
    }


    List<List<String>> result = new LinkedList<>();

    public List<List<String>> partition(String s) {
        partitionHelper(s, new LinkedList<>());
        return result;
    }

    void partitionHelper(String s, List<String> temp) {
        if (s.length() == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        A:
        for (int j = 0; j < s.length(); j++) {
            int l = j;
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) != s.charAt(l--))
                    continue A;
            }
            temp.add(s.substring(0,j+1));
            partitionHelper(s.substring(j + 1), temp);
            temp.remove(temp.size() - 1);
        }
    }
}
