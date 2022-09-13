package emart;

/* To demonstrate exception handling */
public class Tester3 {

	public static void main(String[] args) throws Exception {
		
		// Creating stocks of products
		Product tShirt = new Product("T-Shirt", 499, 1);
		Product halfPant = new Product("Half Pant", 299, 3);
		Product trousers = new Product("Trousers", 599, 2);
		Product cap = new Product("Cap", 199, 0);
		
		// Array of products to buy
		Product[] products = new Product[3];
		products[0] = tShirt;
		products[1] = halfPant;
		products[2] = trousers;
		
		
		// Customers buying products (using exception handling)
		Customer regCust = new RegularCustomer(101, "Tony", "tony123", "9876543210", new Address("1 Hebbal", "Mysore", 570027));
		try {
			System.out.println("Total bill for regular customer " + regCust.getCustomerId() + ": " + regCust.orderProducts(products));
			showCustomerDetails(regCust);
		}
		catch (Exception e) {
				System.out.println("Sorry customer-" + regCust.getCustomerId());
				System.out.println(e.getMessage());
		}
		System.out.println("=======================================");

		PremiumCustomer premCust = new PremiumCustomer(102, "Banner", "banner123", "9876543211", new Address("2 Hebbal", "Mysore", 570027));
		try {
			System.out.println("Total bill for premium customer " + premCust.getCustomerId() + ": " + premCust.orderProducts(products, 50));
			showCustomerDetails(premCust);
		}
		catch (Exception e) {
			System.out.println("Sorry customer-" + regCust.getCustomerId());
			System.out.println(e.getMessage());
		}
		System.out.println("=======================================");
	}
	
	public static void showCustomerDetails(Customer customer) {
		customer.displayDetails();
	}
}
