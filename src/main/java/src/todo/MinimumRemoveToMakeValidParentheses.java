package todo;

import java.util.LinkedList;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {

    }

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '(')
                stack.push(i);
            if(chars[i] == ')'){
                if(!stack.isEmpty()){
                    Integer peek = stack.peek();
                    if(chars[peek] != '('){
                        chars[i] = '#';
                    }else {
                        stack.pop();
                    }
                }else {
                    chars[i] = '#';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if(c !='#')
                sb.append(c);
        }
        return sb.toString();
    }
}
