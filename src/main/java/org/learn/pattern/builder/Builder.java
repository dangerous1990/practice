package org.learn.pattern.builder;

public class Builder implements IBuilder{
	private Product p ;
	public Builder(){
		p= new Product();
	}
	@Override
	public void createAge() {
		p.setAge(10);
	}

	@Override
	public void createName() {
		p.setName("test");
	}

	@Override
	public Product getProduct() {
		return p;
	}

}
