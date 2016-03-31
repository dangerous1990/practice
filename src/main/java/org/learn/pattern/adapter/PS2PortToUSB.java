package org.learn.pattern.adapter;

/**
 * 对象适配器模式
 * 
 * @author admin
 */
public class PS2PortToUSB implements USBPort {
    
    private PS2Port ps2;
    
    public PS2PortToUSB(PS2Port ps2) {
        this.ps2 = ps2;
    }
    
    @Override
    public void workWithUSBPort() {
        System.out.println("转换的关键在这里,本来是");
        ps2.workWithPS2Port();
        System.out.println("经过你的转换，现在是USB工作中");
    }
    
}
