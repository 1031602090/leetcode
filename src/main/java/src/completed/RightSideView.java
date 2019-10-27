package completed;

import other.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RightSideView {
    private List<List<Integer>> lists = new ArrayList<>();
    private LinkedList<Integer> res = new LinkedList<>();

    public List<Integer> rightSideView(TreeNode root) {
        preOrder(root,0);
        return res;
    }

    private void preOrder(TreeNode root,int depth){
        if(root == null) return;
        if(res.size() == depth)
            res.add(root.val);
        else {
            res.remove(depth);
            res.add(depth, root.val);
        }
        preOrder(root.left,depth + 1);
        preOrder(root.right,depth + 1);

    }

    public List<Integer> rightSideView1(TreeNode root) {
        rightSideViewHelper(root,0);
        List<Integer> integers = new ArrayList<>(lists.size());
        for (List<Integer> l : lists) {
            integers.add(l.get(l.size()-1));
        }
        return integers;
    }

    private void rightSideViewHelper(TreeNode root, int depth) {
        if(root == null) return;
        if(depth == lists.size()){
            lists.add(new ArrayList<>());
        }
        lists.get(depth).add(root.val);
        rightSideViewHelper(root.left,depth+1);
        rightSideViewHelper(root.right,depth+1);
    }
}
