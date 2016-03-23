package org.learn.concurrent;

/**
 * 对于synchronized修饰的方法，一旦有线程进入执行，其他线程只能等上一个线程执行完才能进入
 * 
 * @author admin
 */
public class ThreadTest {
    
    public static void main(String[] args) {
        Example example = new Example();
        
        Thread t1 = new Thread1(example);
        Thread t2 = new Thread1(example);
        
        t1.start();
        t2.start();
    }
    
}

class Example {
    
    public synchronized void execute() {
        // public void execute() {
        for (int i = 0; i < 10; ++i) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
    
}

class Thread1 extends Thread {
    
    private Example example;
    
    public Thread1(Example example) {
        this.example = example;
    }
    
    @Override
    public void run() {
        example.execute();
    }
    
}
