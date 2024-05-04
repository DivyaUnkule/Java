package com.app.core;
import java.time.LocalDate;


public class Customer implements Comparable<Customer>{

	private String fname;
	private String lname;
	private  String email;
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlans sp;
	private int id;
	private static int idGenerator=1;
	
	
	public Customer(String fname, String lname, String email, String password, LocalDate dob,
			ServicePlans sp,double registrationAmount) {
		super();
		this.id = idGenerator++;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.sp = sp;
	}
	
	public Customer(String email,String password)
	{
		this.email=email;
		this.password=password;
	}
	
	public Customer(String email)
	{
		this.email=email;
		
	}

	public Customer(ServicePlans sp) {
		this.sp=sp;
	}
	
	public Customer(LocalDate dob) {
		this.dob=dob;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ",fname=" + fname + ", lname=" + lname + ", email=" + email + ", password=" + password
				+ ", registrationAmount=" + registrationAmount + ", dob=" + dob + ", sp=" + sp + "]";
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Customer)
		{
			Customer c=(Customer)o;
			return this.email.equals(c.email);
		}
		return false;
	}
	
	@Override
	public int compareTo(Customer customer)
	{
		
		return(this.email).compareTo(customer.email);
		
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

	public String getFirstName() {
		
		return this.fname;
	}

	public LocalDate getDob() {
		
		return this.dob;
	}

	public String getLastName() {
		// TODO Auto-generated method stub
		return this.lname;
	}

	public ServicePlans getServicePlan() {
		
		return this.sp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
