package org.learn.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/9/7.
 */
public class TwoSum2 {

    /**
     * 48ms accepted
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length <= 1) {
            return new int[]{0};
        }
        int[] result = new int[2];
        for (int i = 0; i <= numbers.length - 1; i++) {
            for (int j = i + 1; j <= numbers.length - 1; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
                if (numbers[i] + numbers[j] > target) {
                    break;
                }
            }
        }
        return result;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int low = i;
            int high = numbers.length - 1;
            while (low <= high) {
                int middle = (high - low) / 2 + 1;
                if (numbers[middle] + numbers[i] == target) {
                    result[0] = i + 1;
                    result[1] = middle + 1;
                    return result;
                } else if (numbers[middle] + numbers[i] < target) {
                    high = middle;
                } else {
                    break;
                }
            }
        }
        return result;
    }


}
