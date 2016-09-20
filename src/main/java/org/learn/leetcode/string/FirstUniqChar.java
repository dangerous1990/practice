package org.learn.leetcode.string;

import java.util.*;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * Created by Administrator on 2016/9/18.
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                map.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
                map.put(s.charAt(i), i);
            }
        }
        if (map.values().isEmpty()) {
            return -1;
        }
        Integer[] list = map.values().toArray(new Integer[0]);
        Arrays.sort(list);
        return list[0];
    }

    /**
     * Use two arrays to keep track of the frequency and location of each char in s.
     * In the second loop, get the min location of frequency 1
     *
     * @param s
     * @return
     */
    public int firstUniqCharWith26(String s) {
        int n = s.length();
        int[] alp = new int[26];
        int[] loc = new int[26];

        for (int i = 0; i < n; ++i) {
            alp[s.charAt(i) - 'a']++;
            loc[s.charAt(i) - 'a'] = i;
        }

        int ret = -1;
        for (int i = 0; i < 26; ++i) {
            if (alp[i] == 1) {
                ret = ret == -1 ? loc[i] : Math.min(ret, loc[i]);
            }
        }

        return ret;
    }
}
