package completed;

import other.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 0 1 2 3
 n n-1 n-2 
 0 n 1 n-1 2 n-2 3

 */
public class  ReorderList {
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode slow = head,fast = head,p,q;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        fast = reverse(fast);
        while(head != null && fast!=null){
            q = head;
            p = fast;
            fast = fast.next;
            head = head.next;
            p.next = head;
            q.next = p;
        }
    }

    private ListNode reverse(ListNode head){
        if(head == null) return null;
        ListNode t = new ListNode(-1);
        ListNode p = head,q;
        while(p!=null){
            q = p;
            p = p.next;
            q.next = t.next;
            t.next = q;
        }
        return t.next;
    }

    public static void main(String[] args) {
        ListNode build = ListNode.build(1,2);
        new ReorderList().reorderList(build);
        build.print();
    }
}