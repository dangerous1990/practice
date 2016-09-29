package org.learn.leetcode.bit;

/**
 * https://leetcode.com/problems/single-number-ii/
 * Created by Administrator on 2016/9/29.
 */
public class SingalNumber2 {
    public int singleNumber(int[] nums) {
        int length = nums.length;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            int mask = 1 << i;
            for (int j = 0; j < length; j++) {
                if ((nums[j] & mask) == 1)
                    count++;
            }
            if (count % 3 != 0)
                result |= mask;
        }
        return result;
    }
}
