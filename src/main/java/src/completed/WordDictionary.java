package completed;

import other.CharNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 通过!,时间复杂度有些高
 */
public class WordDictionary {
    private CharNode head;
    private int maxDepth = 0;
    private int minDepth = Integer.MIN_VALUE;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        head = new CharNode(' ', false);
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        maxDepth = Math.max(word.length(), maxDepth);
        minDepth = Math.min(word.length(), minDepth);
        CharNode p = head, l = null;
        for (char c : word.toCharArray()) {
            l = null;
            for (CharNode child : p.getChildren()) {
                if (c == child.getC()) {
                    p = child;
                    l = p;
                    break;
                }
            }
            if (l == null) {
                l = new CharNode(c, false);
                p.getChildren().add(l);
                p = l;
            }
        }
        if (l != null) {
            l.setEnd(true);
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    /*
     * 相等
     * 不等
     * .
     * */
    public boolean search(String word) {
        if (word.length() < minDepth || word.length() > maxDepth)
            return false;
        List<CharNode> candidate = new ArrayList<>(head.getChildren());
        List<CharNode> temp, pre = null;
        char last = word.charAt(word.length() - 1);
        for (char c : word.toCharArray()) {
            temp = new LinkedList<>();
            pre = null;
            if (candidate.isEmpty())
                return false;
            if (c == '.') {
                for (CharNode charNode : candidate) {
                    temp.addAll(charNode.getChildren());
                }
                pre = candidate;
            } else {
                for (CharNode charNode : candidate) {
                    if (charNode.getC() == c) {
                        temp.addAll(charNode.getChildren());
                        pre = candidate;
                    }
                }
            }
            candidate = temp;
        }
        if (pre != null) {
            for (CharNode charNode : pre) {
                if ((last == '.' && charNode.isEnd()) || (charNode.isEnd() && charNode.getC() == last))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("a");
        dictionary.addWord("ab");
        System.out.println(dictionary.search(".a"));
        dictionary.addWord("bad");
        dictionary.addWord("mad");
        dictionary.addWord("dad");
        System.out.println(dictionary.search("pad"));
        System.out.println(dictionary.search("bad"));
        System.out.println(dictionary.search(".ad"));
        System.out.println(dictionary.search("..."));
        System.out.println(dictionary.search("ba."));
        System.out.println(dictionary.search(".a"));

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */