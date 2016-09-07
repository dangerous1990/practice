package org.learn.leetcode;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/7.
 */
public class RansomNote {


    public boolean canConstruct(String ransomNote, String magazine) {
        for (int i = 0; i < ransomNote.length(); i++) {

            int index = magazine.indexOf(ransomNote.charAt(i));
            if (index != -1) {
                magazine = magazine.replaceFirst(String.valueOf(ransomNote.charAt(i)), "");
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用数组存每个英文字符出现的次数，类似于map
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstructWithLikeMap(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[] arr = new int[26];
        System.out.println(arr[0]);
    }

}
