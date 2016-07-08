package org.learn.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 
 * @author Administrator
 */
public class TopKFrequentElements {
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        Collection<Integer> values = map.values();
        List<Integer> allResults = new ArrayList<>();
        allResults.addAll(values);
        Collections.sort(allResults);
        int frequenty = k;
        if (allResults.contains(k)) {
            frequenty = k;
        } else {
            frequenty = allResults.get(allResults.size() - 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().intValue() == frequenty) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
    
    @Test
    public void test() {
        System.out.println(topKFrequent(new int[] { 1, 1, 2, 2, 3 }, 2));
    }
}
