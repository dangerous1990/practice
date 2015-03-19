package org.learn.pattern.builder;

public class Dirctor {
	private IBuilder b ;
	public Dirctor(IBuilder b){
		this.b= b;
	}
	void create(){
		b.createAge();
		b.createName();
	}
}
