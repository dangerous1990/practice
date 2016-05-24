package org.learn.concurrent;

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
						// TODO Auto-generated catch block
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
						Entry<Long, Integer> enrty = test.next();
						test.remove();
						try {
							Thread.sleep(500l);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
	}
}
