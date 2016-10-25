package org.learn.leetcode.integer;

/**
 * Created by Administrator on 2016/10/25.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i];
            carry = (temp + 1) / 10;
            digits[i] = (temp + 1) % 10;
            if (carry == 0) {
                break;
            }
        }
        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
