package org.learn.leetcode;

/**
 * 0ms
 * Created by Administrator on 2016/8/1.
 */
public class NimGame {

    public boolean canWinNim(int n) {
        return !(n % 4 == 0);
    }
}
