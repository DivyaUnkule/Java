package com.app.banking;

import java.time.LocalDate;
import java.util.Comparator;

public class BankAccount implements Comparable<BankAccount>{
	private int acNO;
	private String fName;
	private String lName;
	private AccountTypes aT;
	private LocalDate dob;
	private LocalDate cD;
	private double balance;
	private static int idGenerator;
	
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}

	public BankAccount(String fName, String lName, AccountTypes aT, LocalDate dob,
			double balance) {
		super();
		this.acNO = ++idGenerator;
		this.fName = fName;
		this.lName = lName;
		this.aT = aT;
		this.dob = dob;
		this.cD = LocalDate.now();
		this.balance = balance;
	}
	
	

	public BankAccount(int acNO, String fName, String lName, AccountTypes aT, LocalDate dob, LocalDate cD,
			double balance) {
		super();
		this.acNO = acNO;
		this.fName = fName;
		this.lName = lName;
		this.aT = aT;
		this.dob = dob;
		this.cD = cD;
		this.balance = balance;
	}

	public int getAcNO() {
		return acNO;
	}

	public void setAcNO(int acNO) {
		this.acNO = acNO;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public AccountTypes getaT() {
		return aT;
	}

	public void setaT(AccountTypes aT) {
		this.aT = aT;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getcD() {
		return cD;
	}

	public void setcD(LocalDate cD) {
		this.cD = cD;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public static int getIdGenerator() {
		return idGenerator;
	}

	public static void setIdGenerator(int idGenerator) {
		BankAccount.idGenerator = idGenerator;
	}

	@Override
	public String toString() {
		return "BankAccount [acNO=" + acNO + ", fName=" + fName + ", lName=" + lName + ", aT=" + aT + ", dob=" + dob
				+ ", cD=" + cD + ", balance=" + balance + "]";
	}

	@Override
	public boolean equals(Object o)
	{
		if(o instanceof BankAccount)
		{
			return this.acNO == ((BankAccount)o).acNO;
		}
		return false;
	}
	
	
	@Override
	public int compareTo(BankAccount o) {
		if(this.acNO < o.acNO)
		{
			return -1;
		}
		if(this.acNO == o.acNO)
		{
			return 0;
		}
		return 1;
		
	}
	
	
	
	
	
	
	

}
