package org.learn.pattern.builder;

public class Director {
    
    private IBuilder b;
    
    public Director(IBuilder b) {
        this.b = b;
    }
    
    void create() {
        b.createAge();
        b.createName();
    }
}
