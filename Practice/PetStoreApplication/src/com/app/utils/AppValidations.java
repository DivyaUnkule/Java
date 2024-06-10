package com.app.utils;

import java.util.Map;

import javax.security.sasl.AuthenticationException;

import com.app.exceptions.AuthorizationException;
import com.app.exceptions.OutOfStockException;
import com.app.exceptions.PetException;
import com.app.storingapp.Category;
import com.app.storingapp.Order;
import com.app.storingapp.Pet;
import com.app.storingapp.Status;

public class AppValidations {
	public static String loginUser(String email,String pass) throws AuthenticationException
	{
		if(email.equals("admin"))
		{
			if(pass.equals("admin"))
			{
				return "Admin";
			}
			throw new AuthenticationException("Invalid Password");
		}
		else if(email.equals("c1"))
		{
			if(pass.equals("c1"))
			{
				return "Customer";
			}
			throw new AuthenticationException("Invalid Password");
		}
		throw new AuthenticationException("Invalid EmailId");
	}
	public static void addNewPet(String u,String name,String category,double unitPrice,int stocks,Map<Integer,Pet>map)throws AuthorizationException, PetException
	{
		if(u.equals("Admin"))
		{
		validateName(name,map);
		Category c=parseAndValidateCategory(category);
		Pet p=new Pet(name,c,unitPrice,stocks);
		int i=p.getPetId();
		map.put(i, p);
		System.out.println("New Pet Added Successfully");
		}
		else
		{
			throw new AuthorizationException("Customer is not allowed to add pet");
		}
	}
	public static void validateName(String name,Map<Integer,Pet>map) throws PetException
	{
		boolean b=map.values().stream().anyMatch(p-> p.getName().equalsIgnoreCase(name));
		if(b)
		{
			throw new PetException("Pet with similar name already exist no need to add newly the pet ,updation of details is sufficient");
		}
	}
	public static Category parseAndValidateCategory(String category) throws PetException
	{
		Category c=Category.valueOf(category.toUpperCase());
		if(c==null)
		{
			throw new PetException("Category does not exist");
		}
		return c;
	}
	
	public static void updatePetDetails(String u,int id,int stocks,Map<Integer,Pet>map) throws AuthorizationException, PetException
	{
		if(u.equals("Admin"))
		{
		validateId(id,map);
		Pet p=map.get(id);
		int i=p.getStocks()+stocks;
		p.setStocks(i);
		System.out.println("Pet Stock updated successfully");
		}
		else
		{
			throw new AuthorizationException("Customer is not allowed to update pet details");
		}
	}
	
	public static void validateId(int id,Map<Integer,Pet>map) throws PetException
	{
		if(!(map.containsKey(id)))
		{
			throw new PetException("Pet ID does not exist");
		}
	}
	public static void orderPet(int id,int num,Map<Integer,Pet>map2,Map<Integer,Order>map1) throws PetException, OutOfStockException
	{
		validateId(id,map2);
		Pet p=map2.get(id);
		if(p.getStocks()<num)
		{
			throw new OutOfStockException("Number of oredered pet is more than available pets");
		}
		int t=p.getStocks()-num;
		p.setStocks(t);
		Order o=new Order(id,num);
		int i=o.getOrderId();
		map1.put(i,o);
		System.out.println("Order placed successfully");
	}
	public static void checkOrderStatus(int id,Map<Integer,Order>map1) throws PetException
	{
		validateOrderId(id,map1);
		Order o=map1.get(id);
		System.out.println("Your Order Status: "+o.getStatus());
	}
	public static void validateOrderId(int id,Map<Integer,Order>map) throws PetException
	{
		if(!(map.containsKey(id)))
		{
			throw new PetException("Order ID does not exist");
		}
	}
	public static void updateOrderStatus(String u,int id ,String status,Map<Integer,Order>map1) throws PetException, AuthorizationException
	{
		if(u.equals("Admin"))
		{
		validateOrderId(id,map1);
		Status s=parseAndValidateStatus(status);
		Order o=map1.get(id);
		o.setStatus(s);
		System.out.println("Order Status updated successfully");
		}
		else
		{
			throw new AuthorizationException("Customer is not allowed to update order details");
		}
	}
	public static Status parseAndValidateStatus(String status) throws PetException
	{
		Status c=Status.valueOf(status.toUpperCase());
		if(c==null)
		{
			throw new PetException("Status does not exist");
		}
		return c;
	}

}
