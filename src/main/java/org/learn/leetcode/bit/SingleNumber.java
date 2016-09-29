package org.learn.leetcode.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * map,set,list 统计出现次数，不符合线性复杂度，超时
 * 采用亦或运算满足复杂度 0^8 = 8 亦或运算相同为0，不同为1
 * 
 * @author admin
 */
public class SingleNumber {
    
    /**
     * 未通过
     * 
     * @param A
     * @return
     */
    public int singleNumber(int[] A) {
        List<Integer> map = new ArrayList<Integer>();
        for (int i = 0; i < A.length; i++) {
            if (map.contains(A[i])) {
                map.remove(Integer.valueOf(A[i]));
            } else {
                map.add(A[i]);
            }
        }
        return (int) map.get(0);
    }
    
    /**
     * pass
     * 
     * @param A
     * @return
     */
    public int singleNumber2(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result = result ^ A[i];
        }
        return result;
    }
    
    public static void main(String[] args) {
        int a = 0;
        System.out.println(a ^ 24);
    }
}
