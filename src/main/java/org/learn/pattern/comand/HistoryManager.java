package org.learn.pattern.comand;

import java.util.Stack;

public class HistoryManager {
    
    private Stack<IComand> undoStack = new Stack<IComand>();
    
    private void storeExecuteCmd(IComand cmd) {
        undoStack.push(cmd);
    }
    
    public String exectute(IComand cmd, String text) {
        storeExecuteCmd(cmd);
        return cmd.execute(text);
    }
    
    public String undo() {
        if (undoStack.isEmpty()) {
            return "没有可撤销的对象";
        } else {
            return undoStack.pop().undo();
        }
        
    }
    
}
