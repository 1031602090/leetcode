package other;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode build(int... data) {
        ListNode head = new ListNode(-1);
        ListNode f = head;
        for (int t : data) {
            head.next = new ListNode(t);
            head = head.next;
        }
        return f.next;
    }

    public void print() {
        ListNode t = this;
        while (t != null) {
            System.out.print(t.val);
            t = t.next;
        }
        System.out.println("\n------");
    }
}
