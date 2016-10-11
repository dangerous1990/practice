package org.learn.leetcode.list;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * Created by Administrator on 2016/10/11.
 */
public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        if (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
