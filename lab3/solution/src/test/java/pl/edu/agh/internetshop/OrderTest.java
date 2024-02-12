package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

public class OrderTest {

	private Order getOrderWithMockedProduct() {
		Product product = mock(Product.class);
		List<Product> products = new ArrayList<>();
		products.add(product);
		return new Order(products);
	}

	@Test
	public void testGetProductThroughOrder() {
		// given
		Product expectedProduct = mock(Product.class);
		List<Product> expectedProducts = new ArrayList<>();
		expectedProducts.add(expectedProduct);
		Order order = new Order(expectedProducts);
		// when
		List<Product> actualProducts = order.getProducts();

		// then
		assertSame(expectedProducts, actualProducts);
	}


	@Test
	public void testSetShipment() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();
		Shipment expectedShipment = mock(Shipment.class);

		// when
		order.setShipment(expectedShipment);

		// then
		assertSame(expectedShipment, order.getShipment());
	}

	@Test
	public void testShipmentWithoutSetting() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();

		// when

		// then
		assertNull(order.getShipment());
	}

	@Test
	public void testGetPrice() throws Exception {
		// given
		BigDecimal expectedProductPrice = BigDecimal.valueOf(1000);
		Product product = mock(Product.class);
		given(product.getPrice()).willReturn(expectedProductPrice);
		List<Product> products = new ArrayList<>();
		products.add(product);
		Order order = new Order(products);

		// when
		BigDecimal actualProductPrice = order.getPrice();

		// then
		assertBigDecimalCompareValue(expectedProductPrice, actualProductPrice);
	}

	private Order getOrderWithCertainPriceAndNumberOfProducts(double productPriceValue, int numberOfProducts) {
		BigDecimal productPrice = BigDecimal.valueOf(productPriceValue);
		List<Product> products = new ArrayList<>();

		for (int i=0; i<numberOfProducts; i++){
			Product product = mock(Product.class);
			given(product.getPrice()).willReturn(productPrice);
			products.add(product);
		}

		return new Order(products);
	}

	@Test
	public void testPriceWithTaxesWithoutRoundUp() {
		// given

		// when
		Order order = getOrderWithCertainPriceAndNumberOfProducts(2, 1); // 2 PLN

		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(2.46)); // 2.46 PLN
	}

	@Test
	public void testPriceWithTaxesWithRoundDown() {
		// given

		// when
		Order order = getOrderWithCertainPriceAndNumberOfProducts(0.01, 1); // 0.01 PLN

		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(0.01)); // 0.01 PLN
																							
	}

	@Test
	public void testPriceWithTaxesWithRoundUp() {
		// given

		// when
		Order order = getOrderWithCertainPriceAndNumberOfProducts(0.01, 3); // 0.03 PLN

		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(0.04)); // 0.04 PLN
																							
	}

	@Test
	public void testSetShipmentMethod() {
		// given
		Order order = getOrderWithMockedProduct();
		ShipmentMethod surface = mock(SurfaceMailBus.class);

		// when
		order.setShipmentMethod(surface);

		// then
		assertSame(surface, order.getShipmentMethod());
	}

	@Test
	public void testSending() {
		// given
		Order order = getOrderWithMockedProduct();
		SurfaceMailBus surface = mock(SurfaceMailBus.class);
		Shipment shipment = mock(Shipment.class);
		given(shipment.isShipped()).willReturn(true);

		// when
		order.setShipmentMethod(surface);
		order.setShipment(shipment);
		order.send();

		// then
		assertTrue(order.isSent());
	}

	@Test
	public void testIsSentWithoutSending() {
		// given
		Order order = getOrderWithMockedProduct();
		Shipment shipment = mock(Shipment.class);
		given(shipment.isShipped()).willReturn(true);

		// when

		// then
		assertFalse(order.isSent());
	}

	@Test
	public void testWhetherIdExists() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();

		// when

		// then
		assertNotNull(order.getId());
	}

	@Test
	public void testSetPaymentMethod() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();
		PaymentMethod paymentMethod = mock(MoneyTransferPaymentTransaction.class);

		// when
		order.setPaymentMethod(paymentMethod);

		// then
		assertSame(paymentMethod, order.getPaymentMethod());
	}

	@Test
	public void testPaying() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();
		PaymentMethod paymentMethod = mock(MoneyTransferPaymentTransaction.class);
		given(paymentMethod.commit(any(MoneyTransfer.class))).willReturn(true);
		MoneyTransfer moneyTransfer = mock(MoneyTransfer.class);
		given(moneyTransfer.isCommitted()).willReturn(true);

		// when
		order.setPaymentMethod(paymentMethod);
		order.pay(moneyTransfer);

		// then
		assertTrue(order.isPaid());
	}

	@Test
	public void testIsPaidWithoutPaying() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();

		// when

		// then
		assertFalse(order.isPaid());
	}

	@Test
	public void testGetMultipleProductThroughOrder() {
		// given
		Product expectedProduct1 = mock(Product.class);
		Product expectedProduct2 = mock(Product.class);
		Product expectedProduct3 = mock(Product.class);

		List<Product> expectedProducts = new ArrayList<>();
		expectedProducts.add(expectedProduct1);
		expectedProducts.add(expectedProduct2);
		expectedProducts.add(expectedProduct3);

		Order order = new Order(expectedProducts);
		// when
		List<Product> actualProducts = order.getProducts();

		// then
		assertSame(expectedProducts, actualProducts);
	}

	@Test
	public void testPriceWithDiscount() {
		// given

		// when
		Order order = getOrderWithCertainPriceAndNumberOfProducts(1, 1);
		order.setDiscount(BigDecimal.valueOf(0.25));

		// then
		assertBigDecimalCompareValue(order.applyDiscount(order.getPrice()), BigDecimal.valueOf(0.75));

	}

	@Test
	public void testPriceWithDiscountWithRoundUp() {
		// given

		// when
		Order order = getOrderWithCertainPriceAndNumberOfProducts(1, 1);
		order.setDiscount(BigDecimal.valueOf(0.125));

		// then
		assertBigDecimalCompareValue(order.applyDiscount(order.getPrice()), BigDecimal.valueOf(0.88));
	}

	@Test
	public void testPriceWithDiscountWithRoundDown() {
		/// given

		// when
		Order order = getOrderWithCertainPriceAndNumberOfProducts(1, 1);
		order.setDiscount(BigDecimal.valueOf(0.009));

		// then
		assertBigDecimalCompareValue(order.applyDiscount(order.getPrice()), BigDecimal.valueOf(0.99));
	}
}
