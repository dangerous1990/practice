package org.learn.jdk.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/**
 * @author admin
 */

public class CollectionSample {
    
    List<String> sharedList = new ArrayList<String>();
    
    @Before
    public void tearUp() {
        sharedList.add("beijing");
        sharedList.add("tianjin");
        sharedList.add("xian");
        sharedList.add("guanggzhou");
    }
    
    /**
     * List 有序 set 无序
     */
    @Test
    public void testSample() {
        List<String> arrayList = new ArrayList<String>();
        arrayList.addAll(sharedList);
        List<String> linkedList = new LinkedList<String>();
        linkedList.addAll(sharedList);
        Set<String> set = new HashSet<String>();
        set.addAll(sharedList);
        System.out.println("--------------------------------arrayList-------------------------");
        for (String string : arrayList) {
            System.out.println(string);
        }
        System.out.println("--------------------------------linkedList-------------------------");
        for (String string : linkedList) {
            System.out.println(string);
        }
        System.out.println("--------------------------------set-------------------------");
        for (String string : set) {
            System.out.println(string);
        }
        
    }
}
