package com.app.employeemanagement;

import java.time.LocalDate;

public class Employee {
	private int empId;
	private String name;
	private LocalDate doj;
	private  String phNo;
	private String adharNo;
	private static int IdGenerator;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String name, LocalDate doj, String phNo, String adharNo) {
		this.empId = empId;
		this.name = name;
		this.doj = doj;
		this.phNo = phNo;
		this.adharNo = adharNo;
		IdGenerator=Math.max(empId+1, IdGenerator);
	}
	
	public Employee(String name, LocalDate doj, String phNo, String adharNo) {
		this.empId = IdGenerator++;
		this.name = name;
		this.doj = doj;
		this.phNo = phNo;
		this.adharNo = adharNo;
		
	}
	
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", doj=" + doj + ", phNo=" + phNo + ", adharNo="
				+ adharNo + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof FullTimeEmployee)
		{
			Employee e=(Employee)obj;
			return this.empId==e.empId;
		}
		return false;
	}
	
	
	
	
	

}
