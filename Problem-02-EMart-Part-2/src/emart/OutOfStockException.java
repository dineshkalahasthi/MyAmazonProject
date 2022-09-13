package emart;

@SuppressWarnings("serial")
public class OutOfStockException extends Exception {
	public OutOfStockException(String productName) {
		super(productName);
	}
}
