package org.learn.pattern.staticproxy;


/**
 * 静态代理已经编译好的内容
 * @author admin
 *
 */
public class Client {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.addBook();
    }
}
