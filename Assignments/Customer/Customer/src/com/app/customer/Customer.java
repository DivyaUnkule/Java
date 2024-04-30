package com.app.customer;

import java.time.LocalDate;





public class Customer {

	private String fname;
	private String lname;
	private  String email;
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlans sp;
	private static int id=1;
	
	public Customer() {
		
	}
	public Customer(String fname, String lname, String email, String password, LocalDate dob,
			ServicePlans sp,double registrationAmount) {
		super();
		
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.sp = sp;
	}
	public Customer(String email)
	{
		this.email=email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id++ + ",fname=" + fname + ", lname=" + lname + ", email=" + email + ", password=" + password
				+ ", registrationAmount=" + registrationAmount + ", dob=" + dob + ", sp=" + sp + "]";
	}
	
/*	@Override
	public boolean equals(Object o)
	{
		//System.out.println("object checked");
		if(o instanceof Customer)
		{
			return this.email == ((Customer) o).email;
		}
		return false;
	}*/
	
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
