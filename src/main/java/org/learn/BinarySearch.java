package org.learn;

/**
 * 二分查找
 * Created by dangerous on 2017/3/1.
 */
public class BinarySearch {
    /**
     * while循环
     *
     * @param array
     * @param key
     * @return
     */
    public int normal(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < array[mid]) {
                high = mid - 1;
            } else if (key > array[mid]) {
                low = mid + 1;
            }
            if (array[mid] == key) {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归二分查找
     *
     * @param array
     * @param key
     * @param low
     * @param high
     * @return
     */
    public int rank(int[] array, int key, int low, int high, int depth) {
        tab(depth++);
        if (low >= high) {
            return -1;
        }
        System.out.println("low: " + low + " high: " + high);
        int mid = low + (high - low) / 2;
        if (key < array[mid]) {
            return rank(array, key, low, mid - 1, depth);
        } else if (key > array[mid]) {
            return rank(array, key, mid + 1, high, depth);
        }
        return mid;
    }

    private void tab(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print(" ");
        }
    }


}
