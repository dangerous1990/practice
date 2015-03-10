package org.learn.interview.pc;

public class Customer extends Thread {
	private Store s;

	public Customer(Store s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (true) {

			s.remove();
			try {
				sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
