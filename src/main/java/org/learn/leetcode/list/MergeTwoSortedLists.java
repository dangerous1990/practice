package org.learn.leetcode.list;

/**
 * Created by Administrator on 2016/10/11.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode orgin = new ListNode(0);
        ListNode head = orgin;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        while (l1 != null) {
            head.next = l1;
            l1 = l1.next;
            head = head.next;
        }
        while (l2 != null) {
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }
        return orgin.next;
    }
}
