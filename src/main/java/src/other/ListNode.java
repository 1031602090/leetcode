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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode t = this;
        while (t != null) {
            sb.append(t.val).append(" ");
            t = t.next;
        }
        return sb.toString();
    }

    public void print() {
        System.out.println(toString());
        System.out.println("\n------");
    }
}
