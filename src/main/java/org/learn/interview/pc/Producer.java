package org.learn.interview.pc;

public class Producer extends Thread {
	private Store s;

	public Producer(Store s) {
		this.s = s;
	}

	@Override
	public void run() {
		while(true){
			s.add();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
