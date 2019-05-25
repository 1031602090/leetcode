package completed;

public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode t = head;
        while (t != null) {
            len++;
            t = t.next;
        }
        k = len - k % len;
        if (k == len) return head;
        ListNode p = head, q = head;
        while (k != 0) {
            p = q;
            q = q.next;
            k--;
        }
        p.next = null;
        t = q;
        while (q.next != null) q = q.next;
        q.next = head;
        return t;
    }

    public static ListNode rotateRight2(ListNode head, int k) {
        ListNode p = head,q = head;
        if(head==null) return null;
        while (k!=0){
            k--;
            if(q==null)
                q = head;
            else
                q = q.next;
        }
        while (q!=null){
            q = q.next;
            p = p.next;
        }
        print(p);

        System.out.println("---------");
        return head;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }

    static ListNode create(int... a) {
        ListNode h = new ListNode(-1);
        ListNode p = h;
        for (int i : a) {
            p.next = new ListNode(i);
            p = p.next;
        }
        return h;
    }

    static void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
