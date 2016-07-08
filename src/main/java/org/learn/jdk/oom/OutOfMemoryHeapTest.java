package org.learn.jdk.oom;

/**
 * 数组，静态变量，成员变量 存储在堆中
 * 
 * @author admin
 */
public class OutOfMemoryHeapTest {
    
    
    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        int[] arrays = new int[max];// Requested array size exceeds VM limit
        // int[] arrays = new int[max-2];//java.lang.OutOfMemoryError: Java heap space
    }
}
