package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.banking.AccountTypes;
import com.app.banking.BankAccount;
import com.app.exceptions.BankAccountException;
import static com.app.utils.BankingUtils.*;


public class BankingValidations {
	public static BankAccount ValidateAccountDetails(String fName, String lName, String aT, String dob,
			double balance) throws BankAccountException
	{
		AccountTypes ac=parseAndValidateACType(aT);
		LocalDate d=parseDate(dob);
		validateMinBalance(ac,balance);
		
		return new BankAccount(fName,lName,ac,d,balance);
		
	}
	public static AccountTypes parseAndValidateACType(String aT) 
	{
		
		AccountTypes aT1=AccountTypes.valueOf(aT.toUpperCase());
		
		return aT1;
	}
	public static LocalDate parseDate(String date)
	{
		return LocalDate.parse(date);
	}
	public static void validateMinBalance(AccountTypes ac,double balance) throws BankAccountException
	{
		if(ac.getMinBalance()>balance)
		{
			throw new BankAccountException("Your balance is less than as per requirement");
		}
	}
	public static double withdrawAmount(int acctNo,double amount,List<BankAccount>lst) throws BankAccountException
	{
		BankAccount ba=findAccountDetailsByAccountNo(acctNo,lst);
		if(ba.getBalance()>amount)
		{
			double a=ba.getBalance()-amount;
			if(a>=(ba.getaT().getMinBalance()))
			{
				return a;
			}
			else
			{
				throw new BankAccountException("Withdrawal amount exceeds minimum balance requirement");
			}
		}
		else
		{
			throw new BankAccountException("Your balance is less than amount you want to deduct");
		}
		
	}
	public static double depositAmount(int acctNo,double amount,List<BankAccount>lst) throws BankAccountException 
	{
		BankAccount ba=findAccountDetailsByAccountNo(acctNo,lst);
		
			double a=ba.getBalance()+amount;
			
		    return a;
	}
	
	public static List<Double> transferMoney(int sAcctNo,double amount,int dAcctNo,List<BankAccount>lst) throws BankAccountException
	{
		
		BankAccount dact=findAccountDetailsByAccountNo(dAcctNo,lst);
		double rA=withdrawAmount(sAcctNo,amount,lst);
		double aA=depositAmount(dAcctNo,amount,lst);
		
		List<Double>ld=new ArrayList<Double>();
		ld.add(rA);
		ld.add(aA);
		
		return ld;
	}
	public static List<BankAccount> findAccountHolderByAccountType(String acType,List<BankAccount>lst)
	{
		List<BankAccount> ls=new ArrayList<>();
		AccountTypes at=parseAndValidateACType(acType);
		for(BankAccount b:lst)
		{
			if(b.getaT()==at)
			{
				ls.add(b);
			}
			
		}
		
		return ls;
	}
		
}