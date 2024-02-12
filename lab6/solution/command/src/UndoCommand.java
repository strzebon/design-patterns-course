package org.example;

public class UndoCommand extends Command{
    public UndoCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public boolean execute() {
        saveBackup();
        editor.deleteSelection();
        return true;
    }
}
