package com.app.tester;

import static com.app.utils.EmployeeValidations.addFullTimeEmployee;
import static com.app.utils.EmployeeValidations.addPartTimeEmployee;
import static com.app.utils.EmployeeValidations.deleteEmployee;
import static com.app.utils.EmployeeValidations.searchEmployeeDetails;
import static com.app.utils.UtilsClass.addFTE;
import static com.app.utils.UtilsClass.addPTE;
import static com.app.utils.UtilsClass.populateFTE;
import static com.app.utils.UtilsClass.populatePTE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.app.employeemanagement.FullTimeEmployee;
import com.app.employeemanagement.PartTimeEmployee;

public class EmployeeTester {
	public static void main(String[] args) {
		Map<Integer,FullTimeEmployee> map1=populateFTE(addFTE());
		Map<Integer,PartTimeEmployee> map2=populatePTE(addPTE());
		
		boolean exit=false;
		
		try(Scanner sc=new Scanner(System.in)) {
			while(!exit)
			{
				System.out.println("Enter your choice: 1.Add full time employee\r\n"
						+ "2.Delete an employee by Emp Id\r\n"
						+ "3.Search employee details by Aadhaar number\r\n"
						+ "4.Display all employee details\r\n"
						+ "5.Display all employee details sorted by date of joining 6.Add part time employee\r\n"
						+ "0.Exit");
				switch(sc.nextInt())
				{
				case 1://Add full time employeeAdd part time employee
					System.out.println("Enter name,doj, phNo,adharNo,sal");
					addFullTimeEmployee(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),map1);
					break;
				case 2://Delete an employee by Emp Id
					System.out.println("FullTime Employee List");
					map1.forEach((k,v)->System.out.println(v));
					System.out.println("PartTime Employee List");
					map2.forEach((k,v)->System.out.println(v));
					System.out.println("ENter EmpID to be deleted");
					deleteEmployee(sc.nextInt(),map1,map2);
					break;
				case 3://Search employee details by Aadhaar number
					System.out.println("Enter AdharNumber");
					searchEmployeeDetails(sc.next(),map1,map2);
					break;
				case 4://Display all employee details
					System.out.println("FullTime Employee List");
					map1.forEach((k,v)->System.out.println(v));
					System.out.println("PartTime Employee List");
					map2.forEach((k,v)->System.out.println(v));
					break;
				case 5://Display all employee details sorted by date of joining
					Collection<FullTimeEmployee> c=map1.values();
					List<FullTimeEmployee>lst=new ArrayList<>(c);
					Comparator<FullTimeEmployee>cmp=(o1,o2)->(o1.getDoj().compareTo(o2.getDoj()));
					Collections.sort(lst,cmp);
					lst.forEach(p-> System.out.println(p));
					break;
				case 6://Add part time employee
					System.out.println("Enter name,doj, phNo,adharNo,HourlyRate");
					addPartTimeEmployee(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),map2);
					break;
				case 0://Exit
					exit=true;
					break;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
