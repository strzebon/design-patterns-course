package org.example;

import java.util.Stack;

public class CommandHistory {
    private final Stack<Command> History = new Stack<>();

    public void push(Command c){
        History.push(c);
    }

    public Command pop(){
        return History.pop();
    }
}
