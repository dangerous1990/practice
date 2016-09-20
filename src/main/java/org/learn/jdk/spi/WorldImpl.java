package org.learn.jdk.spi;

/**
 * Created by Administrator on 2016/9/20.
 */
public class WorldImpl implements IOperation {
    @Override
    public void operation(String arg) {
        System.out.println("world");
    }
}
