package leetcode;

public class _19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head, end = head;
        for (int i = 0; i < n; i++) {
            end = end.next;
            if (end == null) {
                return front.next;
            }
        }
        while (end.next != null) {
            front = front.next;
            end = end.next;
        }
        front.next = front.next.next;
        return head;
    }
}
