package org.learn.pattern.decorator;

public class Client {
    
    public static void main(String[] args) {
        Sourceable s = new Source();
        Sourceable d = new Decorator(s);
        d.invoke();
    }
}
