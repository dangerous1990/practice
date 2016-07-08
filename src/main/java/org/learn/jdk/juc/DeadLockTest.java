package org.learn.jdk.juc;

/**
 * 锁顺序死锁(lock-ordering deadlock)：多个线程试图通过不同的顺序获得多个相同的资源，则发生的循环锁依赖现象。
 * 
 * @author Administrator
 */
public class DeadLockTest {
    
    
    public static void main(String[] args) {
        DeadLockTest test = new DeadLockTest();
        new ThreadDeadLock(test).start();
        new ThreadDeadLock(test).start();
        new ThreadDeadLock(test).start();
        new ThreadDeadLock(test).start();
        new ThreadDeadLock1(test).start();
        new ThreadDeadLock1(test).start();
        new ThreadDeadLock1(test).start();
        new ThreadDeadLock1(test).start();
        new ThreadDeadLock1(test).start();
    }
    
    final Object left = new Object();
    
    final Object right = new Object();
    
    public void doLeftRight() {
        synchronized (left) {
            synchronized (right) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                execute1();
            }
        }
    }
    
    public void doRightLeft() {
        synchronized (right) {
            synchronized (left) {
                execute2();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    
    private void execute2() {
    }
    
    private void execute1() {
    }
}

class ThreadDeadLock extends Thread {
    
    
    private DeadLockTest test;
    
    public ThreadDeadLock(DeadLockTest test) {
        this.test = test;
    }
    
    @Override
    public void run() {
        super.run();
        test.doLeftRight();
    }
    
}

class ThreadDeadLock1 extends Thread {
    
    
    private DeadLockTest test;
    
    public ThreadDeadLock1(DeadLockTest test) {
        this.test = test;
    }
    
    @Override
    public void run() {
        super.run();
        test.doRightLeft();
    }
    
}
