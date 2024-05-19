package com.app.tester;

import static com.app.utils.CustomerUtils.*;
import static com.app.utils.CustomerValidations.*;
import java.util.*;
import com.app.core.Customer;

public class CustomerManagementApp {

	public static void main(String[] args) {
		Map<String,Customer>map=populateMap(populateList());
		boolean exit=false;
		
		
		try(Scanner sc=new Scanner(System.in))
		{
			while(!exit)
			{
				try {
			    System.out.println("Enter Your Choice: 1.SignUp to create an account 2.SignIn to login 3.Display Details 4.Change Password 5.Remove Account 6.Sort according to Email using Natural Ordering 7.Sort as per the dob n last name : using custom ordering 8.Remove all customer details from specified plan born after specified date 9.Diaply customers having Age more than 21 0.exit");
				int choice = sc.nextInt();
				
				switch(choice)
				{
				case 1://SignUp
					Customer c=signUp(sc.next(),sc.next(), sc.next(),sc.next(),sc.next(),
			sc.next(),sc.nextDouble(),map);
					
					
					System.out.println("You have registered successfully...");
					
					break;
					
				case 2://SignIn
					
					System.out.println("Enter your Email and Password");
					c=signIn(sc.next(),sc.next(),map);
					System.out.println("Your Details"+c.toString());
					
					break;
					
				case 3://Display Customer List
					map.forEach((k,v)-> System.out.println(k+v));
					break;
					
				case 4://Change Password
					System.out.println("Enter your email and password");
					c=signIn(sc.next(),sc.next(),map);
					System.out.println("Enter Old Password again and new Password to set");
					System.out.println(changePassword(sc.next(),sc.next(),c));
					break;
					
				case 5://Remove Account
					
				System.out.println("Enter your EmailID");
			    System.out.println(removeAccount(sc.next(),map));
			    
				case 6:
					//Display customer details sorted as per the email (asc) : using natural ordering
					Collection<Customer>cust=map.values();
					List<Customer> lst=new ArrayList<>(cust);
					Collections.sort(lst);
					lst.forEach(s->System.out.println(s));
					break;
					
				case 7:
					//Display customer details sorted as per the dob n last name : using custom ordering 
					Collection<Customer>customer=map.values();
					List<Customer>list=new ArrayList<Customer>(customer);
					Comparator<Customer>cmp=(s1,s2)->{int ds=(s1.getDate()).compareTo(s2.getDate());
					if(ds == 0)
						{
						  return (s1.getlName()).compareTo(s2.getlName());
						}
					return ds;
					};
					Collections.sort(list,cmp);
					list.forEach(s->System.out.println(s));
					
					break;
					
				case 8:
					//Remove all customer details from specified plan born after specified date.
					//i/p : plan n date
					
					System.out.println("Enter service plan and date of birth");
					removeAsPerSpecifiedPlanAndDateOfBirth(sc.next(),sc.next(),map);
					break;
					
				case 9:
					//Display Customers having age more than 21
					displayCustomersHavingAgeMoreThan21(map);
					break;
					
				case 0:
					exit=true;
					break;
				}
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
			
			
		}
		
	    
		System.out.println("Main Over");
		}

}
