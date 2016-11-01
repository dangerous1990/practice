package org.learn.leetcode.dp;

import org.junit.Test;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 * 根据规则只能向右或者向下移动，第一行只能加左边，第一列只能加上边
 * 其他行 取上或者左边的最小值加上本身的值 dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
 * Created by Administrator on 2016/11/1.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    @Test
    public void test() {
        minPathSum(new int[][]{{1, 2}, {1, 1}});
    }
}
