package algorithm.lxy.linkedList;

import algorithm.ListNode;

/**
 * @author liuxinyi
 * @description 在O(n log n)的时间内使用常数级空间复杂度对链表进行排序。
 * @since 2019/11/4
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = head;
        // 先把最小的数找出来
        ListNode minNode = head;
        ListNode preNode = head;
        for (ListNode node = minNode.next; node != null && preNode != null; node = node.next, preNode = preNode.next) {
            if (node.val < minNode.val) {
                minNode = node;
            }
        }
        head = minNode;
        preNode.next = minNode.next;
        minNode.next = listNode;

        listNode = head;
        ListNode swapNode = head.next;
        for (ListNode listNode1 = head.next.next; listNode1 != null; listNode1 = listNode1.next) {
            for (; swapNode != null && listNode != null; swapNode = swapNode.next, listNode = listNode.next) {
                if (listNode1.val <= swapNode.val) {
                    listNode.next = listNode1;
                    swapNode.next = listNode1.next;
                    listNode1.next = swapNode;
                }
            }
        }
        return head;
    }
}
