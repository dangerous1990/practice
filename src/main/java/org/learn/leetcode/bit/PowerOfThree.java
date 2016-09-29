package org.learn.leetcode.bit;

import org.junit.Test;

/**
 * Created by Administrator on 2016/9/20.
 */
public class PowerOfThree {
    @Test
    public void test() {
        for (int i = 0; i < 5; i++) {
            Double d = Math.pow(3D, i + 0D);
            System.out.println(Integer.toString(d.intValue(), 3).matches("^10*$"));
        }
    }

}
