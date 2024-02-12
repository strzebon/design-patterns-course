package org.example;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class CompressionDecorator extends DataSourceDecorator{
    public CompressionDecorator(IDataSource wrappee) {
        super(wrappee);
    }
    @Override
    public void writeData(String data) {
        super.writeData(compress(data));
    }
    @Override
    public String readData() {
        return decompress(super.readData());
    }

    private String compress(String stringData) {
        byte[] input;
        input = stringData.getBytes(StandardCharsets.UTF_8);
        byte[] output = new byte[input.length];
        Deflater compressor = new Deflater();

        compressor.setInput(input);
        compressor.finish();
        compressor.deflate(output);
        compressor.end();
        return new String(Base64.getEncoder().encode(output));
    }

    private String decompress(String stringData) {
        byte[] output = Base64.getDecoder().decode(stringData);
        Inflater decompressor = new Inflater();
        decompressor.setInput(output);
        byte[] result = stringData.getBytes();
        int resultLength = 0;

        try{
            resultLength = decompressor.inflate(result);
        }catch (DataFormatException e){
            System.out.println(e.getMessage());
        }

        decompressor.end();
        return new String(result, 0, resultLength, StandardCharsets.UTF_8);
    }
}
