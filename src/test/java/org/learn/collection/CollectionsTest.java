package org.learn.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class CollectionsTest {

	/**
	 * 自然排序 根据List中类型实现Compareable的 compare方法
	 */
	@Test
	public void testSort() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 9, 11, 8, 7, 10);
		Collections.sort(list);
		for (Integer integer : list) {
			System.out.print(integer + ",");
		}
		System.out.println();
		Collections.sort(list, new DescCompareable());
		for (Integer integer : list) {
			System.out.print(integer + ",");
		}
	}

	/**
	 * 二分查找必须先排序
	 */
	@Test
	public void testBinarySearch() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 9, 11, 8, 7, 10);
		Collections.sort(list);
		int index = Collections.binarySearch(list, 9);
		for (Integer integer : list) {
			System.out.print(integer + ",");
		}
		System.out.println();
		System.out.println("9所在位置" + index);
	}

	/**
	 * 根据算法思想实现的二分查找方法
	 */
	@Test
	public void testBinarySearch3() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 9, 11, 8, 7, 10);
		Collections.sort(list);
		int index = BinarySearchTool.BinarySearch(list.toArray(new Integer[0]),
				9);
		for (Integer integer : list) {
			System.out.print(integer + ",");
		}
		System.out.println();
		System.out.println("9所在位置" + index);
	}

	@Test
	public void testBinarySearch1() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 9, 11, 8, 7, 10);
		Collections.sort(list, new DescCompareable());
		int index = Collections.binarySearch(list, 9, new DescCompareable());
		for (Integer integer : list) {
			System.out.print(integer + ",");
		}
		System.out.println();
		System.out.println("9所在位置" + index);
	}

	/**
	 * 反转List
	 */
	@Test
	public void testReverse() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 9, 11, 8, 7, 10);
		Collections.reverse(list);
		for (Integer integer : list) {
			System.out.print(integer + ",");
		}

	}

	/**
	 * 洗牌
	 */
	@Test
	public void testShuffle() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 9, 11, 8, 7, 10);
		Collections.shuffle(list);
		for (Integer integer : list) {
			System.out.print(integer + ",");
		}
		System.out.println();
		Collections.shuffle(list);
		for (Integer integer : list) {
			System.out.print(integer + ",");
		}
	}

	/**
	 * 交换位置
	 */
	@Test
	public void testSwap() {
		List<Integer> list = Arrays.asList(1, 2);
		Collections.swap(list, 0, 1);
		for (Integer integer : list) {
			System.out.print(integer + ",");
		}
	}

	/**
	 * 填充
	 */
	@Test
	public void testFill() {
		// List<Integer> list = new ArrayList<Integer>(10);
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 9, 11, 8, 7, 10);
		Collections.fill(list, 1);
		for (Integer integer : list) {
			System.out.print(integer + ",");
		}
	}

	/**
	 * copy 目标list.size()不能小于源list.size()
	 */
	@Test
	public void testCopy() {
		List<Integer> list1 = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				13, 14, 15, 16);
		List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 9, 11, 8, 7, 10);
		Collections.copy(list1, list2);
		for (Integer integer : list1) {
			System.out.print(integer + ",");
		}
	}

	/**
	 * min & max
	 */
	@Test
	public void testMinAndMax() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 9, 11, 8, 7, 10);
		Integer element1 = Collections.min(list);
		System.out.print("最小数："+element1);
		Integer element2 = Collections.max(list);
		System.out.print("最大数："+element2);
	}
	/**
	 * 轮转移动位置
	 */
	@Test
	public void testRotate() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 9, 11, 8, 7, 10);
		Collections.rotate(list, -1);
		for (Integer integer : list) {
			System.out.print(integer + ",");
		}
	}
	/**
	 * 不可变
	 */
	@Test
	public void testUnmodifiable(){
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 9, 11, 8, 7, 10);
		Collections.unmodifiableList(list);
		list.add(1);
	}
	/**
	 * 同步
	 */
	@Test
	public void testSynchronized(){
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 9, 11, 8, 7, 10);
		Collections.synchronizedList(list);
		
	}
	/**
	 * 单例
	 */
	@Test
	public void testSingleton(){
		List<Integer> list =Collections.singletonList(1);
		list.add(2);
	}
}
