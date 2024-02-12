package org.example;

public abstract class Command {
    protected final Application app;
    protected final Editor editor;
    protected String backup;

    public Command(Application app, Editor editor){
        this.app = app;
        this.editor = editor;
    }

    public void saveBackup(){
        this.backup = this.editor.getSelection();
    }

    public void undo(){
        this.editor.replaceSelection(this.backup);
    }

    public abstract boolean execute();
}
