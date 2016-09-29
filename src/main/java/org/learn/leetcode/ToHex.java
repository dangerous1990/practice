package org.learn.leetcode;

/**
 * Created by Administrator on 2016/9/27.
 */
public class ToHex {

    char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex(int num) {
        if (num == 0) return "0";
        String result = "";
        while (num != 0) {
            result = map[(num & 0x0F)] + result;
            num = (num >>> 4);
        }
        return result;
    }

}
