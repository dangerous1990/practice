package org.learn.pattern.builder;

public class Client {
	public static void main(String[] args) {
		IBuilder b = new Builder();
		Dirctor d = new Dirctor(b);
		d.create();
		System.out.println(b.getProduct());
	}
}
