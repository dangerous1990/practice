package org.learn.pattern.singleton;

/**
 * 单例模式7种写法，线程安全、延迟加载、双重检查、枚举方式创建
 * 
 * @see http://cantellow.iteye.com/blog/838473
 * @author admin
 */
public class Singleton {
    
    private static Singleton instance;
    
    private Singleton() {
        
    }
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
