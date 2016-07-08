package org.learn.pattern.template;

public class Client {
    
    public static void main(String[] args) {
        AbstractCarModel bmw = new BMWCardModel();
        AbstractCarModel benz = new BenzCardModel();
        bmw.run();
        benz.run();
    }
}
