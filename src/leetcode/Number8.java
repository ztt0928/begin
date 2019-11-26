package leetcode;

import algorithm.ListNode;

/**
 * @author liuxinyi
 * @description 将给定的单链表L： L 0→L 1→…→L n-1→L n,
 * 重新排序为： L 0→L n →L 1→L n-1→L 2→L n-2→…
 * 要求使用原地算法，并且不改变节点的值
 * @since 2019/11/26
 */
public class Number8 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 快慢指针找到中间节点
        ListNode fast = head;
        ListNode low = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            low = low.next;
        }

        // 反转后面的节点
        ListNode pre = null;
        ListNode next = null;
        ListNode afterHead = low.next;
        while (afterHead != null) {
            next = afterHead.next;
            afterHead.next = pre;
            pre = afterHead;
            afterHead = next;
        }

        // 合并两个链表
        ListNode first = head;
        afterHead = pre;
        while (first != null && afterHead != null) {
            ListNode firstTemp = first.next;
            ListNode afterTemp = afterHead.next;
            first.next = afterHead;
            afterHead.next = firstTemp;
            first = firstTemp;
            afterHead = afterTemp;
        }
    }
}
