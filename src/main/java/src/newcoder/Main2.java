package newcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<CharNode> charNodes = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                boolean flag = false;
                for (CharNode t : charNodes)
                    if (t.c == c) {
                        t.count++;
                        flag = true;
                        break;
                    }
                if (!flag)
                    charNodes.add(new CharNode(c, 1));
            }
        }
        CharNode[] nodes = new CharNode[charNodes.size()];
        charNodes.toArray(nodes);
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes.length - i; j++) {
                if (nodes[i].count - nodes[j].count > 0) {
                    CharNode t = nodes[i];
                    nodes[i] = nodes[j];
                    nodes[j] = t;
                }
            }
        }
        for (CharNode f : nodes)
            System.out.println(f.c+"="+f.count);
    }

    static class CharNode {
        char c;
        int count;
        public CharNode(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}
