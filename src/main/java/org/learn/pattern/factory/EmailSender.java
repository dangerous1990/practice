package org.learn.pattern.factory;

public class EmailSender implements Sender {
    
    
    @Override
    public void send() {
        System.out.println("send by email");
    }
    
}
