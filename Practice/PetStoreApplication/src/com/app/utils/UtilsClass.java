package com.app.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.storingapp.Category;
import com.app.storingapp.Pet;

public class UtilsClass {
	public static List<Pet> addPet()
	{
		List<Pet>lst=new ArrayList<>(Arrays.asList(new Pet(1,"BullDog",Category.valueOf("DOG"),1000,50),
				new Pet(2,"Beagle",Category.valueOf("DOG"),2000,30),
				new Pet(3,"Persian",Category.valueOf("CAT"),1500,100),
				new Pet(4,"BengalCat",Category.valueOf("CAT"),1200,70),
				new Pet(5,"GoldFish",Category.valueOf("FISH"),500,120),
				new Pet(6,"Oscar",Category.valueOf("FISH"),700,130),
				new Pet(7,"Himalayan Rabbit",Category.valueOf("RABBIT"),3500,30),
				new Pet(8,"Dutch Rabbit",Category.valueOf("RABBIT"),3000,20)
));
		return lst;
	}
    public static Map<Integer,Pet> populatePet(List<Pet>lst)
    {
    	Map<Integer,Pet>map=new HashMap<>();
    	lst.forEach(p->map.put(p.getPetId(),p));
    	return map;
    }
}
