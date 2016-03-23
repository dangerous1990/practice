package org.learn.concurrent;

public class ThreadTest3 {
    
    public static void main(String[] args) {
        Example3 example = new Example3();
        
        Thread t1 = new Thread5(example);
        
        // 此处即便传入不同的对象，静态方法同步仍然不允许多个线程同时执行
        example = new Example3();
        
        Thread t2 = new Thread6(example);
        
        t1.start();
        t2.start();
    }
    
}

class Example3 {
    
    public synchronized static void execute() {
        for (int i = 0; i < 20; ++i) {
            try {
                Thread.sleep((long) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
    
    public synchronized static void execute2() {
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
@SuppressWarnings("static-access")
class Thread5 extends Thread {
    
    private Example3 example;
    
    public Thread5(Example3 example)
    
    {
        this.example = example;
    }
    
    
    @Override
    public void run() {
        // Example3.execute();
        example.execute();
    }
    
}
@SuppressWarnings("static-access")
class Thread6 extends Thread {
    
    private Example3 example;
    
    public Thread6(Example3 example) {
        this.example = example;
    }
    
    @Override
    public void run() {
        // Example3.execute();
        example.execute2();
    }
    
}
