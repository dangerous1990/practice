package org.learn.leetcode.dp;

import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016/11/3.
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        if (triangle.isEmpty()) {
            return 0;
        }
        //dp
        int dp[][] = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + list.get(j);
                } else if (j == list.size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + list.get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + list.get(j), dp[i - 1][j] + list.get(j));
                }
            }
        }
        // min value
        int min = dp[triangle.size() - 1][0];
        for (int i = 1; i < dp[triangle.size() - 1].length; i++) {
            min = Math.min(dp[triangle.size() - 1][i], min);
        }
        return min;
    }
}
