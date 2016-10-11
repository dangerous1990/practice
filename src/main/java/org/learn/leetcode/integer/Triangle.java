package org.learn.leetcode.integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 杨辉三角
 * 
 * @author admin
 */
public class Triangle {
    
    
    public static List<List<Integer>> generate(int numRows) {
        
        int[][] yh = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            yh[i][0] = 1;
            yh[i][i] = 1;
        }
        for (int i = 2; i < numRows; i++) {
            for (int j = 1; j < i; j++)
                yh[i][j] = yh[i - 1][j - 1] + yh[i - 1][j];
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        if (numRows == 1) {
            list.add(Arrays.asList(new Integer[] { 1 }));
            return list;
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                temp.add(yh[i][j]);
            }
            
            list.add(new ArrayList<Integer>(temp));
            temp.clear();
        }
        return list;
    }
    
    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
