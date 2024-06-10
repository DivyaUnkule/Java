package com.app.employeemanagement;

import java.time.LocalDate;

public class FullTimeEmployee extends Employee {
	private double sal;
	
	
	public FullTimeEmployee() {
		// TODO Auto-generated constructor stub
	}
    
	public FullTimeEmployee(String name, LocalDate doj, String phNo, String adharNo, double sal) {
		super(name,doj,phNo,adharNo);
	    this.sal = sal;
		
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "FullTimeEmployee [empId=" + getEmpId() + ", name=" + getName() + ", doj=" + getDoj() + ", phNo=" + getPhNo() + ", adharNo="
				+ getAdharNo() + ", sal=" + sal + "]";
	}

	
	
	

}
