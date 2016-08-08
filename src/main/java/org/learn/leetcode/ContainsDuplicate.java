package org.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/8/8.
 */
public class ContainsDuplicate {
    /**
     * time limit
     * list.contains//遍历所有元素判断是否存在
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            if (list.contains(num)) {
                return true;
            } else {
                list.add(num);
            }
        }
        return false;
    }

    /**
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
