package org.example;

public class Editor {
    public String text = "";

    public String getSelection(){
        return this.text;
    }

    public void deleteSelection(){
        this.text = "";
    }

    public void replaceSelection(String text){
        this.text = text;
    }
}
