package com.app.tester;

import static com.app.utils.BankingUtils.createANewAccount;
import static com.app.utils.BankingUtils.findAccountDetailsByAccountNo;
import static com.app.utils.BankingUtils.populateList;
import static com.app.utils.BankingUtils.removeAccount;
import static com.app.utils.BankingValidations.findAccountHolderByAccountType;
import static com.app.utils.BankingValidations.transferMoney;
import static com.app.utils.BankingValidations.withdrawAmount;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.app.banking.BankAccount;
import com.app.customordering.BankingCustomOrdering;

public class BankingApp {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			boolean exit=false;
			List<BankAccount>ba=populateList();
			while(!exit)
			{
				System.out.println("Enter your choice: \n 1.DisplayAllBankAccounts 2. Create An Bank Account 3.Display Account Details by account no"
						+ " 4.Withdraw Money 5.TransferMoney 6.Display Account Holder Names having specific type of Account 7. Delete account "
						+ " 8.Natural Ordering by account no 9.Custom Ordering By dob 0.exit");
				switch(sc.nextInt())
				{
				
				case 1:
					ba.forEach(l->System.out.println(l));
					break;
						
				case 2:
					System.out.println("Enter first name,last name, account type , dob , balance\r\n");
					BankAccount acct=createANewAccount(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble());
					System.out.println(acct);
					ba.add(acct);
					System.out.println("Account added successfully");
					break;
					
				case 3:
					System.out.println("Enter your bank account no");
					BankAccount acct1=findAccountDetailsByAccountNo(sc.nextInt(),ba);
					System.out.println(acct1);
					
				break;
				
				case 4:
					System.out.println("Enter your account no and amount to withdraw");
					Double balance=withdrawAmount(sc.nextInt(),sc.nextDouble(),ba);
					System.out.println("Amount withdrawsuccesfuly and remainin6g balance is: "+balance);
					break;
					
				case 5:
					System.out.println("Enter your accountno and money to transfer also the destination account number");
					List<Double>lst=transferMoney(sc.nextInt(),sc.nextDouble(),sc.nextInt(),ba);
					System.out.println("Amount transfer done successfully");
					System.out.println("Source Account Balance"+lst.get(0));
					System.out.println("Destination Account Balance"+lst.get(1));
					break;
					
				case 6:
					System.out.println("Enter account type");
					List<BankAccount>lb=findAccountHolderByAccountType(sc.next(),ba);
					System.out.println("Account Holder Names:");
					lb.forEach(s -> System.out.println(s.getfName()+s.getlName()));
					break;
					
				case 7:
					System.out.println("Enter your account number");
					String s=removeAccount(sc.nextInt(),ba);
					System.out.println(s);
					break;
					
				case 8:
					Collections.sort(ba);
					break;
					
				case 9:
					Collections.sort(ba,new BankingCustomOrdering());
					break;
					
				case 0:
					exit=true;
					break;
				}
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
	
	}

}
}
