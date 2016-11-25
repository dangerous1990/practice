package org.learn.leetcode.dp;

/**
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 * Created by Administrator on 2016/11/23.
 */
public class CountNumbersWithUniqueDigits {
    /**
     * res[0] = 1,
     * res[1] = 9,
     * res[2] = 9 * 9 = 9 * res[1],
     * res[3] = 9 * 9 * 8 = 8 * res[2],
     * res[4] = 9 * 9 * 8 * 7 = 7 * res[3].
     *
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        int res[] = new int[n + 1];
        res[0] = 1;
        int sum = 1;
        int k = 9;
        for (int i = 1; i <= n && k > 0; i++) {
            if (i == 1) {
                res[i] += res[i - 1] * 9;
            } else {
                res[i] += res[i - 1] * k--;
            }
            sum += res[i];
        }
        return sum;
    }
}
