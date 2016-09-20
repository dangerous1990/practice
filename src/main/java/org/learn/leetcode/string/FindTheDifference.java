package org.learn.leetcode.string;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-the-difference/
 * Given two strings s and t which consist of only lowercase letters.
 * <p>
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 * <p>
 * Find the letter that was added in t.
 * Created by Administrator on 2016/9/6.
 */
public class FindTheDifference {
    /**
     * @param s
     * @param t
     * @return
     */
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