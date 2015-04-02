package org.learn.pattern.dynicproxy;


public class Client {
    public static void main(String[] args) {
        BookManager manager = new BookManagerImpl();
        Proxy proxy = new Proxy();
        BookManager realManager = (BookManager) proxy.bind(manager);
        realManager.addBook();
    }
}
