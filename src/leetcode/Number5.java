package leetcode;

import algorithm.ListNode;

/**
 * @author liuxinyi
 * @description 使用插入排序对链表进行排序。
 * @since 2019/11/19
 */
public class Number5 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode anotherHead = head;
        ListNode pre = head.next;
        while(pre != null) {
            ListNode anotherPre = anotherHead;
            ListNode anotherNext = anotherHead;
            for (; anotherPre != null; anotherPre = anotherPre.next) {
                if (anotherPre != anotherHead.next && anotherPre != anotherHead) {
                    anotherNext = anotherNext.next;
                }
                if (pre.val < anotherPre.val) {
                    ListNode temp = pre;
                    pre = pre.next;
                    anotherNext.next = temp;
                    temp.next = anotherHead;
                    break;
                }
            }
            if (anotherPre == null) {
                ListNode temp = pre;
                pre = pre.next;
                anotherNext.next = temp;
                temp.next = null;
            }
        }
        return anotherHead;
    }
}
