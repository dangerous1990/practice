package org.learn.leetcode.array;

import org.junit.Test;

/**
 * Created by Administrator on 2016/9/7.
 */
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j == nums.length) {
                    break;
                }
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }

}
