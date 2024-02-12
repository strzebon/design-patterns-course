package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class SearchStrategyTest {
    @Test
    public void testProductNameStrategyTrue(){
        Product product = mock(Product.class);
        String name = "flamaster";
        given(product.getName()).willReturn(name);
        List<Product> products = new ArrayList<>();
        products.add(product);
        Order order = new Order(products);
        OrderLog log = new OrderLog(order);
        ProductNameStrategy strategy = new ProductNameStrategy(name);
        assertTrue(strategy.filter(log));
    }

    @Test
    public void testProductNameStrategyFalse(){
        Product product = mock(Product.class);
        String name = "flamaster";
        given(product.getName()).willReturn(name);
        List<Product> products = new ArrayList<>();
        products.add(product);
        Order order = new Order(products);
        OrderLog log = new OrderLog(order);
        ProductNameStrategy strategy = new ProductNameStrategy("kredka");
        assertFalse(strategy.filter(log));
    }

    @Test
    public void testPurchaserNameStrategyTrue(){
        String name = "Kowalski";
        Address addres = mock(Address.class);
        given(addres.getName()).willReturn(name);
        Shipment shipment = mock(Shipment.class);
        given(shipment.getRecipientAddress()).willReturn(addres);
        Order order = mock(Order.class);
        given(order.getShipment()).willReturn(shipment);
        OrderLog log = new OrderLog(order);
        PurchaserNameStrategy strategy = new PurchaserNameStrategy(name);
        assertTrue(strategy.filter(log));
    }

    @Test
    public void testPurchaserNameStrategyFalse(){
        String name = "Kowalski";
        Address addres = mock(Address.class);
        given(addres.getName()).willReturn(name);
        Shipment shipment = mock(Shipment.class);
        given(shipment.getRecipientAddress()).willReturn(addres);
        Order order = mock(Order.class);
        given(order.getShipment()).willReturn(shipment);
        OrderLog log = new OrderLog(order);
        PurchaserNameStrategy strategy = new PurchaserNameStrategy("Kowal");
        assertFalse(strategy.filter(log));
    }

    @Test
    public void testOrderPriceStrategyTrue(){
        BigDecimal price = BigDecimal.valueOf(1);
        Order order = mock(Order.class);
        given(order.getPrice()).willReturn(price);
        OrderLog log = new OrderLog(order);
        OrderPriceStrategy strategy = new OrderPriceStrategy(price);
        assertTrue(strategy.filter(log));
    }

    @Test
    public void testOrderPriceStrategyFalse(){
        BigDecimal price = BigDecimal.valueOf(1);
        Order order = mock(Order.class);
        given(order.getPrice()).willReturn(price);
        OrderLog log = new OrderLog(order);
        OrderPriceStrategy strategy = new OrderPriceStrategy(BigDecimal.valueOf(2));
        assertFalse(strategy.filter(log));
    }

    @Test
    public void testCompositeStrategyTrue(){
        CompositeSearchStrategy strategy = new CompositeSearchStrategy();
        SearchStrategy s1 = mock(SearchStrategy.class);
        SearchStrategy s2 = mock(SearchStrategy.class);
        SearchStrategy s3 = mock(SearchStrategy.class);

        OrderLog log = mock(OrderLog.class);

        given(s1.filter(log)).willReturn(true);
        given(s2.filter(log)).willReturn(true);
        given(s3.filter(log)).willReturn(true);

        strategy.addStrategy(s1);
        strategy.addStrategy(s2);
        strategy.addStrategy(s3);

        assertTrue(strategy.filter(log));
    }

    @Test
    public void testCompositeStrategyFalse(){
        CompositeSearchStrategy strategy = new CompositeSearchStrategy();
        SearchStrategy s1 = mock(SearchStrategy.class);
        SearchStrategy s2 = mock(SearchStrategy.class);
        SearchStrategy s3 = mock(SearchStrategy.class);

        OrderLog log = mock(OrderLog.class);

        given(s1.filter(log)).willReturn(true);
        given(s2.filter(log)).willReturn(false);
        given(s3.filter(log)).willReturn(true);

        strategy.addStrategy(s1);
        strategy.addStrategy(s2);
        strategy.addStrategy(s3);

        assertFalse(strategy.filter(log));
    }




}
