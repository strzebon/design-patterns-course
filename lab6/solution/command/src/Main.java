package org.example;

public class Main {
    public static void main(String[] args) {
        Application app = new Application();
        Editor editor1 = new Editor();
        Editor editor2 = new Editor();

        editor1.text = "Ala ma kota.";
        editor2.text = "Hello World!";

        System.out.println("clipboard: " + app.clipboard);
        System.out.println("editor1: " + editor1.text);
        System.out.println("editor2: " + editor2.text);
        System.out.println();

        app.executeCommand(new CutCommand(app, editor1));
        System.out.println("clipboard: " + app.clipboard);
        System.out.println("editor1: " + editor1.text);
        System.out.println("editor2: " + editor2.text);
        System.out.println();

        app.executeCommand(new PasteCommand(app, editor2));
        System.out.println("clipboard: " + app.clipboard);
        System.out.println("editor1: " + editor1.text);
        System.out.println("editor2: " + editor2.text);
        System.out.println();

        app.undo();
        System.out.println("clipboard: " + app.clipboard);
        System.out.println("editor1: " + editor1.text);
        System.out.println("editor2: " + editor2.text);
        System.out.println();

        app.undo();
        System.out.println("clipboard: " + app.clipboard);
        System.out.println("editor1: " + editor1.text);
        System.out.println("editor2: " + editor2.text);
        System.out.println();
    }
}