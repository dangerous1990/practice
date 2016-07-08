package org.learn.pattern.decorator;

public class Source implements Sourceable {
    
    
    @Override
    public void invoke() {
        System.out.println("被调用了");
    }
    
}
