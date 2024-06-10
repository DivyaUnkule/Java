package com.app.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.cricketteam.Cricketer;

public class UtilsClass {
	
	public static List<Cricketer> addCricketer()
	{
		List<Cricketer>lst=new ArrayList<>(
				Arrays.asList(new Cricketer("Raghav",35,"raghav@gmail.com","1234567890",937),
						new Cricketer("Shiv",39,"shiv@gmail.com","1122334455",950),
						new Cricketer("Govinda",33,"govinda@gmail.com","6677889900",960),
						new Cricketer("Ram",28,"ram@gmail.com","1133557799",920),
						new Cricketer("Raj",26,"raj@gmail.com","2244668800",910))
				);
		return lst;
				
	}
	public static Map<String,Cricketer> populateCricketer(List<Cricketer>lst)
	{
		Map<String,Cricketer>map=new HashMap<>();
		lst.forEach(p->map.put(p.getEmail_id(),p));
		return map;
	}

}
