package org.learn.leetcode;

import org.junit.Test;

/**
 * https://leetcode.com/problems/counting-bits/
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 *
 * @author
 */
public class CountBits {


    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int count = 0;
            String binary = Integer.toBinaryString(i);
            for (int j = 0; j < binary.length(); j++) {
                if ('1' == binary.charAt(j)) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public int[] countBitsWithBit(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int count = 0;
            int j = i;
            while (j > 0) {
                if ((j & 1) == 1) {
                    count++;
                }
                j = j >> 1;
            }
            result[i] = count;
        }
        return result;
    }

    @Test
    public void testCountBitsWithBit() {
        int[] x = countBitsWithBit(2);
        for (int t : x) {
            System.out.println(t);
        }
    }

    public int[] countBits3ms(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            // Obviously,
            // if i is even, then it should be i / 2 + "0"
            // if i is odd, it should be i / 2 + "1"
            // e.g.   8 --> 1000, 16 --> 1000 0, 17 --> 1000 1
            result[i] = result[i / 2] + i % 2;
        }
        return result;
    }

}
