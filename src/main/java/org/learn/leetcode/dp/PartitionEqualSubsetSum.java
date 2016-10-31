package org.learn.leetcode.dp;

/**
 * Created by Administrator on 2016/10/31.
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int halfSum = sum / 2;
        if (max > halfSum) {
            return false;
        }

        return canPartition(nums.length - 1, halfSum, nums);
    }

    private boolean canPartition(int index, int target, int[] nums) {

        if (index < 0) {
            return false;
        }
        if (nums[index] == target) {
            return true;
        }
        target = target - nums[index];
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] == target)
                return true;
            if (nums[i] <= target) {
                boolean temp = canPartition(i - 1, target - nums[i], nums);
                if (temp) {
                    return true;
                }
            }
        }
        return false;
    }


}
