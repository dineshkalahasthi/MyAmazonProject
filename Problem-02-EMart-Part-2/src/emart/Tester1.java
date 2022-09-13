package emart;

public class Tester1 {

	public static void main(String[] args) throws Exception {
		
		// Creating stocks of products
		Product tShirt = new Product("T-Shirt", 499, 1);
		Product halfPant = new Product("Half Pant", 299, 3);
		Product trousers = new Product("Trousers", 599, 2);
		Product cap = new Product("Cap", 199, 0);
		
		
		trousers.displayDetails();
		System.out.println("=======================================");
		cap.displayDetails(5);
		System.out.println("=======================================");
	}
}
