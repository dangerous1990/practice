package org.learn.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(10);
        
        for (int i = 0; i < 10; ++i) // create and start threads
            new Thread(new Worker(startSignal, doneSignal)).start();
        
        Thread.sleep(1000L);
        System.out.println("所有线程全部启动！");
        startSignal.countDown();
        doneSignal.await();
        System.out.println("等待所有线程执行结束");
        
    }
    
}

class Worker implements Runnable {
    
    private final CountDownLatch startSignal;
    
    private final CountDownLatch doneSignal;
    
    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }
    
    public void run() {
        try {
            System.out.println("等待其他线程全部启动");
            startSignal.await();
            doWork();
            doneSignal.countDown();
            Thread.sleep(500L);
        } catch (InterruptedException ex) {
        }
    }
    
    void doWork() {
        System.out.println("dowork");
    }
}
