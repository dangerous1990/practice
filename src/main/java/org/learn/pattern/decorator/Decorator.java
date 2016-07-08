package org.learn.pattern.decorator;

public class Decorator implements Sourceable {
    
    private Sourceable s;
    
    public Decorator(Sourceable s) {
        this.s = s;
    }
    
    @Override
    public void invoke() {
        System.out.println("before被调用了");
        s.invoke();
        System.out.println("after被调用了");
    }
}
