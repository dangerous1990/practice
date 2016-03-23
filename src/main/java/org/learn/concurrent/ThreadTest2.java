package org.learn.concurrent;

/**
 * 一个对象的2个同步方法,多条线程可以调用一个对象不同的同步方法
 * @author admin
 *
 */
public class ThreadTest2 {
	public static void main(String[] args) {
		Example1 example = new Example1();
		Example1 example1 = new Example1();

		Thread t1 = new Thread2(example);
		Thread t2 = new Thread3(example1);

		t1.start();
		t2.start();
	}

}

class Example1 {
	public synchronized void execute() {
		for (int i = 0; i < 10; ++i) {
			try {
				Thread.sleep((long) Math.random() * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+":"+ i);
		}
	}

	public synchronized void execute1() {
		for (int i = 0; i < 10; ++i) {
			try {
				Thread.sleep((long) Math.random() * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+":"+ i);
		}
	}

}

class Thread2 extends Thread {
	private Example1 example;

	public Thread2(Example1 example) {
		this.example = example;
	}

	@Override
	public void run() {
		example.execute();
	}

}

class Thread3 extends Thread {
	private Example1 example;

	public Thread3(Example1 example) {
		this.example = example;
	}

	@Override
	public void run() {
		example.execute1();
	}

}