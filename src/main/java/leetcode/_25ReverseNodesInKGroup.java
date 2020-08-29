package leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class _25ReverseNodesInKGroup {
    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode headPre = new ListNode(0);
        headPre.next = head;

        ListNode pre = headPre, begin = head, cur = head;
        ListNode end = pre;

        while (cur.next != null) {
            begin = end.next;
            cur = end.next;
            pre = end;
            boolean isFull = false;
            for (int i = 0; i < k - 1; i++) {
                if (cur.next == null) {
                    isFull = true;
                    break;
                }
                cur = cur.next;
            }
            end = cur;

            if (isFull) {
                end = begin;
                cur = end;
                continue;
            }
            //反转链表
            ListNode reversePre = pre;
            ListNode reverseEnd = end;
            ListNode reverseCur = begin;
            while (reverseCur != end) {
                reversePre.next = reverseCur.next;
                reverseCur.next = reverseEnd.next;
                reverseEnd.next = reverseCur;
                reverseCur = reversePre.next;
            }
            end = begin;
            cur = end;
        }
        return headPre.next;
    }
}