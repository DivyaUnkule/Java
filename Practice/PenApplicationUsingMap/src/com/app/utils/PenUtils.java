package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.pen.Brand;
import com.app.pen.Pen;

public class PenUtils {
	
	public static List<Pen> addPens()
	{
		List<Pen>lst=new ArrayList<>(
		
		Arrays.asList(new Pen(10, Brand.CELLO, "SkyBlue", "Blue", "Plastic",10,
				LocalDate.parse("2023-07-01"), LocalDate.parse("2023-06-06"),10.00,2),
		new Pen(1, Brand.CELLO, "SkyBlue", "Black", "Plastic",5,
					LocalDate.parse("2023-07-01"), LocalDate.parse("2023-06-06"),10.00,2),
		new Pen(2,Brand.PARKER, "Black", "Blue", "Metal",15,
					LocalDate.parse("2024-05-03"), LocalDate.parse("2024-02-03"),20.00,1),
		new Pen(3,Brand.PARKER, "SkyBlue", "Black", "Metal",15,
					LocalDate.parse("2024-05-03"), LocalDate.parse("2024-02-03"),20.00,1),

		new Pen(4,Brand.REYNOLDS, "Blue", "Blue", "Plastic",25,
					LocalDate.parse("2024-04-03"), LocalDate.parse("2023-12-03"),10.00,0),
		new Pen(5,Brand.REYNOLDS, "Black", "Black", "Plastic",25,
					LocalDate.parse("2024-04-03"), LocalDate.parse("2023-12-03"),10.00,0),
		new Pen(6,Brand.TRIMAX, "NavyBlue", "Blue", "Plastic",20,
					LocalDate.parse("2024-03-03"), LocalDate.parse("2024-03-03"),25.00,3),
		new Pen(7,Brand.TRIMAX, "Black", "Black", "Plastic",20,
					LocalDate.parse("2024-03-03"), LocalDate.parse("2024-03-03"),25.00,3),
		new Pen(8,Brand.BALLPOINT, "White", "Blue", "Plastic",50,
					LocalDate.parse("2024-02-03"), LocalDate.parse("2024-11-03"),5.00,0),
		new Pen(9,Brand.BALLPOINT, "White", "Black", "Plastic",50,
					LocalDate.parse("2024-02-03"), LocalDate.parse("2024-11-03"),5.00,0)));
		
		return lst;
		
		
	}
	public static Map<Integer,Pen> populatePens(List<Pen>lst)
	{
		Map<Integer,Pen> map=new HashMap<>();
	   lst.forEach(p->map.put(p.getId(), p));
	   return map;
	}

}
