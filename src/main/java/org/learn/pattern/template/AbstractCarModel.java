package org.learn.pattern.template;

public abstract class AbstractCarModel {
    
    abstract void start();
    
    abstract void stop();
    
    public void run() {
        start();
        stop();
    }
}
