package org.learn.leetcode.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * Created by Administrator on 2016/11/23.
 */
public class MaximumSubarray {
    /**
     * time limit
     *
     * @param nums
     * @return
     */
    public int maxSubArray(Integer[] nums) {
        int dp[][] = new int[nums.length][nums.length];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
            max = Math.max(max, dp[i][i]);
            if (i == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    dp[i][j] = dp[i][j - 1] + nums[j];
                    max = Math.max(max, dp[i][j]);
                }
                print(dp[i]);
            } else {
                for (int j = i + 1; j < nums.length; j++) {
                    dp[i][j] = dp[i - 1][j] - dp[i - 1][i - 1];
                    max = Math.max(max, dp[i][j]);
                }
                print(dp[i]);
            }
        }
        return max;
    }

    public void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf(a[i] + ",");
        }
        System.out.println();
    }

    @Test
    public void test() {
        int xx = maxSubArray(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4).toArray(new Integer[0]));
        int xx1 = maxSubArray(Arrays.asList(-1, 1, 2, 1).toArray(new Integer[0]));
        System.out.println(xx);
        System.out.println(xx1);
    }

    /**
     * 短路 如果前面的值小于和小于当前值，放弃前面的累加和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

}
