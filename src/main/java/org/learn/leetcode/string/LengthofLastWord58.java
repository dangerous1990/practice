package org.learn.leetcode.string;

/**
 * https://leetcode.com/problems/length-of-last-word/
 * Created by Administrator on 2016/10/8.
 */
public class LengthofLastWord58 {
    public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        if (strs.length == 0) {
            return 0;
        } else {
            return strs[strs.length - 1].length();
        }
    }
}
