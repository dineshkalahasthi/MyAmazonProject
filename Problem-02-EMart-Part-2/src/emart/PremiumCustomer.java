package emart;

public final class PremiumCustomer extends Customer implements MembershipCardHolder {
	
	private int points = DEFAULT_POINTS;
	
	public PremiumCustomer(int id, String name, String password, String phone, Address address) {
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
		System.out.println("Points remaining: " + this.points);
	}
	
	@Override
	public float redeemPoints(int pointsToRedeem) {
		pointsToRedeem = pointsToRedeem > this.points ? this.points : pointsToRedeem;
		
		float amountToRedeem = pointsToRedeem * 0.5f;	// Point value is Rs. 0.5
		// To do: Use the following line to use the interface
		//float amountToRedeem = MembershipCardHolder.getMoneyFromPoints(pointsToRedeem);
		
		this.points = this.points - pointsToRedeem;
		return amountToRedeem;
	}
	
	@Override
	public void addPoints(float money) {
		this.points += (int) money / 100;	// Point cost is Rs. 100
		// To do: Use the following line to use the interface
		//this.points += MembershipCardHolder.getPointsFromMoney(money);
	}
	
	@Override
	public float orderProducts(Product[] products) throws Exception {
		float billAmount = super.orderProducts(products);
		float finalAmount = billAmount * 0.90f;		// Applying 10% discount
		addPoints(finalAmount);
		return finalAmount;
	}
	
	public float orderProducts(Product[] products, int pointsToRedeem) throws Exception {
		float billAmount = super.orderProducts(products);
		float finalAmount = billAmount * 0.90f;				// Applying 10% discount
		if(finalAmount != 0)
			finalAmount -= redeemPoints(pointsToRedeem);	// Redeeming points
		addPoints(finalAmount);
		return finalAmount;
	}
}
