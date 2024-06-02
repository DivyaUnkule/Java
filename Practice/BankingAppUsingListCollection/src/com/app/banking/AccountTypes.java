package com.app.banking;

public enum AccountTypes {
	SAVINGS(2500),LOAN(25000),CURRENT(1000);
	
	private double minBalance;
	
	AccountTypes(double minBalance)
	{
		this.minBalance=minBalance;
	}
	
	public double getMinBalance()
	{
		return this.minBalance;
	}
	
	public String toString()
	{
		return name()+" : "+minBalance;
	}

}
