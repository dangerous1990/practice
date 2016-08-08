package org.learn.leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/2.
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int temp = 0;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            if(nums[i]==0){
                zeroCount++;
            }
            while (nums[i] == 0 && count < nums.length-i) {
                count++;
                for (int j = i; j < nums.length - zeroCount; j++) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 1ms From discuss
     * @param nums
     */
    public void moveZeroesWith1ms(int[] nums) {
        int C = 0;  // count of zeros
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            if (nums[i] == 0)   C++;
            else if (C != 0)    nums[i-C] = nums[i];
        }
        for (int i = N-C; i < N; i++)   nums[i] = 0;
    }
}
