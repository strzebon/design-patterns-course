package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDataSource implements IDataSource{
    private final String filename;

    public FileDataSource(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeData(String data) {
        try{
            Files.write(Paths.get(filename), data.getBytes());
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String readData() {
        try{
            return new String(Files.readAllBytes(Paths.get(filename)));
        } catch(IOException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
