package completed;

import other.ListNode;

import java.util.ArrayList;

public class PartitionList86 {
    public static void main(String[] args) {
        partition(ListNode.build(1, 4, 3, 2, 5, 2), 3).print();
        partition(ListNode.build(2, 1), 2).print();
        partition(ListNode.build(3, 1), 2).print();
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode lower = new ListNode(-1);
        ListNode p = lower;
        ListNode higher = new ListNode(-1);
        higher.next = head;
        ListNode t = higher;
        while (head != null) {
            if (head.val < x) {
                p.next = head;
                p = p.next;
                higher.next = head.next;
                head = head.next;
            }else{
                higher = head;
                head = head.next;
            }
        }
        p.next = t.next;
        return lower.next;
    }
}
