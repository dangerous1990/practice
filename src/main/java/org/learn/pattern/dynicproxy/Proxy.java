package org.learn.pattern.dynicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy implements InvocationHandler {
    
    private Object o;
    
    public Object bind(Object target) {
        this.o = target;
        return java.lang.reflect.Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass()
                .getInterfaces(), this);
    }
    
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;  
        System.out.println("事物开始");  
        //执行方法  
        result=method.invoke(o, args);  
        System.out.println("事物结束");  
        return result;  
    }
}
