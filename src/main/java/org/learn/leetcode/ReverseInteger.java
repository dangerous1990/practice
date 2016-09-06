package org.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2016/9/2.
 */
public class ReverseInteger {

    public int reverse(int x) {
        String str = new StringBuilder(x+"").reverse().toString();
        if(x<0){
            str = str.charAt(str.length()-1)+str.substring(0, str.length()-1);
        }
        long num = Long.parseLong(str);
        if(num > Integer.MAX_VALUE || num < Integer.MIN_VALUE)
            return 0;
        return Integer.parseInt(str);
    }


    @Test
    public void  test(){
        Assert.assertEquals(reverse(123),321);
    }
}
