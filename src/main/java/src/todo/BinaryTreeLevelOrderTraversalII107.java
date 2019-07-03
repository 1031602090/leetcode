package todo;

import other.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class BinaryTreeLevelOrderTraversalII107 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        levelOrderBottomHelper(root,1);
        return res;
    }

    private void levelOrderBottomHelper(TreeNode root,int n){
        if(root == null) return;
        if(n > res.size()){
            ((LinkedList<List<Integer>>)res).addFirst(new LinkedList<>());
        }
        res.get(res.size() - n).add(root.val);
        levelOrderBottomHelper(root.left,n+1);
        levelOrderBottomHelper(root.right,n+1);
    }
}
