package org.learn.leetcode.dp;

/**
 * Created by Administrator on 2016/11/25.
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n < 2 || n > 58) {
            return 0;
        }
        int product = 1;
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        while (n - 3 >= 0 && n != 4) {
            product *= 3;
            n = n - 3;
        }
        while (n - 2 >= 0) {
            product *= 2;
            n = n - 2;
        }
        return product;
    }
}
