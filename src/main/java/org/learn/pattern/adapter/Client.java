package org.learn.pattern.adapter;

public class Client {
    
    
    public static void main(String[] args) {
        // 1.我现在有一个PS2接口
        PS2Port ps2Port = new PS2Port() {
            
            
            @Override
            public void workWithPS2Port() {
                System.out.println("PS2工作中");
            }
        };
        
        // 2.但是我需要的是一个USB接口啊,对我(client)来说，我只认识USB接口
        // 3.经过PS2ToUSB的转换，PS2接口变成了USB接口
        USBPort ps2ToUsbPort = new PS2PortToUSB(ps2Port);
        
        ps2ToUsbPort.workWithUSBPort();
        
    }
    
}
