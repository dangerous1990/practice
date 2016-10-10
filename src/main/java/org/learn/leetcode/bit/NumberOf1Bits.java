package org.learn.leetcode.bit;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 * Created by Administrator on 2016/10/10.
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
