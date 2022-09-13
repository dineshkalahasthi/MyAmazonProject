package emart;

public interface MembershipCardHolder {
	int DEFAULT_POINTS = 100;
	
	float redeemPoints(int pointsToRedeem);
	void addPoints(float money);
	
	static float getMoneyFromPoints(int points) {
		return points * 0.5f;	// Point value is Rs. 0.5
	}
	
	static int getPointsFromMoney(float money) {
		return (int) money / 100;	// Point cost is Rs. 100
	}
	
	default void addPointsFromFuelPurchase(float fuelPrice) {
		this.addPoints(fuelPrice * 0.5f);
	}
}