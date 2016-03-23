package org.learn.concurrent;

/**
 * 同步代码块
 * 
 * @author admin
 */
public class ThreadTest4 {
    
    public static void main(String[] args) {
        Example4 example = new Example4();
        
        Thread t1 = new Thread7(example);
        Thread t2 = new Thread8(example);
        
        t1.start();
        t2.start();
    }
    
}

class Example4 {
    
    private final Object object = new Object();
    
    public void execute() {
        System.out.println(Thread.currentThread().getName() + "正在等待另一个线程释放锁");
        synchronized (object) {
            for (int i = 0; i < 20; ++i) {
                try {
                    Thread.sleep((long) Math.random() * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            
        }
        
    }
    
    public void execute2() {
        System.out.println(Thread.currentThread().getName() + "正在等待另一个线程释放锁");
        synchronized (object) {
            for (int i = 0; i < 20; ++i) {
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

class Thread7 extends Thread {
    
    private Example4 example;
    
    public Thread7(Example4 example) {
        this.example = example;
    }
    
    @Override
    public void run() {
        example.execute();
    }
    
}

class Thread8 extends Thread {
    
    private Example4 example;
    
    public Thread8(Example4 example) {
        this.example = example;
    }
    
    @Override
    public void run() {
        example.execute2();
    }
    
}
