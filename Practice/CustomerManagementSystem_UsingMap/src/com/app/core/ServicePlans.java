package com.app.core;

public enum ServicePlans {
	SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);
	
	private double amount;

	private ServicePlans(double amount) {
		this.amount=amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	


}
