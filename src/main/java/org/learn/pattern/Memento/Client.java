package org.learn.pattern.Memento;

public class Client {
    
    public static void main(String[] args) {
        Originer o = new Originer("状态1");
        System.out.println(o.getState());
        History history = new History();
        history.setBackup(o.createMemento());// 备份
        o.setState("状态2");// 修改
        System.out.println(o.getState());
        o.restoreMemento(history.getBackup());// 恢复
        System.out.println(o.getState());
        
    }
}
