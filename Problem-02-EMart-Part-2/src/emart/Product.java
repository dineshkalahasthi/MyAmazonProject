package emart;

public class Product {

	private int productId;
	private String name;
	private float price;
	private int stock;
	
	private static int idCounter = 1000;

	public Product(String name, float price, int stock) {
		this.productId = ++idCounter;
		this.name = name;
		this.price = price;
		this.stock = stock;
		//System.out.println("Product created!");
	}
	
	public float getPriceAfterDiscount(int discountPercentage) {
        float discountedPrice = price - (price * discountPercentage / 100);
        return discountedPrice;
    }

	// Display details for E-Mart employees
    public void displayDetails() {
        System.out.println("Product Id: " + productId);
        System.out.println("Product Name: " + name);
        System.out.println("Product Price: " + price);
        System.out.println("Stock: " + stock);
    }
    
    // Display details for customers
    public void displayDetails(int discountPercentage) {
        System.out.println("Product Name: " + name);
        System.out.println("Discounted price: " + getPriceAfterDiscount(discountPercentage));
        if(stock > 0) System.out.println("In stock");
        else System.out.println("Out of stock!");
    }

	public int getId() {
		return productId;
	}

	public void setId(int id) {
		this.productId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}
