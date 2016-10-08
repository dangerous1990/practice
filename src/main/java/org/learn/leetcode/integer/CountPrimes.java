package org.learn.leetcode.integer;

/**
 * https://leetcode.com/problems/count-primes/
 * Created by Administrator on 2016/10/8.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        byte[] origin = new byte[n + 1];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (origin[i] == 0) {
                count++;
                int k = 2;
                while (i * k <= n) {
                    origin[i * k] = 1;
                    k++;
                }
            } else {
                continue;
            }
        }
        return count;
    }
}
