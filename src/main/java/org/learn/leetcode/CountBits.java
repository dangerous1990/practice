package org.learn.leetcode;

import org.junit.Test;

public class CountBits {
    
    
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for (int i = 0; i <= num; i++) {
            int count = 0 ;
            String binary = Integer.toBinaryString(i);
            for (int j = 0; j < binary.length(); j++) {
                if('1'==binary.charAt(j)){
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
    @Test
    public void test(){
        int[] result = countBits(5);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
