package org.learn.leetcode;

/**
 * 0ms
 * Created by Administrator on 2016/8/1.
 */
public class NimGame {
    public boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        }
        int count = n / 4;
        if (n % 4 == 0) {
            return false;
        }

        if (n - 1 == 4 * count) {
            return true;
        }
        if (n - 2 == 4 * count) {
            return true;
        }
        if (n - 3 == 4 * count) {
            return true;
        }
        return false;
    }

    public boolean canWinNim2(int n) {
        return !(n % 4 == 0);
    }
}
