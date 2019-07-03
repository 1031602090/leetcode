package todo;

import other.ListNode;
import other.TreeNode;

import java.util.List;

/**
 * @link https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertSortedListToBinarySearchTree109 {
    private ListNode head;
    private int size(ListNode head){
        int c = 0;
        while (head!=null){
            c++;
            head = head.next;
        }
        return c;
    }

    private TreeNode listToBinaryTree(int l,int r){
        if(l > r) return null;
        int mid = (l+r)/2;
        TreeNode left = listToBinaryTree(l,mid-1);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        head = head.next;
        root.right = listToBinaryTree(mid+1,r);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int size = size(head);
        return listToBinaryTree(0,size-1);
    }

    public static void main(String[] args) {
        ListNode build = ListNode.build(-10, -3, 0, 5, 9);
        TreeNode node = new ConvertSortedListToBinarySearchTree109().sortedListToBST(build);
        System.out.println(node);
        System.out.println(1 ^ 2 ^ ~3);
    }
}
