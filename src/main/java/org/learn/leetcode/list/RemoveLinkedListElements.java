package org.learn.leetcode.list;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 * Created by Administrator on 2016/10/11.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode cur = head;
        ListNode prev = first;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return first.next;
    }

}
