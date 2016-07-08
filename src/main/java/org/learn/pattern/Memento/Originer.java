package org.learn.pattern.Memento;

public class Originer implements Cloneable {
    
    
    private String state;
    
    public Originer(String state) {
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public Originer createMemento() {
        try {
            return (Originer) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void restoreMemento(Originer originer) {
        setState(originer.getState());
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
