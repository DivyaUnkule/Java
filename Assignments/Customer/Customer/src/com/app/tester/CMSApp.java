package com.app.tester;

import java.util.Scanner;
import static com.app.utils.CustomerValidations.*;
import com.app.customer.*;

public class CMSApp {

	public static void main(String[] args) {
		try(Scanner sc= new Scanner (System.in))
		{
			boolean exit = false;
			System.out.println("Enter max no of Customer accounts");
			Customer[] accounts = new Customer[sc.nextInt()];
			int counter = 0;
			
			while(!exit)
			{
				System.out.println("Enter your choice: 1.Sign Up to create an account 2.Sign In 3.Display Details 0.Exit");
				try
				{
					switch(sc.nextInt())
					{
					case 1:
						//Sign Up
						if(counter < accounts.length)
						{
						System.out.println("Enter FirstName,LastName,EmailID,Password,DateOfBirth");
						System.out.println("Enter the service plan which you want to take and RegistrationAmount,: SILVER-Registrationamt(1000 RS),GOLD-Regstrationamt(2000 RS),DIAMOND-Regstrationamt(5000 RS),PLATINUM-Regstrationamt(10000 RS)");
						
						Customer cm1 = validateInputs(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),accounts);
						
						accounts[counter++]=cm1;
						System.out.println("A/c created !");
						}
						else
						{
							System.out.println("Capacity is full!!!!");
						}
						
						break;
						
					case 2:
						// Sign in 
						System.out.println("Enter your email and password");
						if(validateSignIn(sc.next(),sc.next(),accounts))
						{
							System.out.println("Signed in successful");
						}
						
						
					case 3:
						//Display details
						
						for(Customer c : accounts)
						{
							System.out.println(c.toString());
						}
						
						break;
						
					case 0:
						exit=true;
						break;
						 
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
	}
}

				
