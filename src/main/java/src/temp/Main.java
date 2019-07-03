package temp;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(reachNumber(2));
    }

    public static int reachNumber(int target) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int min = Integer.MAX_VALUE;
        int cur = 0;
        while (!stack.isEmpty()) {
            int t = stack.pop();
            if (t > 0) {
                stack.push(-t);
            }
            cur += t;
            if (Math.abs(cur) < target )
                stack.push(Math.abs(t) + 1);
            if (cur > target) {
                cur -= t;
            }
            if (cur == target) {
                min = Math.min(min, stack.size());
            }
        }
        return min;

    }
}