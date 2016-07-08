package org.learn.pattern.builder;

public class Client {
    
    
    public static void main(String[] args) {
        IBuilder b = new Builder();
        Director d = new Director(b);
        d.create();
        System.out.println(b.getProduct());
    }
}
