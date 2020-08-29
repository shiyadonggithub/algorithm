package leetcode;

import akka.actor.FSM;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class _24SwapNodesInPairs {
    public static void main(String[] args) {
        _24SwapNodesInPairs swapNodesInPairs = new _24SwapNodesInPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        ListNode res =swapNodesInPairs.swapPairs(head);

        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode cur = head;
        ListNode pre = preHead;
        while (cur != null && cur.next != null) {
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = cur;
            pre = cur;
            cur = cur.next;

        }
        return preHead.next;
    }
}