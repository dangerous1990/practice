package org.learn.pattern.factory;

public class SmsSender implements Sender {
    
    
    @Override
    public void send() {
        System.out.println("send by sms");
        
    }
    
}
