package org.learn.leetcode.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/12.
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if ("".equals(words[i].trim())) {
                continue;
            } else {
                sb.append(words[i]).append(" ");
            }
        }
        return sb.substring(0, sb.length() - 1).toString();
    }


    @Test
    public void test() {
        System.out.println(reverseWords(" 1"));
    }
}
