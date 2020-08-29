package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _23MergeKSortedLists {
    public static void main(String[] args) {
        _23MergeKSortedLists mergeKSortedLists = new _23MergeKSortedLists();
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> integers = new PriorityQueue<>(cmp);
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                integers.add(lists[i]);
        }

        while (!integers.isEmpty()) {
            cur.next = integers.poll();
            cur = cur.next;
            if (cur.next != null) {
                integers.add(cur.next);
            }
        }
        return head.next;
    }

    Comparator<ListNode> cmp = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    };
}