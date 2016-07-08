package org.learn.concurrent;

import org.junit.Test;

/**
 * 静态方法只能有一个线程进行访问
 * 
 * @author admin
 */
public class SynchronizedTest {
    
    
    /**
     * 对于synchronized修饰的方法，一旦有线程进入执行，其他线程只能等上一个线程执行完才能进入
     */
    @Test
    public void test() {
        Example example = new Example();
        Thread t1 = new SynchronizedThread(example, 0);
        Thread t2 = new SynchronizedThread(example, 0);
        t1.start();
        t2.start();
        try {
            Thread.sleep(10000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 一个对象的多个同步方法,一个线程可以访问一个同步方法，其他线程必须等待另一个线程执行完同步方法才能抢占锁
     */
    @Test
    public void test1() {
        Example example = new Example();
        Thread t3 = new SynchronizedThread(example, 0);
        Thread t4 = new SynchronizedThread(example, 0);
        Thread t5 = new SynchronizedThread(example, 0);
        Thread t6 = new SynchronizedThread(example, 0);
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        try {
            Thread.sleep(100000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * synchronize代码块 synchronized(this/object)
     */
    @Test
    public void test2() {
        Example example = new Example();
        Thread t3 = new SynchronizedThread(example, 2);
        Thread t4 = new SynchronizedThread(example, 3);
        t3.start();
        t4.start();
        try {
            Thread.sleep(100000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}

class Example {
    
    
    private final Object object = new Object();
    
    public synchronized void execute() {
        // public void execute() {
        for (int i = 0; i < 20; ++i) {
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("execute" + Thread.currentThread().getName() + ":" + i);
        }
    }
    
    public synchronized void execute1() {
        for (int i = 0; i < 20; ++i) {
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("execute1" + Thread.currentThread().getName() + ":" + i);
        }
    }
    
    public void execute2() {
        System.out.println(Thread.currentThread().getName() + "正在等待另一个线程释放锁");
        synchronized (object) {
            for (int i = 0; i < 5; ++i) {
                try {
                    Thread.sleep((long) Math.random() * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            
        }
        
    }
    
    public void execute3() {
        System.out.println(Thread.currentThread().getName() + "正在等待另一个线程释放锁");
        synchronized (object) {
            for (int i = 0; i < 5; ++i) {
                try {
                    Thread.sleep((long) Math.random() * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            
        }
        
    }
}

class SynchronizedThread extends Thread {
    
    
    private Example example;
    
    private int index;
    
    public SynchronizedThread(Example example, int index) {
        this.example = example;
        this.index = index;
    }
    
    @Override
    public void run() {
        switch (index) {
            case 0:
                example.execute();
                break;
            case 1:
                example.execute1();
                break;
            case 2:
                example.execute2();
                break;
            case 3:
                example.execute3();
                break;
            default:
                break;
        }
    }
    
}
