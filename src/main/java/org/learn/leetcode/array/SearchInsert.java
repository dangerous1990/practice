package org.learn.leetcode.array;

/**
 * Created by Administrator on 2016/9/21.
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (high - low) / 2; //+ low; // 直接使用(high + low) / 2 可能导致溢出
            if (nums[middle] == target)
                return middle;
                //在左半边
            else if (nums[middle] > target)
                high = middle - 1;
                //在右半边
            else
                low = middle + 1;
        }
        //没找到
        return low;

    }
}
