package org.learn.leetcode.dp;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * Created by Administrator on 2016/10/31.
 */
public class ClimbingStairs {

    /**
     * 一次只能爬一步或者两步，所以走i步可由走i-1步的方法数和走i-2步的方法数相加获得；
     * 设dp[i]为走i步的方法数目，则dp[i]=dp[i-1]+dp[i-2];
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
