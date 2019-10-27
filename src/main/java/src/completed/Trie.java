package completed;

import java.util.LinkedList;
import java.util.List;

public class Trie {
    private CharNode head;

    static class CharNode {
        char c;
        boolean isEnd;
        List<CharNode> children;

        CharNode(char c, boolean isEnd) {
            this.c = c;
            this.isEnd = isEnd;
            children = new LinkedList<>();
        }

        List<CharNode> getChildren() {
            return children;
        }

        @Override
        public String toString() {
            return "CharNode{" +
                    "c=" + c +
                    ", isEnd=" + isEnd +
                    ", children=" + children +
                    '}';
        }
    }

    /**
     * Initialize your data structure here.
     */
    private Trie() {
        head = new CharNode('c', false);
    }

    /**
     * Inserts a word into the trie.
     */
    private void insert(String word) {
        CharNode p = head, l = null;
        w:
        for (char c : word.toCharArray()) {
            for (CharNode child : p.getChildren()) {
                if (child.c == c) {
                    l = child;
                    p = child;
                    continue w;
                }
            }
            l = new CharNode(c, false);
            p.getChildren().add(l);
            p = l;
        }
        if (l != null) {
            l.isEnd = true;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    private boolean search(String word) {
        CharNode p = head, q;
        boolean b = false;
        for (char c : word.toCharArray()) {
            b = false;
            q = p;
            for (CharNode child : p.getChildren()) {
                if (child.c == c) {
                    p = child;
                    if (child.isEnd)
                        b = true;
                    break;
                }
            }
            if (q == p)
                break;
        }
        return b;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    private boolean startsWith(String prefix) {
        CharNode p = head, q;
        boolean f = false;
        for (char c : prefix.toCharArray()) {
            f = false;
            q = p;
            for (CharNode child : p.getChildren()) {
                if (child.c == c) {
                    p = child;
                    f = true;
                    break;
                }
            }
            if (q == p)
                break;
        }
        return f;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
//        System.out.println(trie.head);
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("appled"));
        System.out.println(trie.search("appl"));
        System.out.println(trie.search("qwert"));
        System.out.println(trie.search(""));
        System.out.println("-------------------");
        trie.insert("app");
//        System.out.println(trie.head);
        System.out.println(trie.search("app"));
        System.out.println(trie.search("appl"));

        System.out.println("-----------------------");
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.startsWith("appl"));
        System.out.println(trie.startsWith("apple"));
        System.out.println(trie.startsWith("applea"));
        System.out.println(trie.startsWith(""));
        System.out.println(trie.startsWith("dddd"));

        trie.insert("holyshit");
        trie.insert("mygod");
        trie.insert("holy");
        trie.insert("my");
        System.out.println(trie.search("holy"));
        System.out.println(trie.search("myq"));
        System.out.println(trie.search("dholy"));

        System.out.println(trie.startsWith("dholy"));

    }
}