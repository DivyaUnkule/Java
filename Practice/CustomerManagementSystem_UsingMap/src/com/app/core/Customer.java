package com.app.core;

import java.time.LocalDate;
import java.util.Objects;

public class Customer implements Comparable<Customer>{
	private int id;
	private String fName;
	private String lName;
	private String email;
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlans sp;
	private static int idGenerator;
	public Customer(String fname, String lname, String email, String password, LocalDate dob,
			ServicePlans sp,double registrationAmount) {
		super();
		this.id = idGenerator++;
		this.fName = fname;
		this.lName = lname;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.sp = sp;
	}
	public Customer(String email) {
		this.email=email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getRegistrationAmount() {
		return registrationAmount;
	}
	public void setRegistrationAmount(double registrationAmount) {
		this.registrationAmount = registrationAmount;
	}
	public LocalDate getDate() {
		return dob;
	}
	public void setDate(LocalDate date) {
		this.dob = date;
	}
	public ServicePlans getSp() {
		return sp;
	}
	public void setSp(ServicePlans sp) {
		this.sp = sp;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", password="
				+ password + ", registrationAmount=" + registrationAmount + ", date=" + dob + ", sp=" + sp + "]";
	}
	
	  @Override 
	  public boolean equals(Object o) { 
		  if(o instanceof Customer) {
			  Customer c=(Customer)o;
			  return this.email.equals(c.email);
	  }
	 
	 return false; 
	 }
	  
	  @Override
	  public int compareTo(Customer c)
	  {
			  return (this.email).compareTo(c.email);
	  }
	 
	
	

}
