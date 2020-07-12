package todo;

import java.util.*;

public class ShortEncodingOfWords {
    public static void main(String[] args) {
        System.out.println(new ShortEncodingOfWords().minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }

    public int minimumLengthEncoding(String[] words) {
        int count = 0;
        CharNode node = new CharNode('#');
      //  System.out.println(Arrays.toString(words));
        CharNode cur;
        Set<CharNode> nodeSet = new HashSet<>();

        for (String word : words) {
            cur = node;
            int d = 1;
            P:
            for (int i = word.length() - 1; i >= 0; i--) {
                for (CharNode child : cur.getChildren()) {
                    if (child.c == word.charAt(i)) {
                        cur = child;
                        d++;
                        continue P;
                    }
                }
                CharNode e = new CharNode(word.charAt(i));
                nodeSet.add(e);
                e.d = d;
                cur.getChildren().add(e);
                cur = e;
                d++;
            }
        }
        for (CharNode charNode : nodeSet) {
            if (charNode.children.size() == 0) {
           //     System.out.println(charNode.d);
                count += (charNode.d + 1);
            }
        }
        return count;
    }

    static class CharNode {
        char c;
        List<CharNode> children;
        int d = 0;

        CharNode(char c) {
            this.c = c;
            children = new LinkedList<>();
        }

        List<CharNode> getChildren() {
            return children;
        }
    }
}
