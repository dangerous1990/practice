package org.learn.jdk.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by Administrator on 2016/9/20.
 */
public class TestSpi {
    public static void main(String[] args) {
        ServiceLoader<IOperation> sl = ServiceLoader.load(IOperation.class);
        Iterator<IOperation> it = sl.iterator();
        while (it.hasNext()) {
            IOperation opi = it.next();
            opi.operation("test");
        }
    }
}
