package org.example;

public class Main {
    public static void main(String[] args) {
        String filename = "./test.txt";
        String input = "Ala ma kota";
        IDataSource output = new FileDataSource(filename);
        DataSourceDecorator encoded = new CompressionDecorator(new EncryptionDecorator(new FileDataSource(filename)));

        encoded.writeData(input);

        System.out.println(input);
        System.out.println(output.readData());
        System.out.println(encoded.readData());

    }
}