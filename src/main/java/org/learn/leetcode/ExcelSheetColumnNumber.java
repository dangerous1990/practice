package org.learn.leetcode;

public class ExcelSheetColumnNumber {
    
    public int titleToNumber(String s) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++)
            ret += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length() - i);
        return ret;
    }
}
