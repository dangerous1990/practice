package org.learn.pattern.template;

public class BMWCardModel extends AbstractCarModel {
    
    @Override
    void start() {
        System.out.println("宝马车启动");
        
    }
    
    @Override
    void stop() {
        System.out.println("宝马车停车");
        
    }
    
}
