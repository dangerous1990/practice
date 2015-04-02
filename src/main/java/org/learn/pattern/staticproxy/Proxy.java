package org.learn.pattern.staticproxy;

public class Proxy implements BookManager {
    
    private BookManager manager;
    
    public Proxy() {
        this.manager = new BookManagerImpl();
    }
    
    @Override
    public void addBook() {
        System.out.println("before add book");
        manager.addBook();
        System.out.println("after add book");
        
    }
    
}
