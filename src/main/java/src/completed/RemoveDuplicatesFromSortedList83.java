package completed;

import other.ListNode;

import java.util.List;

/**
 * @link <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/"></>
 */
public class RemoveDuplicatesFromSortedList83 {
    public static void main(String[] args) {
        deleteDuplicates(ListNode.build(1,2,3,3,4,4,5)).print();
        deleteDuplicates(ListNode.build(1,1,1)).print();
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        ListNode t = fakeHead;
        while (head!=null){
            while (head.next!=null && head.val == head.next.val)
                head = head.next;
            fakeHead.next = head;
            fakeHead = fakeHead.next;
            head = head.next;
        }
        fakeHead.next = null;
        return t.next;
    }
}
