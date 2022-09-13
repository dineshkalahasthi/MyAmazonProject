package emart;

abstract class Customer {
	
	private int customerId;
	private String password;
	private String name;
	private String phone;
	private Address address;
	
	public abstract void displayDetails();
	
	public float orderProducts(Product[] products) throws Exception {
		
		// For Tester2
		/*BillCalculator billCalc = new BillCalculator();
		billCalc.processOrder(products);
		return billCalc.getAmount();*/
		
		// To do (for Tester3 and 4): Use the following to see handling of exceptions
		try {
			BillCalculator billCalc = new BillCalculator();
			billCalc.processOrder(products);
			return billCalc.getAmount();
		} catch(Exception e) {
			// Logging
			throw e;	// propagating exception further
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		Customer other = (Customer) obj;
		if (name.equals(other.name))
			if (phone.equals(other.phone))
				return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Customer " + customerId + ": name=" + name + ", phone=" + phone;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int id) {
		this.customerId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
