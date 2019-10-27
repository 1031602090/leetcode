package completed;

import other.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BSTIterator {
    private List<TreeNode> nodeList = new LinkedList<>();
    private Iterator<TreeNode> iterator;
    public BSTIterator(TreeNode root) {
        helper(root);
        iterator = nodeList.iterator();
    }

    private void helper(TreeNode root) {
        if(root!=null){
            helper(root.left);
            nodeList.add(root);
            helper(root.right);
        }
    }


    /**
     * @return the next smallest number
     */
    public int next() {
        return iterator.next().val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return iterator.hasNext();
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        new BSTIterator(treeNode1);
    }
}