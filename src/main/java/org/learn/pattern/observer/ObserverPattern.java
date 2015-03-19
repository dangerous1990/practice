package org.learn.pattern.observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverPattern extends Observable {
	public ObserverPattern() {
		addObserver(new Observer() {

			@Override
			public void update(Observable o, Object arg) {
				System.out.println("我被通知了！1");
			}
		});
		addObserver(new Observer() {

			@Override
			public void update(Observable o, Object arg) {
				System.out.println("我被通知了！2");
			}
		});
		
	}
	public static void main(String[] args) {
			ObserverPattern o = new ObserverPattern();
			o.setChanged();
			o.notifyObservers();
	}
}
