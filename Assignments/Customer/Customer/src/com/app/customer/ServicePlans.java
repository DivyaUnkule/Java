package com.app.customer;

public enum ServicePlans {
	
	SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);
	
	private double amount;
	
	ServicePlans (double amount)
	{
		this.amount=amount;
	}

	public double getAmount() {
		return amount;
	}

	
}
