package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.core.Customer;
import com.app.core.ServicePlans;

public class CustomerUtils {
	
	public static List<Customer> populateList()
	{
		List<Customer> lst=new ArrayList<>(
				Arrays.asList(new Customer("Divya","Unkule","d@123","q@we",LocalDate.parse("2000-06-14"),ServicePlans.SILVER,1000.00),
						new Customer("Aishwarya","Unkule","a@123","z@xc",LocalDate.parse("1996-02-13"),ServicePlans.GOLD,2000.00),
						new Customer("Dipak","Unkule","di@123","a@sd",LocalDate.parse("1966-09-14"),ServicePlans.DIAMOND,5000.00),
						new Customer("Chhaya","Unkule","c@123","c@vb",LocalDate.parse("1968-08-22"),ServicePlans.PLATINUM,10000.00),
						new Customer("Swayam","Rahane","s@123","s@df",LocalDate.parse("2001-12-31"),ServicePlans.SILVER,1000.00),
						new Customer("Rahi","Raut","r@123","r@ty",LocalDate.parse("2002-06-14"),ServicePlans.GOLD,2000.00),
						new Customer("Aaroh","Dixit","aa@123","d@fg",LocalDate.parse("2000-06-14"),ServicePlans.DIAMOND,5000.00),
						new Customer("Rama","Bakshi","ra@123","b@nm",LocalDate.parse("2000-07-16"),ServicePlans.PLATINUM,10000.00),
						new Customer("Ronny","Batliwala","ro@123","r@bn",LocalDate.parse("2002-08-08"),ServicePlans.SILVER,1000.00),
						new Customer("Shravani","Ambavale","sh@123","j@kl",LocalDate.parse("2004-10-05"),ServicePlans.GOLD,2000.00)));
				
				return lst;
	}
	public static Map<String,Customer> populateMap(List<Customer>lst)
	{
	
		Map<String, Customer> hsm= new HashMap<>();
		
		lst.forEach(s-> hsm.put(s.getEmail(), s));
		
		return hsm;
	}
}



    
