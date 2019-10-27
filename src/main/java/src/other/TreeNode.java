package other;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    private StringBuilder inOrder(TreeNode t){
        StringBuilder sb = new StringBuilder();
        if(t!=null){
            sb.append(inOrder(t.left));
            sb.append(t.val).append(" ");
            sb.append(inOrder(t.right));
        }
        return sb;
    }
}