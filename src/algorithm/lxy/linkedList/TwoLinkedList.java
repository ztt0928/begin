package algorithm.lxy.linkedList;

import algorithm.ListNode;

/**
 * @author liuxinyi
 * @description 输入两个链表，找出它们的第一个公共结点。
 * @since 2019/11/12
 */
public class TwoLinkedList {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode node1 = pHead1;
        int length1 = 0;
        ListNode node2 = pHead2;
        int length2 = 0;
        while (node1.next != null) {
            node1 = node1.next;
            length1++;
        }
        while (node2.next != null) {
            node2 = node2.next;
            length2++;
        }
        if (node1.equals(node2)) {
            node1 = pHead1;
            node2 = pHead2;
            if (length1 > length2) {
                for (int i = 1; i <= length1 - length2; i++) {
                    node1 = node1.next;
                }
                while (!node1.equals(node2)) {
                    node1 = node1.next;
                    node2 = node2.next;
                }
                return node1;
            } else {
                for (int i = 1; i <= length2 - length1; i++) {
                    node2 = node2.next;
                }
                while (!node1.equals(node2)) {
                    node1 = node1.next;
                    node2 = node2.next;
                }
                return node2;
            }
        }
        return null;
    }
}
