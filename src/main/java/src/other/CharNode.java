package other;

import completed.Trie;

import java.util.LinkedList;
import java.util.List;

public class CharNode {
    private char c;
    private boolean isEnd;
    private List<CharNode> children;

    public CharNode(char c, boolean isEnd) {
        this.c = c;
        this.isEnd = isEnd;
        children = new LinkedList<>();
    }

    public char getC() {
        return c;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public List<CharNode> getChildren() {
        return children;
    }

    public boolean isEnd() {
        return isEnd;
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
