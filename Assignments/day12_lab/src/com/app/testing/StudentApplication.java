package com.app.testing;

import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;
import com.app.core.Subject;

import runnable_tasks.DetailsByDobSorter;
import runnable_tasks.DetailsSortByperticularSubjectAndGrade;

import static utils.StudentCollectionUtils.*;

public class StudentApplication {

	public static void main(String[] args) throws InterruptedException {
		try(Scanner sc = new Scanner(System.in))
		{
			
			Map<String,Student>m= populateMap(populateList());
			
			
					System.out.println("Enter filename to write sort by Dob");
					String fName1=sc.next();
					
					System.out.println("Enter filename to write sort by particular subject and grade");
					String fName2=sc.next();
					System.out.println("Enter Subject Name");
					String sub=sc.next();
					Subject s=Subject.valueOf(sub.toUpperCase());
					
					Thread t1=new Thread(new DetailsByDobSorter(m,fName1),"sortDob");
					Thread t2=new Thread(new DetailsSortByperticularSubjectAndGrade(m,s,fName2),"sortGrade");
					t1.start();
					t2.start();
					System.out.println("main waiting for child thrds to complete exec");
					t1.join();
					t2.join();
			
		}
		System.out.println("main over...");


	}
}
