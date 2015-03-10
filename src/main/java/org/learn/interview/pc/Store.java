package org.learn.interview.pc;

/**
 * 仓库类
 * 
 * @author admin
 *
 */
public class Store {
	private int size=0;
	private static final int MAX_SIZE=3;
	public synchronized void add(){
		while (size>=MAX_SIZE) {
			System.out.println("已经满了");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		size++;
		System.out.println(Thread.currentThread().getName()+"   "+size);
		notifyAll();
	}
	public synchronized void remove(){
		while (size<=0) {
			System.out.println("已经空了");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"   "+size);
		size--;
		notifyAll();
	}
}
