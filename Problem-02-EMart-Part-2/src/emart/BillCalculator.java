package emart;

public class BillCalculator {
	private int billId;
	private float amount;

	public void processOrder(Product[] products) throws Exception {

		for (int i = 0; i < products.length; i++) {

			if (products[i].getStock() <= 0) {
				// To do (for Tester2): Use the following line to inform about out of stock products
				//System.out.println(products[i].getName() + " out of stock"); break;
				
				// To do (for Tester3): Use the following line to see handling of exceptions
				throw new Exception(products[i].getName() + " out of stock");
				
				// To do (for Tester4): Use the following line to see handling of user-defined exceptions
				//throw new OutOfStockException(products[i].getName());
			}
			else {
				this.amount += products[i].getPrice();
				products[i].setStock(products[i].getStock() - 1);
			}
		}
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}
}
