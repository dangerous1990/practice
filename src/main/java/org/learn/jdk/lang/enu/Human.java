package org.learn.jdk.lang.enu;

/**
 * @author admin
 */
public enum Human implements Behaviour {
    // 定义enum，通过括号传值调用构造方法声明。
    CHILDREN, // 无参构造方法
    MAN("MAN"), // 一个参数构造方法
    WOMEN("WOMEN"),
    SUPERMAN("SUPERMAN", "1"), // 两个参数构造方法
    SUPERWOMEN("SUPERWOMEN", "2");
    
    private String value;
    
    // 构造器默认也只能是private, 从而保证构造函数只能在内部使用
    // public Human(String value) {
    private Human(String value) {
        this.value = value;
    }
    
    private Human() {
        
    }
    
    // 普通set\get方法
    private Human(String value, String value2) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    // 重写方法
    @Override
    public void behaviour() {
        System.out.println(value);
    }
    
    // 静态方法
    public static String getName(int index) {
        for (Human c : Human.values()) {
            if (c.ordinal() == index) {
                return c.name();
            }
        }
        return null;
    }
}
