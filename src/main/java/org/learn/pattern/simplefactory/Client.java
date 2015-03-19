package org.learn.pattern.simplefactory;

public class Client {
	public static void main(String[] args) {
		SimpleFactory<Fruit> factory = new SimpleFactory<Fruit>();
		Fruit apple = factory.getInstance(Apple.class);
		Fruit orange = factory.getInstance(Orange.class);
		apple.getJuice();
		orange.getJuice();
	}
}
