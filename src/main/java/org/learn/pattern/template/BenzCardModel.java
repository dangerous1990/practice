package org.learn.pattern.template;

public class BenzCardModel extends AbstractCarModel {
    
    @Override
    void start() {
        System.out.println("奔驰车启动");
        
    }
    
    @Override
    void stop() {
        System.out.println("奔驰车停车");
        
    }
    
}
