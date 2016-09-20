package org.learn.leetcode;

import java.util.*;

import org.junit.Test;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * @author Administrator
 */
public class TopKFrequentElements {
    /**
     * 统计数量
     * 按照数量排序
     * 取得前K个数量最多的元素
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]) + 1;
                map.put(nums[i], count);
            } else {
                map.put(nums[i], 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        for (int i = list.size() - 1; i >= list.size() - k; i--) {
            result.add(list.get(i).getKey());
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }

}
