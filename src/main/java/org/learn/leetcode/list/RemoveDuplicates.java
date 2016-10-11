package org.learn.leetcode.list;

import org.junit.Test;

import java.util.HashSet;

/**
 * Created by Administrator on 2016/10/11.
 */
public class RemoveDuplicates {
    /**
     * 5ms accept ignore sorted
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode node = head;
        ListNode before = null;
        while (head != null) {
            if (set.contains(head.val)) {
                if (head.next != null) {
                    head.next = head.next.next;
                } else {
                    before.next = null;
                    head = null;
                }
            } else {
                set.add(head.val);
                before = head;
                head = head.next;
            }
        }
        return node;
    }

    /**
     * 1ms
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1ms(ListNode head) {
        ListNode node = head;
        ListNode last = null;
        while (head != null && head.next != null) {
            last = head.next;
            if (head.val == last.val) {
                head.next = last.next;
            } else {
                head = last;
            }
        }
        return node;
    }

    @Test
    public void test() {

    }
}
