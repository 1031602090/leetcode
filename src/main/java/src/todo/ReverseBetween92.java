package todo;

import other.ListNode;

public class ReverseBetween92 {
    public static void main(String[] args) {
        reverseBetween(ListNode.build(1, 2, 3, 4, 5), 2, 4).print();
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode p = null, res = fakeHead;
        n = n - m + 1;
        while (m != 1 && head != null) {
            fakeHead = head;
            head = head.next;
            m--;
        }
        fakeHead.next = null;
        while (n > 0 && head != null) {
            p = head;
            head = head.next;
            p.next = fakeHead.next;
            fakeHead.next = p;
            n--;
        }
        while (p != null && p.next != null) p = p.next;
        if (p != null) {
            p.next = head;
        }
        return res.next;
    }
}
