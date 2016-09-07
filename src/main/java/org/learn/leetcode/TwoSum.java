package org.learn.leetcode;

import org.junit.Test;

/**
 * Created by Administrator on 2016/9/7.
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length <= 1) {
            return new int[]{0};
        }
        int[] result = new int[2];
        for (int i = 0; i <= numbers.length - 1; i++) {
            for (int j = i + 1; j <= numbers.length - 1; j++) {
                if (numbers[j] > target) {
                    break;
                }
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] result = twoSum(new int[]{2, 3, 4}, 6);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
