package pl.edu.agh.internetshop;

public class PurchaserNameStrategy implements SearchStrategy{

    private String name;

    public PurchaserNameStrategy(String name) {
        this.name = name;
    }

    @Override
    public boolean filter(OrderLog log) {
        return log.order.getShipment().getRecipientAddress().getName().equals(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
