package org.learn.pattern.singleton;

/**
 * 静态内部类懒加载
 * @author admin
 *
 */
public class LazySingleton {
	private LazySingleton() {

	}

	public LazySingleton getInstance() {
		return NestSingleton.ls;
	}

	public static class NestSingleton {
		private static final LazySingleton ls = new LazySingleton();
	}
}
