package org.learn.concurrent;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

import java.util.concurrent.Semaphore;

/**
 * 信号量 用于多个用户，试用于狼多肉少的场景，资源有限，消费者只能等待其他资源释放后，才能抢占资源
 * 
 * @author Administrator
 */
public class SemaphoreTest {
    
    
    public static void main(String[] args) {
        
        // 线程池
        
        ExecutorService exec = Executors.newCachedThreadPool();
        
        // 只能5个线程同时访问
        
        final Semaphore semp = new Semaphore(5);
        
        // 模拟20个客户端访问
        
        for (int index = 0; index < 20; index++) {
            
            final int NO = index;
            
            Runnable run = new Runnable() {
                
                
                public void run() {
                    
                    try {
                        
                        // 获取许可
                        System.out.println(NO + "正在获取许可");
                        semp.acquire();
                        System.out.println(NO + "获取到许可");
                        
                        Thread.sleep((long) (Math.random() * 10000));
                        
                        // 访问完后，释放
                        
                        semp.release();
                        System.out.println("释放一个许可");
                        
                        System.out.println("-------当天空闲许可----------" + semp.availablePermits());
                        
                    } catch (InterruptedException e) {
                        
                        e.printStackTrace();
                        
                    }
                    
                }
                
            };
            
            exec.execute(run);
            
        }
        
        // 退出线程池
        
        exec.shutdown();
        
    }
    
}
