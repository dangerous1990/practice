package org.learn.leetcode;

/**
 * @author Administrator
 */
public class AddDigits {
    
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        String nums = String.valueOf(num);
        int sum = 0;
        for (int i = 0; i < nums.length(); i++) {
            sum += Integer.valueOf(nums.substring(i, i + 1));
        }
        return addDigits(sum);
        
    }
    
    public int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }
    
    public static void main(String[] args) {
        AddDigits add = new AddDigits();
        System.out.println(add.addDigits(38));
    }
}
