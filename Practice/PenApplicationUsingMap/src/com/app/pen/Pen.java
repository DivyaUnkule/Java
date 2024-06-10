package com.app.pen;

import java.time.LocalDate;

public class Pen implements Comparable<Pen>{
	private int id;
	private Brand brand;
	private String colour;
	private String inkColour;
	private String material;
	private int stock;
	private LocalDate stockUpdateDate;
	private LocalDate stockListingDate;
	private double price;
	private double discount;
	private static int idGenerator;
	public Pen() {
		// TODO Auto-generated constructor stub
	}
	
	public Pen(int id, Brand brand, String colour, String inkColour, String material, int stock,
			LocalDate stockUpdateDate, LocalDate stockListingDate, double price, double discount) {
		super();
		this.id = id;
		this.brand = brand;
		this.colour = colour;
		this.inkColour = inkColour;
		this.material = material;
		this.stock = stock;
		this.stockUpdateDate = stockUpdateDate;
		this.stockListingDate = stockListingDate;
		this.price = price;
		this.discount = discount;
	}
	public Pen( Brand brand, String colour, String inkColour, String material, int stock,
			 LocalDate stockListingDate, double price, double discount) {
		super();
		this.id = idGenerator++;
		this.brand=brand;
		this.colour = colour;
		this.inkColour = inkColour;
		this.material = material;
		this.stock = stock;
		this.stockUpdateDate = LocalDate.now();
		this.stockListingDate = stockListingDate;
		this.price = price;
		this.discount = discount;
	}
	
	public Pen(int id,Brand brand, String colour, String inkColour, String material, 
			 LocalDate stockListingDate, double price, double discount,int stock) {
		super();
		this.id = id;
		this.brand = brand;
		this.colour = colour;
		this.inkColour = inkColour;
		this.material = material;
		this.stockUpdateDate = LocalDate.now();
		this.stockListingDate =stockListingDate;
		this.price = price;
		this.discount = discount;
		this.stock=stock;
	}

	public Pen(int i) {
		this.id=i;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		Brand b=Brand.valueOf(brand);
		this.brand = b;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getInkColour() {
		return inkColour;
	}
	public void setInkColour(String inkColour) {
		this.inkColour = inkColour;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public LocalDate getStockUpdateDate() {
		return stockUpdateDate;
	}
	public void setStockUpdateDate(LocalDate stockUpdateDate) {
		this.stockUpdateDate = stockUpdateDate;
	}
	public LocalDate getStockListingDate() {
		return stockListingDate;
	}
	public void setStockListingDate(LocalDate stockListingDate) {
		this.stockListingDate = stockListingDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Pen [id=" + id + ", brand=" + brand + ", colour=" + colour + ", inkColour=" + inkColour + ", material="
				+ material + ", stock=" + stock + ", stockUpdateDate=" + stockUpdateDate + ", stockListingDate="
				+ stockListingDate + ", price=" + price + ", discount=" + discount + "]";
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Pen)
		{
			Pen p=(Pen)o;
			return (this.id==p.id);
		}
		return false;
	}
	
	
	@Override
	public int compareTo(Pen o) {
		if(this.id < o.id)
		{
           return -1;
	    }
		if(this.id == o.id)
		{
			return 0;
		}
		return 1;
	}

}
