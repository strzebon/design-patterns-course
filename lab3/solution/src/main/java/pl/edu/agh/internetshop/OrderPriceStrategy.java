package pl.edu.agh.internetshop;

import java.math.BigDecimal;

public class OrderPriceStrategy implements SearchStrategy{

    private BigDecimal price;

    public OrderPriceStrategy(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean filter(OrderLog log) {
        return log.order.getPrice().equals(price);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
