package org.learn.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程安全的ArrayBlockQueue实现生产者消费者
 * 1.BlockingQueue定义的常用方法如下:
 * 1)add(anObject):把anObject加到BlockingQueue里,即如果BlockingQueue可以容纳,则返回true,否则报异常
 * 2)offer(anObject):表示如果可能的话,将anObject加到BlockingQueue里,即如果BlockingQueue可以容纳,则返回true,否则返回false.
 * 3)put(anObject):把anObject加到BlockingQueue里,如果BlockQueue没有空间,则调用此方法的线程被阻断直到BlockingQueue里面有空间再继续.
 * 4)poll(time):取走BlockingQueue里排在首位的对象,若不能立即取出,则可以等time参数规定的时间,取不到时返回null
 * 5)take():取走BlockingQueue里排在首位的对象,若BlockingQueue为空,阻断进入等待状态直到Blocking有新的对象被加入为止
 * 2.BlockingQueue有四个具体的实现类,根据不同需求,选择不同的实现类
 * 1)ArrayBlockingQueue:规定大小的BlockingQueue,其构造函数必须带一个int参数来指明其大小.其所含的对象是以FIFO(先入先出)顺序排序的.
 * 2)LinkedBlockingQueue:大小不定的BlockingQueue,若其构造函数带一个规定大小的参数,生成的BlockingQueue有大小限制,若不带大小参数,所生成的BlockingQueue的大小由Integer.
 * MAX_VALUE来决定.其所含的对象是以FIFO(先入先出)顺序排序的
 * 3)PriorityBlockingQueue:类似于LinkedBlockQueue,但其所含对象的排序不是FIFO,而是依据对象的自然排序顺序或者是构造函数的Comparator决定的顺序.
 * 4)SynchronousQueue:特殊的BlockingQueue,对其的操作必须是放和取交替完成的
 * 
 * @author Administrator
 */
public class PorducerConsumer {
    
    
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
        ExecutorService pools = Executors.newCachedThreadPool();
        pools.submit(new Producer(queue));
        pools.submit(new Consumer(queue));
        pools.shutdown();
        
    }
    
}

class Producer implements Runnable {
    
    
    ArrayBlockingQueue<String> queue;
    
    public Producer(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }
    
    @Override
    public void run() {
        int i = 0;
        while (true) {
            if (queue.offer(i + "")) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("加仓");
                System.out.println("加仓库存量" + queue.size());
            } else {
                System.out.println("仓库满了" + queue.size());
            }
        }
        
    }
    
}

class Consumer implements Runnable {
    
    
    ArrayBlockingQueue<String> queue;
    
    public Consumer(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }
    
    @Override
    public void run() {
        while (true) {
            String s = queue.poll();
            if (null == s) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("仓库已经空了");
            } else {
                System.out.println("减仓");
                System.out.println("减仓库存量" + queue.size());
            }
        }
        
    }
}
