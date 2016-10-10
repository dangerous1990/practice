package org.learn.leetcode.integer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/9.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        int sum = 0;
        boolean isContainsOdd = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                isContainsOdd = true;
            }
            sum += entry.getValue() / 2;
        }

        return isContainsOdd ? sum * 2 + 1 : sum * 2;
    }
}
