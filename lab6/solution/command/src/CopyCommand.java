package org.example;

public class CopyCommand extends Command{
    public CopyCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public boolean execute() {
        saveBackup();
        app.clipboard = editor.getSelection();
        return true;
    }
}
