package org.learn.pattern.comand;

public interface IComand {
    
    String execute(String text);
    
    String undo();
}
