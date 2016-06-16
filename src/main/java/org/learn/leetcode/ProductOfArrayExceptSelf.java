package org.learn.leetcode;

import java.util.ArrayList;

import org.junit.Test;

public class ProductOfArrayExceptSelf {
	/**
	 * 自己写的
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {
		int sum = 1;
		ArrayList<Integer> zeroIndexes = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zeroIndexes.add(i);
			}
			if (nums[i] != 0) {
				sum *= nums[i];
			}

		}
		int length = nums.length;
		int zeroIndexesLength = zeroIndexes.size();
		int[] result = new int[nums.length];
		for (int i = 0; i < length; i++) {
			if (zeroIndexes.contains(i)) {
				if (zeroIndexesLength > 1) {
					result[i] = 0;
				} else {
					result[i] = sum;
				}
			} else if (zeroIndexesLength > 0) {
				result[i] = 0;
			} else {
				result[i] = sum / nums[i];
			}
		}
		return result;
	}
	
    /**
     * 3ms
     * @param nums
     * @return
     */
    public int[] productExceptSelf1(int[] nums) {
        int[] res = new int[nums.length];

        res[0] = 1;
        for(int i=1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        for(int j = nums.length - 1; j > 0; j--) {
            res[j] *= res[0];
            res[0] *= nums[j];
        }
        return res;
    }

	@Test
	public void test() {
		ProductOfArrayExceptSelf poaes = new ProductOfArrayExceptSelf();
		int[] result = poaes.productExceptSelf(new int[] { 1, 0 });
		for (int i : result) {
			System.out.println(i);
		}
	}
}
