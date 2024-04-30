package com.app.utils;
import com.app.customer.*;
import com.app.CustomeException.CustomExceptions;


import java.time.*;
public class CustomerValidations {
	
	public static Customer validateInputs(String fname, String lname, String email, String password,  String dob,
			String sp,double registrationAmount,Customer[] accounts)throws CustomExceptions
	{
		checkDuplicateEmail(email,accounts);
		
		LocalDate dob1 = parseDob(dob);
		ServicePlans sp1 = parseAndValidateServicePlan(sp);
		validateAmount(registrationAmount,sp1);
		
		return new Customer(fname,lname,email,password,dob1,sp1,registrationAmount);
	}
	
	

	public static ServicePlans parseAndValidateServicePlan(String sp) {
		
		return ServicePlans.valueOf(sp.toUpperCase());
		
	}
	
    public static LocalDate parseDob(String dob) {
		
		return LocalDate.parse(dob);
		
	}
    public static void validateAmount(double registrationAmount,ServicePlans sp) throws CustomExceptions
    {
    	if(registrationAmount < sp.getAmount() )
    	{
    		throw new CustomExceptions("Amount is lesser than specified registration amount");
    	}
    	else if(registrationAmount > sp.getAmount())
    	{
    		throw new CustomExceptions("Amount is more than specified registration amount");
    	}
    }

/*	public static void checkDuplicateEmail(String email,Customer[] accounts) throws CustomExceptions
	{
		System.out.println("Check Email");
		Customer cm=new Customer(email);
		for(Customer c: accounts)
		{
			System.out.println("Check Email1");
			/*boolean b = c.equals(cm);
			System.out.println(b);
			if(c!= null && c.equals(cm))
			{
				System.out.println("Check Email2");
			    throw new CustomExceptions("Email ID is already exist in the system");
			}
		}
		
		
		
		
	}*/
    
    public static void checkDuplicateEmail(String email,Customer[] accounts)throws CustomExceptions
    {
    	for(Customer c: accounts)
		{
			if(c!= null && (c.getEmail().equals(email)))
			{
				throw new CustomExceptions("Email ID is already exist in the system");
			}
		}
    }
    
    public static boolean validateSignIn(String email,String password,Customer[]  accounts)throws CustomExceptions
    {
    	for(Customer c : accounts)
    	{
    		if ((c.getEmail().equals(email)) && (c.getPassword().equals(password)))
    		{
    			return true;
    		}
    	}
    	throw new CustomExceptions("Invalid email or password");
    	
    }
}
