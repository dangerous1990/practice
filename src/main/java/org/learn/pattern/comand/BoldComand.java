package org.learn.pattern.comand;

public class BoldComand implements IComand {
    
    private String preText;
    
    @Override
    public String execute(String text) {
        this.preText = text;
        return text + "加粗";
    }
    
    @Override
    public String undo() {
        return preText;
    }
    
}
