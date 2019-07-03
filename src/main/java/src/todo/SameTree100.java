package todo;

import other.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/same-tree/
 */
public class SameTree100 {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(p);
        treeNodes.offer(q);
        while (!treeNodes.isEmpty()) {
            TreeNode x = treeNodes.poll();
            TreeNode y = treeNodes.poll();
            if (x != null && y != null){
                if(x.val != y.val)
                    return false;
                treeNodes.offer(x.left);
                treeNodes.offer(y.left);
                treeNodes.offer(x.right);
                treeNodes.offer(y.right);
                continue;
            }
            if(x != y)
                return false;
        }
        return true;
    }
}
