package emart;

public final class RegularCustomer extends Customer {
	
	public RegularCustomer(int id, String name, String password, String phone, Address address) {
		this.setCustomerId(id);
		this.setName(name);
		this.setPassword(password);
		this.setPhone(phone);
		this.setAddress(address);
	}
	
	@Override
	public void displayDetails() {
		System.out.println("Customer Id: " + this.getCustomerId());
		System.out.println("Customer Name: " + this.getName());
		System.out.println("Customer phone: " + this.getPhone());
	}
	
	@Override
	public float orderProducts(Product[] products) throws Exception {
		float billAmount = super.orderProducts(products);
		return billAmount * 0.95f;		// Applying 5% discount
	}
}
