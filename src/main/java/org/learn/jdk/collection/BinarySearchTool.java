package org.learn.jdk.collection;

public class BinarySearchTool {
    
    public static int BinarySearch(Integer[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        int middle = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            int middleValue = array[middle];
            if (middleValue < key) {
                low = middle + 1;
            } else if (middleValue > key) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -(low + 1);
    }
}
