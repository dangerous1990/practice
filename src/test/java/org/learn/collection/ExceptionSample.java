package org.learn.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;

public class ExceptionSample {

	public int titleToNumber(String s) {
		int ret = 0;
		for (int i = 0; i < s.length(); i++)
			ret = ret * 26 + (s.charAt(i) - 'A' + 1);
		return ret;
	}

	@Test
	public void test() {
		List<String> list = new ArrayList<String>(200000000);
		for (int i = 0; i < 200000000; i++) {
			list.add("test");
		}

		int length = list.size();
		long start = System.currentTimeMillis();
		for (int i = 0; i < length; i++) {
			list.get(i);
		}
		System.out.println(System.currentTimeMillis() - start);

		long start2 = System.currentTimeMillis();
		for (int i = 0; i < list.size(); i++) {
			list.get(i);
		}
		System.out.println(System.currentTimeMillis() - start2);

	}

	@Test
	public void sample1() {
		List<String> list = new ArrayList<String>();
		list.add("Android");
		list.add("iPhone");
		list.add("Windows Mobile");
		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
			// String lang = itr.next();
			itr.remove();
		}
		System.out.println(list.size());
	}

	@Test
	public void sample2() {
		List<String> list = new ArrayList<String>();
		list.add("Android");
		list.add("iPhone");
		list.add("Windows Mobile");
		for (String language : list) {
			list.add(language);
		}
	}

	@Test
	public void sample3() {
		List<String> list = new ArrayList<String>();
		list.add("Android");
		list.add("iPhone");
		list.add("Windows Mobile");
		for (int i = 0; i < list.size(); i++) {
			list.remove(list.get(i));
		}

		System.out.println(list.size());
	}

	@Test
	public void sample4() {
		List<String> list = new ArrayList<String>();
		list.add("Android");
		list.add("iPhone");
		list.add("Windows Mobile");
		for (String language : list) {
			list.add(language);
		}
	}

	/**
	 * 解决方法一 使用iterator
	 */
	@Test
	public void sample5() {
		List<String> list = new ArrayList<String>();
		list.add("Android");
		list.add("iPhone");
		list.add("Windows Mobile");
		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
			itr.next();
			itr.remove();// 不调用next方法,无法进行remove
		}
	}

	/**
	 * 解决方法二 使用copyOnWriteList
	 */
	@Test
	public void sample6() {
		List<String> list = new ArrayList<String>();
		list.add("Android");
		list.add("iPhone");
		list.add("Windows Mobile");
		List<String> cowList = new CopyOnWriteArrayList<String>(list);
		for (String language : cowList) {
			list.remove(language);
		}
	}

	/**
	 * 使用copyOnWriteList 不能使用iterator 进行 add or remove操作 所以很安全 COWIterator只能遍历
	 */
	@Test
	public void sample7() {
		List<String> list = new ArrayList<String>();
		list.add("Android");
		list.add("iPhone");
		list.add("Windows Mobile");
		List<String> cowList = new CopyOnWriteArrayList<String>(list);
		Iterator<String> itr = cowList.iterator();
		while (itr.hasNext()) {
			itr.next();
			itr.remove();
		}
	}

	public void sample8() {
		List<String> list = new ArrayList<String>();
		list.add("Android");
		list.add("iPhone");
		list.add("Windows Mobile");
		final List<String> cowList = new CopyOnWriteArrayList<String>(list);
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					System.out.println("线程1正在添加元素--------------");
					cowList.add("" + i);
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (String string : cowList) {
					System.out.println("线程2正在读取元素--------------");
					System.out.println("线程2" + string);
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (String string : cowList) {
					System.out.println("线程3正在删除元素--------------");
					System.out.println("线程3" + string);
					cowList.remove(string);
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (String string : cowList) {
					System.out.println("线程4正在读取元素--------------");
					System.out.println("线程4" + string);
				}
			}
		}).start();
	}

	@Test
	public void testRemove() {
		List<String> list = new ArrayList<String>(100);
		for (int i = 0; i < 100; i++) {
			list.add(i + "");
		}
		for (int i = 0; i < 100; i++) {
			list.remove(i);
			// System.out.println(list .get(i));

		}

	}
}
