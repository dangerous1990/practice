package org.learn.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * copyOnWrite并发实验
 * @author admin
 *
 */
public class CurrectExample {
	
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Android");
		list.add("iPhone");
		list.add("Windows Mobile");
		final List<String> cowList = new CopyOnWriteArrayList<String>(list);
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					System.out.println("线程1--正在添加元素--------------");
					cowList.add("" + i);
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("线程2正在读取元素--------------");
				for (String string : cowList) {
					System.out.println("线程2--" + string);
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("线程3正在删除元素--------------");
				for (String string : cowList) {
					System.out.println("线程3--" + string);
					cowList.remove(string);
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("线程4正在读取元素--------------");
				for (String string : cowList) {
					System.out.println("线程4--" + string);
				}
			}
		}).start();
		System.out.println("主线程读取元素-------");
		for (String string : cowList) {
			System.out.println("主线程"+string);
		}
	}
}
