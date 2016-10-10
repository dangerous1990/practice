package org.learn.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2016/10/10.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        String max = null;
        String min = null;
        if (num1.length() > num2.length()) {
            min = new StringBuilder(num2).reverse().toString();
            max = new StringBuilder(num1).reverse().toString();
        } else {
            min = new StringBuilder(num1).reverse().toString();
            max = new StringBuilder(num2).reverse().toString();
        }
        StringBuilder sb = new StringBuilder("");
        boolean isOver = false;
        for (int i = 0; i < max.length(); i++) {
            if (i < min.length()) {
                int n = min.charAt(i) + max.charAt(i) - 96;
                n = isOver ? n + 1 : n;
                if (n >= 10) {
                    sb.append(n % 10);
                    isOver = true;
                } else {
                    sb.append(n);
                    isOver = false;
                }
            } else {
                int n = max.charAt(i) - 48;
                n = isOver ? n + 1 : n;
                if (n >= 10) {
                    sb.append(n % 10);
                    isOver = true;
                } else {
                    sb.append(n);
                    isOver = false;
                }
            }
        }
        if (isOver) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }


    @Test
    public void test() {
        Assert.assertEquals("100", addStrings("90", "10"));
        Assert.assertEquals("910", addStrings("900", "10"));
    }

    public String addStrings2(String num1, String num2) {
        int sum = 0, carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) sum = num1.charAt(i) + num2.charAt(j) - 96 + carry;
            else if (i >= 0) sum = num1.charAt(i) - 48 + carry;
            else if (j >= 0) sum = num2.charAt(j) - 48 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            i--;
            j--;
        }
        if (carry == 1) sb.append("1");
        return sb.reverse().toString();
    }
}
