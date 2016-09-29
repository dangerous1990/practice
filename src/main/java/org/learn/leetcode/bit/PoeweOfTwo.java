package org.learn.leetcode.bit;

/**
 * Created by Administrator on 2016/9/20.
 */
public class PoeweOfTwo {
    public boolean isPowerOfTwo(int n) {
        long k = Integer.MAX_VALUE + 1;
        return n > 0 && k % n == 0;
    }

    public boolean isPowerOfTwoWithBit(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }


}
