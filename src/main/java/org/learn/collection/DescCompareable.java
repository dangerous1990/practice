package org.learn.collection;

import java.util.Comparator;

public class DescCompareable implements Comparator<Integer> {
    
    
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.intValue() - o1.intValue();
    }
    
}
