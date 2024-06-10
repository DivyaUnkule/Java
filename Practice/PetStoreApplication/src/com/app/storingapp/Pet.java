package com.app.storingapp;

public class Pet {
	private int petId;
	private String name;
	private Category category;
	private double unitPrice;
	private int stocks;
	private static int idGenerator;
	
	public Pet() {
		// TODO Auto-generated constructor stub
	}

	public Pet(int petId, String name, Category category, double unitPrice, int stocks) {
		super();
		this.petId = petId;
		this.name = name;
		this.category = category;
		this.unitPrice = unitPrice;
		this.stocks = stocks;
		idGenerator=Math.max(idGenerator, petId);
	}
	public Pet(String name, Category category, double unitPrice, int stocks) {
		super();
		this.petId = idGenerator++;
		this.name = name;
		this.category = category;
		this.unitPrice = unitPrice;
		this.stocks = stocks;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getStocks() {
		return stocks;
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
	}

	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", name=" + name + ", category=" + category + ", unitPrice=" + unitPrice
				+ ", stocks=" + stocks + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Pet)
		{
			Pet p=(Pet)obj;
			return this.petId==p.petId;
		}
		return false;
	}
	

}
