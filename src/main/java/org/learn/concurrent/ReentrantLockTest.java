package org.learn.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 比synchronized关键字更灵活
 * 
 * @author Administrator
 */
public class ReentrantLockTest {
    
    
    private ReentrantLock lock = new ReentrantLock();
    
    public void execute() {
        if (lock.isLocked()) {
            System.out.println("当前线程：" + Thread.currentThread().getName() + "，锁正在被使用，无法获得锁");
        }
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName() + i);
            }
            
        } finally {
            lock.unlock();
        }
    }
    
    public void execute2() {
        if (lock.isLocked()) {
            System.out.println("当前线程：" + Thread.currentThread().getName() + "，锁正在被使用，无法获得锁");
        }
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName() + i);
            }
        } finally {
            lock.unlock();
        }
    }
    
    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();
        Thread t1 = new Thread(new ThreadLock(test));
        Thread t2 = new Thread(new ThreadLock2(test));
        t1.start();
        t2.start();
    }
}

class ThreadLock implements Runnable {
    
    
    private ReentrantLockTest test;
    
    public ThreadLock(ReentrantLockTest test) {
        this.test = test;
    }
    
    @Override
    public void run() {
        test.execute();
    }
}

class ThreadLock2 implements Runnable {
    
    
    private ReentrantLockTest test;
    
    public ThreadLock2(ReentrantLockTest test) {
        this.test = test;
    }
    
    @Override
    public void run() {
        test.execute2();
    }
}
