package org.example;

public class DataSourceDecorator implements IDataSource {
    private final IDataSource wrappee;

    public DataSourceDecorator(IDataSource wrappee) {
        this.wrappee = wrappee;
    }
    @Override
    public void writeData(String data) {
        this.wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return this.wrappee.readData();
    }
}
