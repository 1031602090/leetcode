package todo;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class WaterAndJugProblem {
    public static void main(String[] args) {

    }

    public boolean canMeasureWater(int x, int y, int z) {
        Stack<Node> stack = new Stack<>();
        stack.push(Node.create(0, 0));
        Set<Node> node = new HashSet<>();
        while (!stack.isEmpty()) {
            Node t = stack.pop();
            if (!node.add(t)) {
                continue;
            }
            if (t.x == z || t.y == z || t.x + t.y == z) {
                return true;
            }
//            装满X
            stack.push(Node.create(x, t.y));
//           装满Y
            stack.push(Node.create(t.x, y));
//            倒掉X
            stack.push(Node.create(0, y));
//            倒掉Y
            stack.push(Node.create(t.x, 0));
//          X==>Y
            stack.push(Node.create(Math.max(t.x - (y - t.y), 0), Math.min(y, t.y + t.x)));
//          Y===>X
            stack.push(Node.create(Math.min(x, t.y + t.x), Math.max(t.y - (x - t.x), 0)));
        }

        return false;
    }

    static class Node {
        int x, y;

        public static Node create(int x, int y) {
            return new Node(x, y);
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (x != node.x) return false;
            return y == node.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
