package com.app.tester;

import static com.app.utils.CricketersValidations.modifyCricketersRating;
import static com.app.utils.CricketersValidations.searchCricketerByName;
import static com.app.utils.UtilsClass.addCricketer;
import static com.app.utils.UtilsClass.populateCricketer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.app.cricketteam.Cricketer;
public class CricketerTest {

	public static void main(String[] args) {
		Map<String,Cricketer>map=populateCricketer(addCricketer());
		boolean exit=false;
		try(Scanner sc=new Scanner(System.in))
		{
			while(!exit)
			{
				System.out.println("Enter Your Choice: 1.Display Ckicketers 2.Modify Cricketers Rating 3.Search Cricketer By Name 4.Display All Cricketers in sorted form by rating 0.exit");
				switch(sc.nextInt())
				{
				case 1:
					map.forEach((k,v)->System.out.println(v));
					break;
					
				case 2://Modify Cricketers Rating
					System.out.println("Enter Cricketrs EmailID and Rating to be modified");
					String s=modifyCricketersRating(sc.next(),sc.nextInt(),map);
					System.out.println(s);
					break;
					
				case 3://Search Cricketer By Name
					System.out.println("ENter the name of cricketer to search");
					searchCricketerByName(sc.next(),map);
					break;
					
				case 4://Display All Cricketers in sorted form by rating.
					Collection <Cricketer> c=map.values();
					List<Cricketer>lst=new ArrayList<>(c);
					Comparator<Cricketer> cmp = (o1, o2) -> Integer.compare(o1.getRating(), o2.getRating());
					Collections.sort(lst,cmp);
					System.out.println("After Sort:");
					lst.forEach(c1->System.out.println(c1));
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
