package com.app.customordering;

import java.util.Comparator;

import com.app.banking.BankAccount;

public class BankingCustomOrdering implements Comparator<BankAccount> {
	public int compare(BankAccount b1,BankAccount b2)
	{
		if(b1.getDob().isBefore(b2.getDob()))
		{
			return -1;
		}
		if(b1.getDob().equals(b2.getDob()))
		{
			return 0;
		}
		return 1;
	}

}
