package com.app.tester;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.app.pen.Brand;
import com.app.pen.Pen;
import static com.app.utils.PenUtils.*;
import static com.app.utils.PenValidations.*;

public class PenApplication {

	public static void main(String[] args) {
		Map<Integer,Pen>map=populatePens(addPens());
		boolean exit = false;
		
		try(Scanner sc=new Scanner(System.in))
		{
			while(!exit)
			{
				System.out.println("Enter your choice: 1.Display Pens 2.Add Pen in existing stock 3.Add Pen which doesn't exist in existing stock 4.Update Stock Of a Pen "
						+ "5.Set discount of 20% for all the pens which are not at all sold in last 3 months 6.Remove Pens which arenever sold once listed in 9 months 0.Exit");
				switch(sc.nextInt())
				{
				case 1://display Pens
					map.forEach((k,v)-> System.out.println("k"+v));
					break;
					
				case 2://if want to add in Existing brands
					map.forEach((k,v)-> System.out.println(v));
					System.out.println("If you want to add in exisitng stock enter id,brand,colour, inkColour, material, \r\n"
							+ "stockListingDate, price,discount");
					String s=addPenInExistingStock(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.next(), 
							 sc.next(),sc.nextDouble(),sc.nextDouble(),map);
					System.out.println(s);
					
					break;
					
				case 3://if we want to add new Pen
					System.out.println("If you want to add new pen enter brand, colour, inkColour, material,stock,\r\n"
							+ "stockListingDate,price,discount");
					String s1=addNewPen(sc.next(), sc.next(), sc.next(),sc.next(), sc.nextInt(),
							sc.next(), sc.nextDouble(), sc.nextDouble(),map);
					System.out.println(s1);
					break;
					
				case 4://Update Stock Of a Pen
					System.out.println("Enter Pen ID and how much stock do you want to add");
					String s3=updateStockOfPen(sc.nextInt(),sc.nextInt(),map);
					System.out.println(s3);
					break;
					
				case 5://Set discount of 20% for all the pens which are not at all sold in last 3 months
					String s4=setDiscountBy20Percent(map);
					System.out.println(s4);
					break;
					
				case 6://Remove Pens which arenever sold once listed in 9 months
					removePens(map);
					
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
