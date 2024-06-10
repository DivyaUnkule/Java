package com.app.employeemanagement;

import java.time.LocalDate;

public class PartTimeEmployee extends Employee{
	private double hrPay;
	
	public PartTimeEmployee() {
		// TODO Auto-generated constructor stub
	}

	public PartTimeEmployee(String name, LocalDate doj, String phNo, String adharNo, double hrPay) {
		super(name,doj,phNo,adharNo);
		this.hrPay = hrPay;
	}
	
	public double getHrPay() {
		return hrPay;
	}

	public void setHrPay(double hrPay) {
		this.hrPay = hrPay;
	}

	@Override
	public String toString() {
		return "PartTimeEmployee [empId=" + getEmpId() + ", name=" + getName() + ", doj=" + getDoj() + ", phNo=" + getPhNo() + ", adharNo="
				+ getAdharNo() + ", hrPay=" + hrPay + "]";
	}


	
	
	

}
