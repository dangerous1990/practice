package org.learn.leetcode.dp;

/**
 * https://leetcode.com/problems/combination-sum-iv/
 * Created by Administrator on 2016/12/5.
 */
public class CombinationSumIV {
    /**
     * 自底向上 递推式 comb[i] += comb[i - nums[j]];
     * sum 所有情况组合在一起
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }
        return comb[target];
    }
}
