package org.learn.leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/9/6.
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        for (int i = 0; i < sArray.length - 1; i++) {
            if (sArray[i] != tArray[i]) {
                return tArray[i];
            }
        }
        return tArray[tArray.length - 1];
    }

    public char solutionWithSum(String s, String t) {
        char sum_s = 'a';
        char sum_t = 'a';
        int i = 0;
        for (; i < s.length(); i++) {
            sum_s += s.charAt(i);
            sum_t += t.charAt(i);
        }
        sum_t += t.charAt(i);
        return (char) (sum_t - sum_s);
    }

    public char solutionWithXOR(String s, String t) {
        int c = 0;
        for (int i = 0; i < s.length(); ++i) {
            c = c ^ s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            c = c ^ t.charAt(i);
        }
        return (char) c;
    }
}
