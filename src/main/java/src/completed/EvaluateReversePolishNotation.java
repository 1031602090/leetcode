package completed;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int a = 0;
        int b;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    a += b;
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    a = b - a;
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    a *= b;
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    a = b / a;
                    break;
                default:
                   a = Integer.parseInt(token);
            }
            stack.push(a);
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
