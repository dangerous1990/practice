package org.learn.leetcode.integer;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/add-digits/
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * For example:
 * <p>
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 *
 * @author Administrator
 */
public class AddDigits {

    /**
     * 递归
     *
     * @param num
     * @return
     */
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        String nums = String.valueOf(num);
        int sum = 0;
        for (int i = 0; i < nums.length(); i++) {
            sum += Integer.valueOf(nums.substring(i, i + 1));
        }
        return addDigits(sum);

    }

    /**
     * 最后返回一个数字，肯定是0-9
     *
     * @param num
     * @return
     */
    public int addDigitsWithMode(int num) {
        return (num - 1) % 9 + 1;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, addDigits(38));
        Assert.assertEquals(2, addDigitsWithMode(38));
    }
}
