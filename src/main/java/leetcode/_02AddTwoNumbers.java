package leetcode;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class _02AddTwoNumbers {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode header = null;
        if (l1 == null || l2 == null) {
            return header;
        }
        int carryFlag = 0;
        header = new ListNode(-1);
        ListNode cur = header;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carryFlag;
            ListNode next = new ListNode(sum % 10);
            carryFlag = sum / 10;
            cur.next = next;
            cur = next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2 != null) {
            while (l2 != null) {
                int sum = l2.val + carryFlag;
                ListNode next = new ListNode(sum % 10);
                carryFlag = sum / 10;
                cur.next = next;
                cur = next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            while (l1 != null) {
                int sum = l1.val + carryFlag;
                ListNode next = new ListNode(sum % 10);
                carryFlag = sum / 10;
                cur.next = next;
                cur = next;
                l1 = l1.next;
            }
        }

        if (carryFlag != 0) {
            ListNode next = new ListNode(carryFlag);
            cur.next = next;
        }

        return header.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
