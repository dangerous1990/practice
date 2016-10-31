package org.learn.leetcode.dp;

import org.junit.Test;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 * 思路sums[i] = nums[i]+sums[i-1];
 * Created by Administrator on 2016/10/31.
 */
public class NumArray {
    int[] nums = null;
    int[] sums = null;

    public NumArray(int[] nums) {
        this.nums = nums;
        if (nums.length == 0) {
            return;
        }
        sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = nums[i] + sums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        if (nums.length == 0) {
            return 0;
        }
        if (i == 0) {
            return sums[j];
        }
        return sums[j] - sums[i - 1];
    }

    public static void main(String[] args) {
        NumArray na = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        for (int x : na.sums
                ) {
            System.out.print(x);
            System.out.print(",");


        }
        System.out.println();
        System.out.println(na.sumRange(0, 2));//1
        System.out.println(na.sumRange(2, 5));//-1
        System.out.println(na.sumRange(0, 5));//-3
    }


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
}
