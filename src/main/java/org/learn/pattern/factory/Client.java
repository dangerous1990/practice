package org.learn.pattern.factory;

public class Client {
    
    
    public static void main(String[] args) {
        Factory email = new EmailFactory();
        email.produce().send();
        Factory sms = new SmsFactory();
        sms.produce().send();
    }
}
