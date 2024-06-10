package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.app.employeemanagement.FullTimeEmployee;
import com.app.employeemanagement.PartTimeEmployee;
import com.app.exception.EmployeeException;

public class EmployeeValidations {
	public static void addFullTimeEmployee(String name,String doj,String phNo,String adharNo,double sal,Map<Integer,FullTimeEmployee>map) throws EmployeeException
	{
		validatePhNo(phNo);
		validateAdharNo(adharNo);
		LocalDate d=parseDoj(doj);
		FullTimeEmployee fte=new FullTimeEmployee(name,d,phNo,adharNo,sal);
		int i=fte.getEmpId();
		map.put(i, fte);
		System.out.println("FullTime Employee Added Successfully");
	}
    public static void validatePhNo(String phNo) throws EmployeeException
    {
    	String r= "^[0-9]{10}$";
        if(!(phNo.matches(r)))
        {
        	throw new EmployeeException("invalid Mobile Number");
        }
    }
    public static void validateAdharNo(String adharNo) throws EmployeeException
    {
    	String r="^[0-9]{12}$";
    	if(!(adharNo.matches(r)))
        {
        	throw new EmployeeException("invalid Adhar Number");
        }
    	
    }
    public static LocalDate parseDoj(String doj)
    {
    	return LocalDate.parse(doj);
    }
    public static void addPartTimeEmployee(String name,String doj,String phNo,String adharNo,double hourlyRate,Map<Integer,PartTimeEmployee>map) throws EmployeeException
	{
		validatePhNo(phNo);
		validateAdharNo(adharNo);
		LocalDate d=parseDoj(doj);
		PartTimeEmployee pte=new PartTimeEmployee(name,d,phNo,adharNo,hourlyRate);
		int i=pte.getEmpId();
		map.put(i, pte);
		System.out.println("PartTime Employee Added Successfully");
	}
    public static void deleteEmployee(int id,Map<Integer,FullTimeEmployee>map1,Map<Integer,PartTimeEmployee>map2) throws EmployeeException
    {
    	validateId(id,map1,map2);
    	if(map1.containsKey(id))
    	{
    		map1.remove(id);
    		System.out.println("FullTime Employee get deleted successfully");
    
    	}
    	else if(map2.containsKey(id))
    	{
    		map2.remove(id);
    		System.out.println("PartTime Employee get deleted successfully");
    		
    	}
    	
    }
    public static void validateId(int id,Map<Integer,FullTimeEmployee>map1,Map<Integer,PartTimeEmployee>map2) throws EmployeeException
    {
    	if(!(map1.containsKey(id)))
    	{
    		if(!(map2.containsKey(id)))
    		{
    		throw new EmployeeException("Employee ID Does Not Exist");
    		}
    	}
    	
    }
    public static void searchEmployeeDetails(String adharNo,Map<Integer,FullTimeEmployee>map1,Map<Integer,PartTimeEmployee>map2) throws EmployeeException
    {
    	validateAdharNo(adharNo);
    	Stream<FullTimeEmployee>s=
    			(map1.values()).stream().filter(p-> (p.getAdharNo()).equals(adharNo));
    	
    	if(s.findAny().isPresent())
    	{
    		(map1.values()).stream()
    		.filter(p-> (p.getAdharNo()).equals(adharNo))
    		.forEach(p->System.out.println(p));
    		
    	}
    	else
    	{
    	(map2.values()).stream().filter(p-> (p.getAdharNo()).equals(adharNo)).forEach(p->System.out.println(p));
    	}
    }
   
}
