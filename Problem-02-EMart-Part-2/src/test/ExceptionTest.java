package test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import emart.BillCalculator;
import emart.OutOfStockException;
import emart.Product;

public class ExceptionTest {
	@Rule
	public ExpectedException ee = ExpectedException.none();
	
	@Test
	public void processOrderInvalidTest() throws Exception {
		Product[] products = new Product[3];
		products[0] = new Product("Jeans", 499, 0);
		
		ee.expect(OutOfStockException.class);
        ee.expectMessage("Jeans");
        BillCalculator billCalc = new BillCalculator();
		billCalc.processOrder(products);
	}
}
