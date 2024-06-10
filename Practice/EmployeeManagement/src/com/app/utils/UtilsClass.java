package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.employeemanagement.FullTimeEmployee;
import com.app.employeemanagement.PartTimeEmployee;

public class UtilsClass {
	
	public static List<FullTimeEmployee> addFTE()
	{
		List<FullTimeEmployee> lst=new ArrayList<>(Arrays.asList(new FullTimeEmployee("Ram", LocalDate.parse("2020-01-01"), "1234567890", "123456789012", 50000),
				new FullTimeEmployee("Raghav", LocalDate.parse("2019-02-01"), "2345678901", "123456789023", 45000),
				new FullTimeEmployee("Shiv", LocalDate.parse("2018-06-14"), "3456789012", "123456789034", 60000),
				new FullTimeEmployee("Radha", LocalDate.parse("2019-02-01"), "4567890123", "123456789045", 45000),
				new FullTimeEmployee("Meera", LocalDate.parse("2017-01-01"), "5678901234", "123456789056", 80000)));
		return lst;
	}
	
	public static Map<Integer,FullTimeEmployee> populateFTE(List<FullTimeEmployee>lst)
	{
		Map<Integer,FullTimeEmployee>map=new HashMap<>();
		lst.forEach(p-> map.put(p.getEmpId(),p));
		return map;
	}
	
	public static List<PartTimeEmployee> addPTE()
	{
		List<PartTimeEmployee> lst=new ArrayList<>(Arrays.asList(new PartTimeEmployee("Pooja", LocalDate.parse("2023-01-01"), "6789012345", "123456789067", 3000),
				new PartTimeEmployee("Amrapali", LocalDate.parse("2020-02-01"), "7890123456", "123456789078", 6000),
				new PartTimeEmployee("Amar", LocalDate.parse("2018-06-14"), "8901234567", "123456789089", 5000),
				new PartTimeEmployee("Ashutosh", LocalDate.parse("2019-03-01"), "9012345678", "123456789090", 4500),
				new PartTimeEmployee("Mrunal", LocalDate.parse("2019-04-02"), "9012335678", "123456789001", 4500)));
		return lst;
	}
	
	public static Map<Integer,PartTimeEmployee> populatePTE(List<PartTimeEmployee>lst)
	{
		Map<Integer,PartTimeEmployee>map=new HashMap<>();
		lst.forEach(p-> map.put(p.getEmpId(),p));
		return map;
	}

}
