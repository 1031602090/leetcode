package completed;

import other.ListNode;

import java.util.Optional;

/**
 * @link <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/"></a>
 */
public class RemoveDuplicatesFromSortedListII82 {
    public static void main(String[] args) {
        deleteDuplicates(ListNode.build(1, 2, 3, 3, 4, 4, 5)).print();
        deleteDuplicates(ListNode.build(1, 1, 1, 2, 3)).print();
        deleteDuplicates(ListNode.build(1, 2,2)).print();
        Optional.ofNullable(deleteDuplicates(ListNode.build(1, 1, 1))).orElseGet(()->new ListNode(-100)).print();

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode t = res;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val)
                    head = head.next;
                head = head.next;
            }else {
                res.next = head;
                res = res.next;
                head = head.next;
            }
        }
        res.next = null;
        return t.next;
    }
}

