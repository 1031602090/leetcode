package completed;

import other.ListNode;

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
        p.print();

        System.out.println("---------");
        return head;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }


}