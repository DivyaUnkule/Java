package com.app.utils;

import static com.app.utils.BankingValidations.ValidateAccountDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.app.banking.AccountTypes;
import com.app.banking.BankAccount;
import com.app.exceptions.BankAccountException;

public class BankingUtils {
	public static List<BankAccount> populateList()
	{
		BankAccount a1=new BankAccount(101, "a1", "b1", AccountTypes.SAVINGS, LocalDate.parse("1990-12-17"),
				LocalDate.parse("2011-12-17"), 15000);
		BankAccount a2 = new BankAccount(10, "a2", "b2", AccountTypes.CURRENT, LocalDate.parse("1991-11-18"),
				LocalDate.parse("2012-12-17"), 8000);
BankAccount a3 = new BankAccount(45, "a3", "b3", AccountTypes.SAVINGS, LocalDate.parse("1993-12-17"),
				LocalDate.parse("2013-12-17"), 18000);
BankAccount a4 = new BankAccount(56, "a4", "b4", AccountTypes.CURRENT, LocalDate.parse("1992-01-17"),
				LocalDate.parse("2020-12-17"), 150000);
BankAccount a5 = new BankAccount(25, "a5", "b5", AccountTypes.LOAN, LocalDate.parse("1991-10-27"),
				LocalDate.parse("2019-12-17"), 25000);
BankAccount a6 = new BankAccount(40, "a6", "b6", AccountTypes.SAVINGS, LocalDate.parse("1994-06-15"),
				LocalDate.parse("2018-12-17"), 23000);
BankAccount a7 = new BankAccount(60, "a7", "b7", AccountTypes.SAVINGS, LocalDate.parse("1991-03-17"),
				LocalDate.parse("2018-12-11"), 35000);
BankAccount ba[]= {a1,a2,a3,a4,a5,a6,a7};
              List<BankAccount>lst=new ArrayList<>();
              for(BankAccount bn: ba)
              {
            	  lst.add(bn);
              }
            
        return lst;
		
	}
	
	public static BankAccount createANewAccount(String fName, String lName, String aT, String dob,
			double balance) throws BankAccountException
	{
		BankAccount b=ValidateAccountDetails(fName, lName, aT,dob,balance);
		
		return b;
	}
	public static BankAccount findAccountDetailsByAccountNo(int acctNo,List<BankAccount>lst) throws BankAccountException
	{
		Optional<BankAccount> account=lst.stream().filter(a -> a.getAcNO()==acctNo).findFirst();
		return account.orElseThrow(() -> new BankAccountException("Account with provided account no doesn't exist"));
	}
	public static String removeAccount(int acctNo,List<BankAccount>lst) throws BankAccountException
	{
		BankAccount b=findAccountDetailsByAccountNo(acctNo,lst);
		lst.remove(b);
		return "Account Removed Successfully";
	}

}
