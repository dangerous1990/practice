package org.learn.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 重用栅栏 线程完成阶段工作后等待其他(栅栏初始化数量个)线程完全部成工作调用await()后继续进行。
 * 
 * @author Administrator
 */
public class CyclicBarrierTest {
    
    
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        
        for (int i = 0; i < N; i++) {
            new Writer(barrier).start();
        }
        
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("CyclicBarrier重用");
        
        for (int i = 0; i < N; i++) {
            new Writer(barrier).start();
        }
    }
    
    static class Writer extends Thread {
        
        
        private CyclicBarrier cyclicBarrier;
        
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }
        
        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
            try {
                Thread.sleep(5000); // 以睡眠来模拟写入数据操作
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "所有线程写入完毕，继续处理其他任务...");
        }
    }
}
