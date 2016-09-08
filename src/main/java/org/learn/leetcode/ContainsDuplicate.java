package org.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/8/8.
 */
public class ContainsDuplicate {

    /**
     * 排序，判断连续2个位置是否相等
     * 6ms
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        if(nums.length==0){
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i <nums.length-1 ; i++) {
            if(nums[i] ==nums[i+1]){
                return true;
            }
        }
        return false;
    }

}
