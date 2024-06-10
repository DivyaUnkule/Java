package com.app.tester;

import static com.app.utils.UtilsClass.addPet;
import static com.app.utils.UtilsClass.populatePet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.app.storingapp.Category;
import com.app.storingapp.Order;
import com.app.storingapp.Pet;
import static com.app.utils.AppValidations.*;

public class ApplicationForPetStore {

	public static void main(String[] args) {
		Map<Integer,Order>map1=new HashMap<>();
		Map<Integer,Pet>map2=populatePet(addPet());
		
		boolean exit=false;
		String u = null;
		try(Scanner sc=new Scanner(System.in))
		{
			while(!exit)
			{
			System.out.println("Enter your choice:1.Login 2.Add new Pet 3.Update Pet details 4.Display all available pets"
					+ "5.Order a Pet 6.Check order status by Order Id 7.Update order status 0.exit ");
			switch(sc.nextInt())
			{
			case 1://Login
				System.out.println("Enter your email and password");
				u=loginUser(sc.next(),sc.next());
				System.out.println(u+" Login successful");
				break;
			case 2://Add new Pet
				System.out.println("Enter your email and password");
				u=loginUser(sc.next(),sc.next());
				System.out.println(u+" Login successful");
				System.out.println("Enter name, category, unitPrice, stocks");
				addNewPet(u,sc.next(),sc.next(),sc.nextDouble(),sc.nextInt(),map2);
				break;
			case 3://Update Pet details
				System.out.println("Enter your email and password");
				u=loginUser(sc.next(),sc.next());
				System.out.println(u+" Login successful");
				System.out.println("Enter id and stocks details to update");
				updatePetDetails(u,sc.nextInt(),sc.nextInt(),map2);
				break;
			case 4://Display all available pets
				map2.forEach((k,v)->System.out.println(v));
				break;
			case 5://Order a Pet
				System.out.println("Enter your email and password");
				u=loginUser(sc.next(),sc.next());
				System.out.println(u+" Login successful");
				map2.forEach((k,v)->System.out.println(v));
				System.out.println("Enter id and how many pets you want to buy");
				orderPet(sc.nextInt(),sc.nextInt(),map2,map1);
				map1.forEach((k,v)->System.out.println(v));
				break;
			case 6://Check order status by Order Id
				System.out.println("Enter your email and password");
				u=loginUser(sc.next(),sc.next());
				System.out.println(u+" Login successful");
				System.out.println("Enter Order Id");
				checkOrderStatus(sc.nextInt(),map1);
				break;
			case 7://Update order status
				System.out.println("Enter your email and password");
				u=loginUser(sc.next(),sc.next());
				System.out.println(u+" Login successful");
				System.out.println("Enter Order Id and status to be updated");
				updateOrderStatus(u,sc.nextInt(),sc.next(),map1);
				map1.forEach((k,v)->System.out.println(v));
				break;
			case 0:
				exit=true;
				break;
			}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
