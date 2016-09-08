package org.learn.leetcode;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */
public class ExcelSheetColumnNumber {
    /**
     * 26进制转换10进制
     *
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++)
            ret += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length() - i);
        return ret;
    }
}
