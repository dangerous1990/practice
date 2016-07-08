package org.learn.pattern.Memento;

public class History {
    
    private Originer backup;
    
    public Originer getBackup() {
        return backup;
    }
    
    public void setBackup(Originer backup) {
        this.backup = backup;
    }
    
}
