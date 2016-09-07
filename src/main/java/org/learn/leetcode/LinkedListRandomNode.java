package org.learn.leetcode;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrator on 2016/9/6.
 */
public class LinkedListRandomNode {

    ArrayList<ListNode> list = new ArrayList<>();
    Random rnd = new Random();

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public LinkedListRandomNode(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int index = rnd.nextInt(list.size());
        return list.get(index).val;
    }
}
