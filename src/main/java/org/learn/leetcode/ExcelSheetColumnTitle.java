package org.learn.leetcode;

import junit.framework.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * Created by Administrator on 2016/9/8.
 */
public class ExcelSheetColumnTitle {
    /**
     * n%进制 = 取个位
     * n/进制 = 去掉各位数
     *
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        String result = "";
        while (n != 0) {
            char p = (char) (--n % 26 + 'A');
            result = p + result;
            n = n / 26;
        }
        return result;
    }

    @Test
    public void test() {
        Assert.assertEquals("Z", convertToTitle(26));
    }

}
