package todo;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        new GenerateParentheses().generateParenthesis(3).forEach(System.out::println);
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        generateParenthesisHelper("", n, n, ans);
        return ans;
    }

    private void generateParenthesisHelper(String s, int right, int left, ArrayList<String> ans) {
        if (left < 0 || left > right)
            return;
        if (left == 0 && left == right)
            ans.add(s);
        generateParenthesisHelper(s + '(', right, left - 1, ans);
        if (right > left) {
            generateParenthesisHelper(s + ')', right - 1, left, ans);
        }
    }
}
