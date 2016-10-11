package org.learn.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Administrator
 */
public class IntersectionOfTwoArrays {
    
    /**
     * https://leetcode.com/problems/intersection-of-two-arrays/
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if (nums.contains(Integer.valueOf(nums1[i]))) {
                continue;
            }
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    nums.add(nums1[i]);
                    break;
                }
            }
        }
        Integer[] preresult = nums.toArray(new Integer[0]);
        int[] result = new int[preresult.length];
        for (int i = 0; i < preresult.length; i++) {
            result[i] = preresult[i];
        }
        return result;
    }
    
    /**
     * https://leetcode.com/problems/intersection-of-two-arrays-ii/
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> countn1 = new HashMap<>();
        Map<Integer, Integer> countn2 = new HashMap<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        for (int i = 0; i < n1; i++) {
            if (countn1.containsKey(Integer.valueOf(nums1[i]))) {
                countn1.put(nums1[i], countn1.get(nums1[i]) + 1);
            } else {
                countn1.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < n2; i++) {
            if (countn2.containsKey(Integer.valueOf(nums2[i]))) {
                countn2.put(nums2[i], countn2.get(nums2[i]) + 1);
            } else {
                countn2.put(nums2[i], 1);
            }
        }
        List<Integer> nums = new ArrayList<>();
        
        if (n1 < n2) {
            for (Map.Entry<Integer, Integer> entry : countn1.entrySet()) {
                if (countn2.containsKey(entry.getKey())) {
                    int n1c = entry.getValue();
                    int n2c = countn2.get(entry.getKey());
                    for (int i = 0; i < Math.min(n1c, n2c); i++) {
                        nums.add(entry.getKey());
                    }
                }
                
            }
        } else {
            for (Map.Entry<Integer, Integer> entry : countn2.entrySet()) {
                if (countn1.containsKey(entry.getKey())) {
                    int n1c = entry.getValue();
                    int n2c = countn1.get(entry.getKey());
                    for (int i = 0; i < Math.min(n1c, n2c); i++) {
                        nums.add(entry.getKey());
                    }
                }
                
            }
        }
        int[] result = new int[nums.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = nums.get(i);
            System.out.println(nums.get(i));
        }
        return result;
    }
    
    public static void main(String[] args) {
        IntersectionOfTwoArrays add = new IntersectionOfTwoArrays();
        add.intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 });
        add.intersect(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 });
    }
}
