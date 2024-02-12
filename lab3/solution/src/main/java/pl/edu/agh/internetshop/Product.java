package pl.edu.agh.internetshop;

import java.math.BigDecimal;

public class Product {
	
	public static final int PRICE_PRECISION = 2;
	public static final int ROUND_STRATEGY = BigDecimal.ROUND_HALF_UP;
	
    private final String name;
    private final BigDecimal price;

    private BigDecimal discount;



    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.price.setScale(PRICE_PRECISION, ROUND_STRATEGY);
        this.discount = BigDecimal.valueOf(0);
    }

    public Product(String name, BigDecimal price, BigDecimal discount) {
        this.name = name;
        this.price = price;
        this.price.setScale(PRICE_PRECISION, ROUND_STRATEGY);
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getPriceWithDiscount(){
        return getPrice().subtract(getPrice().multiply(discount)).setScale(PRICE_PRECISION, ROUND_STRATEGY);
    }

    public BigDecimal getDiscount(){
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
