package org.learn.enumexample;

/**
 * 所有定义的enum默认继承java.lang.Enum类， 可以把 enum 看成是一个普通的
 * class，它们都可以定义一些属性和方法，不同之处是：enum 不能使用 extends 关键字继承其他类，因为 enum 已经继承了
 * java.lang.Enum（java是单一继承）,可以实现接口
 * 
 * @author admin
 */
public enum WeekEnum {
    MON,
    TUE,
    WED,
    THU,
    FRI,
    SAT,
    SUN;// 此处调用了Enum(String name ,int ordinal)
}
