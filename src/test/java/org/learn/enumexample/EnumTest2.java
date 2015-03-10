package org.learn.enumexample;

import org.junit.Test;

public class EnumTest2 {
	public enum Season {
		ss, ss2
	}

	@Test
	public void test() {
		System.out.println(Season.ss.name());
	}

	@Test
	public void test2() {
		System.out.println(Food.Coffee.BLACK_COFFEE);
	}

}
