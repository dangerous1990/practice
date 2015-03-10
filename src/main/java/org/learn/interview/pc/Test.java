package org.learn.interview.pc;

/**
 * 生产者、消费者
 * @author admin
 *
 */
public class Test {
public static void main(String[] args) {
	
	Store s = new Store();
	Producer p1 = new Producer(s);
	Customer c1 = new Customer(s);
	Producer p2 = new Producer(s);
	Customer c2 = new Customer(s);
	p1.setName("p1");
	p2.setName("p2");
	c1.setName("c1");
	c2.setName("c2");
	p1.start();
	p2.start();
	c1.start();
	c2.start();
	
}
}
