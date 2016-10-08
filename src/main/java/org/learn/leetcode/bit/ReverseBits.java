package org.learn.leetcode.bit;

/**
 * https://leetcode.com/problems/reverse-bits/
 * Created by Administrator on 2016/9/30.
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if ((n & 1) == 1) {
                result = (result << 1) + 1;
            } else {
                result <<= 1;
            }
            n = n >> 1;
        }
        return result;
    }

}
