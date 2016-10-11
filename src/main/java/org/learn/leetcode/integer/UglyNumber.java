package org.learn.leetcode.integer;

/**
 * Created by Administrator on 2016/10/11.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        while (num % 2 == 0)
            num /= 2;
        while (num % 3 == 0)
            num /= 3;
        while (num % 5 == 0)
            num /= 5;
        return num == 1;
    }
}
