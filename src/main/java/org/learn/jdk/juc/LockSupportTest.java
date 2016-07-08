package org.learn.jdk.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * 更精准的wait notify 可以指定唤醒，park unpark成对出现
 * 
 * @author Administrator
 */
public class LockSupportTest {
    
    
    private static Thread mainThread;
    
    public static void main(String[] args) {
        
        ThreadA ta = new ThreadA("ta");
        // 获取主线程
        mainThread = Thread.currentThread();
        
        System.out.println(Thread.currentThread().getName() + " start ta");
        ta.start();
        
        System.out.println(Thread.currentThread().getName() + " block");
        // 主线程阻塞
        LockSupport.park();
        
        System.out.println(Thread.currentThread().getName() + " continue");
    }
    
    static class ThreadA extends Thread {
        
        
        public ThreadA(String name) {
            super(name);
        }
        
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " wakup others");
            // 唤醒“主线程”
            LockSupport.unpark(mainThread);
        }
    }
}
