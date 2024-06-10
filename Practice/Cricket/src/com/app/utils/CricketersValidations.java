package com.app.utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.app.cricketexception.CricketException;
import com.app.cricketteam.Cricketer;

public class CricketersValidations {
	public static String modifyCricketersRating(String email,int rating,Map<String,Cricketer>map) throws CricketException
	{
		validateEmail(email,map);
		Cricketer c=map.get(email);
		c.setRating(rating);
		return "Rating updated successfully";
		
	}
	public static void validateEmail(String email,Map<String,Cricketer>map) throws CricketException
	{
		if(!(map.containsKey(email)))
		{
			throw new CricketException("Email ID doesnot exist");
		}
	}
	public static void searchCricketerByName(String name,Map<String,Cricketer>map) throws CricketException
	{
		List<Cricketer>c=map.values().stream()
		.filter(p->p.getName().equalsIgnoreCase(name))
		.collect(Collectors.toList());
		
		if(c.isEmpty())
		{
			throw new CricketException("Cricketer with such given name doesnot exist");
		}
		else
		{
			c.forEach(p->System.out.println(p));
		}

	}

}
