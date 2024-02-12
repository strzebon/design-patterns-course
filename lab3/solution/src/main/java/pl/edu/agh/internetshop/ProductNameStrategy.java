package pl.edu.agh.internetshop;

public class ProductNameStrategy implements SearchStrategy{

    private String productName;

    public ProductNameStrategy(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean filter(OrderLog log) {
        return log.order.getProducts().stream().anyMatch(p -> p.getName().equals(productName));
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
