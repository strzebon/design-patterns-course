package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

import java.math.BigDecimal;


public class ProductTest {

	
    private static final String NAME = "Mr. Sparkle";
    private static final BigDecimal PRICE = BigDecimal.valueOf(1);

    @Test
    public void testProductName() throws Exception{
        //given
    	
        // when
        Product product = new Product(NAME, PRICE);
        
        // then
        assertEquals(NAME, product.getName());
    }
    
    @Test
    public void testProductPrice() throws Exception{
        //given
    	
        // when
        Product product = new Product(NAME, PRICE);
        
        // then
        assertBigDecimalCompareValue(product.getPrice(), PRICE);
    }

    @Test
    public void testProductPriceWithDiscount() throws Exception{
        //given
        BigDecimal discount = BigDecimal.valueOf(0.25);

        // when
        Product product = new Product(NAME, PRICE, discount);

        // then
        assertBigDecimalCompareValue(product.getPriceWithDiscount(), BigDecimal.valueOf(0.75));
    }

    @Test
    public void testProductPriceWithDiscountWithRoundUp() throws Exception{
        //given
        BigDecimal discount = BigDecimal.valueOf(0.125);

        // when
        Product product = new Product(NAME, PRICE, discount);

        // then
        assertBigDecimalCompareValue(product.getPriceWithDiscount(), BigDecimal.valueOf(0.88));
    }

    @Test
    public void testProductPriceWithDiscountWithRoundDown() throws Exception{
        //given
        BigDecimal discount = BigDecimal.valueOf(0.129);

        // when
        Product product = new Product(NAME, PRICE, discount);

        // then
        assertBigDecimalCompareValue(product.getPriceWithDiscount(), BigDecimal.valueOf(0.87));
    }

}