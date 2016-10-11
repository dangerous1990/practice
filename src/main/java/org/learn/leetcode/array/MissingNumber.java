package org.learn.leetcode.array;

import java.util.Arrays;

/**
 * sum = n(n+1)/2
 * 
 * @author Administrator
 */
public class MissingNumber {
    
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] - nums[i - 1] >= 2) {
                return nums[i] - 1;
            }
        }
        if (nums[0] != 0) {
            return nums[0] - 1;
        } else {
            return nums[length - 1] + 1;
        }
    }
    
    public int missingNumber2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        return (nums.length * (nums.length + 1)) / 2 - sum;
    }
}
