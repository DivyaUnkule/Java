package com.app.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import com.app.custom_exceptions.PenExceptions;
import com.app.pen.Brand;
import com.app.pen.Pen;

public class PenValidations {

	public static String addPenInExistingStock(int id,String brand, String colour, String inkColour, String material, 
			String stockListingDate, double price, double discount,Map<Integer,Pen>map) throws PenExceptions
	{
		System.out.println("Inside method");
	     int i=validateId(id,map);
		LocalDate d=validateAndparseDate(i,stockListingDate,map);
		Brand b=parseAndValidateBrand(brand);
		validatePenColour(i,colour,map);
		validateInkColour(i,inkColour,map);
		validatePenMaterial(i,material,map);
		validatePenPrice(i,price,map);
		int stock=updateStock(i,map);
		Pen p1=new Pen(id,b, colour,inkColour, material,d, price, discount,stock);
		map.put(id,p1);
		return "Pen Addded Successfully";
		
	}
	public static int validateId(int id,Map<Integer,Pen>map) throws PenExceptions
	{
		
		if(!(map.containsKey(id)))
		{
			throw new PenExceptions("Provided pen id is wrong");
		}
		return id;
	}
	public static LocalDate validateAndparseDate(int i,String stockListingDate,Map<Integer,Pen>map) throws PenExceptions
	{
		LocalDate d=LocalDate.parse(stockListingDate);
		Pen p=map.get(i);
		
		if(p!=null)
		{
		if(d.equals(p.getStockListingDate()))
		{
			return d;
		}
		}
		throw new PenExceptions("Provided stocklisting date is invalid");
	}
	public static Brand parseAndValidateBrand(String brand) throws PenExceptions
	{
	 Brand b=Brand.valueOf(brand.toUpperCase());
	 if(b==null)
	 {
		 throw new PenExceptions("Provided Brand of Pen is invalid");
	 }
	 return b;
	}
	public static void validatePenColour(int i,String colour,Map<Integer,Pen>map) throws PenExceptions
	{
Pen p=map.get(i);
		
		if(p!=null)
		{
	if(!(colour.equals(p.getColour())))
	{
		throw new PenExceptions("Provided colour of pen doesnot exist");
	}
		}		
	}
	public static void validateInkColour(int i,String colour,Map<Integer,Pen>map) throws PenExceptions
	{
Pen p=map.get(i);
		
		if(p!=null)
		{
			if(!(colour.equals(p.getInkColour())))
			{
				throw new PenExceptions("Provided inkcolour of pen doesnot exist");
		    }
		}
	}
	public static void validatePenMaterial(int i,String material,Map<Integer,Pen>map) throws PenExceptions
	{
Pen p=map.get(i);
		
		if(p!=null)
		{
			if(!(material.equals(p.getMaterial())))
			{
			
			throw new PenExceptions("Provided Pen with material doesnot exist");
		   }
		}
	}
	public static void validatePenPrice(int i,double price,Map<Integer,Pen>map) throws PenExceptions
	{
Pen p=map.get(i);
		
		if(p!=null)
		{
			if(!(price==p.getPrice()))
			{
			
			   throw new PenExceptions("Invalid Pen Price");
		   }
		}
	}
	 public static void validatePenDiscount(int i,double discount,Map<Integer,Pen>map) throws PenExceptions
	 {
		 Pen p=map.get(i);
			
			if(p!=null)
			{
		 if(discount == p.getDiscount())
		 {
			 throw new PenExceptions("Invalid Pen Discount");
		 }
			}
	 }
	 public static int  updateStock(int id,Map<Integer,Pen>map)
	 {
		 Pen p=map.get(id);
		 int s=(p.getStock())+1;
		 p.setStock(s);
		 return p.getStock();
		 
	 }
	 public static String addNewPen(String brand, String colour, String inkColour, String material, int stock,
				 String stockListingDate, double price, double discount,Map<Integer,Pen>map) throws PenExceptions
	 {
		 Brand b=parseAndValidateBrand(brand);
		 LocalDate d=LocalDate.parse(stockListingDate);
		 Pen p1=new Pen(b, colour,inkColour, material,stock,d,price,discount);
		 int id=p1.getId();
		 map.put(id, p1);
		 return "Pen Addded Successfully";
    }
	 public static String updateStockOfPen(int id,int stock,Map<Integer,Pen>map) throws PenExceptions
	 {
		 validateId(id,map);
		 Pen p=map.get(id);
		 int s=p.getStock()+stock;
		 p.setStock(s);
		 return "Stock Updated Successfully";
	 }
	public static String setDiscountBy20Percent(Map<Integer,Pen>map)
	{
		Collection<Pen>c=map.values();
		for(Pen p:c)
		{
			int m =Period.between(p.getStockUpdateDate(), LocalDate.now()).getMonths();
			if(m>3)
			{
				p.setDiscount(20);
				System.out.println("ID: "+p.getId()+" Brand:"+p.getBrand()+" Discount Set:"+p.getDiscount()+" Old Price:"+p.getPrice());
				System.out.println("New Price will be after setting the 20% discount:"+((p.getPrice())-(p.getPrice()*(p.getDiscount()/100))));
			}
		}
		return "Discount set successfully";
	}
	public static void removePens(Map<Integer,Pen>map)
	{
		int count=0;
		Collection<Pen>c1=map.values();
		Iterator<Pen> itr=c1.iterator();
		while(itr.hasNext())
		{
			Pen p=itr.next();
			int m1=Period.between(p.getStockUpdateDate(), LocalDate.now()).getMonths();
			if(m1>9)
			{
				count++;
				System.out.println("ID: "+p.getId()+"Brand: "+p.getBrand());
				itr.remove();
				System.out.println("Removed successfully");
			}
		}
		if(count==0)
		{
			System.out.println("No Any Pen can be remove as all Pens are getting sold inbetween 9 months");
		}
		
		
	}
}
