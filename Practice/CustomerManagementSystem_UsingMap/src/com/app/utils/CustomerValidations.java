package com.app.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.Map;

import com.app.Custom_Exception.CustomerException;
import com.app.core.Customer;
import com.app.core.ServicePlans;

public class CustomerValidations {
	
	public static Customer signUp(String fname, String lname, String email, String password, String dob,
			String sp,double registrationAmount,Map<String,Customer> m) throws CustomerException
	{
		checkDuplicate(email,m);
		LocalDate d=parseDob(dob);
		ServicePlans s=validateRegistrationAmount(sp,registrationAmount);
		Customer cust=new Customer(fname,lname,email,password,d,s,registrationAmount);
		m.put(email, cust);
		return cust;
	}
	
	public static void checkDuplicate(String email,Map<String,Customer> m) throws CustomerException
	{
		
		Collection<Customer>cust=m.values();
		
		
		Customer newCust = new Customer(email);
		
		   if(cust.contains(newCust))
            {
            	throw new CustomerException("Duplicate Email ID");
            }
		
	    
		
	}
	
	public static LocalDate parseDob(String dob)
	{
		LocalDate d=LocalDate.parse(dob);
		return d;
		
	}
	
	public static ServicePlans validateRegistrationAmount(String sp,double registrationAmount) throws CustomerException
	{
		ServicePlans s=ServicePlans.valueOf(sp.toUpperCase());
		
		if(s.getAmount() != registrationAmount && registrationAmount < s.getAmount())
		{
			throw new CustomerException("Registration amount is less than specified amount");
		}
		
		else if(s.getAmount() != registrationAmount && registrationAmount > s.getAmount())
		{
			throw new CustomerException("Registration amount is more than specified amount");
		}
		return s;
	}
	
	public static Customer signIn(String email,String password,Map<String,Customer>m) throws CustomerException
	{
		Collection<Customer>cust = m.values();
		for(Customer c:cust)
		{
			if(email.equals(c.getEmail())&& password.equals(c.getPassword()))
			{
			    return c;
			}
			
		}
		
		throw new CustomerException("Invalid Username or Password");
		
	}

	public static String changePassword(String oPasswd,String nPasswd,Customer c)
	{
		c.setPassword(nPasswd);
		return "Password Updated Successfully";
	}
	public static boolean validateEmail(String email,Map<String,Customer> m) throws CustomerException
	{
		
		if(m.containsKey(email))
		{
			return true;
		}
		throw new CustomerException("Invalid Email ID");
		
	}
	
	public static String removeAccount(String email,Map<String,Customer>m) throws CustomerException 
	{
		if(validateEmail(email,m))
		{
			m.remove(email);
			return "Account Removed Successfully";
		}
		return "Account not removed Successfully retry again!!!";
	}
	
	public static void removeAsPerSpecifiedPlanAndDateOfBirth(String sp,String dob,Map<String,Customer>map)throws CustomerException
	{
		LocalDate d=parseDob(dob);
		ServicePlans s=ServicePlans.valueOf(sp.toUpperCase());
	     if( map.values().removeIf(c-> (c.getDate().isAfter(d)) && (c.getSp()==s)))
	      {
		     System.out.println("Account removed Successfully");
		  }
	     else
	     {
	    	 throw new CustomerException ("Specified plan is wrong");
	     }
	
	}
	public static void displayCustomersHavingAgeMoreThan21(Map<String,Customer>map)
	{
		//map.values().stream().filter(null);
		Collection<Customer>cust=map.values();
		
		for(Customer c: cust)
		{
			int years=(Period.between(c.getDate(),LocalDate.now()).getYears());
			if(years > 21)
			{
               System.out.println(c);
		    }
		
		//cust.stream().forEach(c ->System.out.println(filter((Period.between(c.getDate(), LocalDate.now()).getYears())>21));
			
	}
}
}
