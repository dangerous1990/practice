package org.learn.leetcode;

import java.util.Arrays;

import org.junit.Test;

/**
 * https://leetcode.com/problems/valid-anagram/
 * 
 * @author Administrator
 */
public class ValidAnagram {
    
    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);
        char[] s2 = t.toCharArray();
        Arrays.sort(s2);
        return new String(s1).equals(new String(s2));
    }
    
    @Test
    public void test() {
        System.out.println(isAnagram("aacc", "ccac"));
    }
}
