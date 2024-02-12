package org.example;

import java.util.ArrayList;

public class Application {
    public final ArrayList<Editor> editors = new ArrayList<>();
    public Editor activeEditor;
    public String clipboard = "";
    public final CommandHistory history = new CommandHistory();

    public void executeCommand(Command c){
        if(c.execute()){
            history.push(c);
        }
    }

    public void undo(){
        Command c = history.pop();
        if(c != null){
            c.undo();
        }
    }
}
