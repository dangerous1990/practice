package org.learn.pattern.simplefactory;

public class SimpleFactory<T> {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  T getInstance(Class clazz) {
		try {
			return (T) clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
