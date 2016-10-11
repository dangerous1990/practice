package org.learn.leetcode.array;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 *
 * Created by Administrator on 2016/9/6.
 */
public class ShuffleAnArray {
    int[] origin = null;
    int[] suffle = null;
    ArrayList<Integer> list = new ArrayList<>();
    public ShuffleAnArray(int[] nums) {
        origin = nums;
        suffle = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return origin;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i=suffle.length; i>1; i--){
            swap(suffle, i-1, new Random().nextInt(i));
        }
        return  suffle;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
