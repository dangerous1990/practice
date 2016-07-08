package org.learn.jdk.juc;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    
    
    private static final ConcurrentHashMap<Long, Integer> map = new ConcurrentHashMap<>();
    
    public static void main(String[] args) {
        new Thread(new Runnable() {
            
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("add");
                    map.put(i + 1000l, i);
                    try {
                        Thread.sleep(1000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            
            public void run() {
                while (true) {
                    Iterator<Entry<Long, Integer>> test = map.entrySet().iterator();
                    while (test.hasNext()) {
                        System.out.println("remove");
                        test.next();
                        test.remove();
                        try {
                            Thread.sleep(500l);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
