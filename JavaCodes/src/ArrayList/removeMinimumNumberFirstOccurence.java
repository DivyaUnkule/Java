package ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class removeMinimumNumberFirstOccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		ArrayList<Integer>arr=new ArrayList<>();
		
		for(int i=0;i<5;i++)
		{
			System.out.println("Enter the number");
			arr.add(sc.nextInt());
		}
		
		
	/*Integer min1=Collections.min(arr);
	System.out.println(min1);
	arr.remove(min1);
	System.out.println(arr);*/
	
	
    Integer min=arr.stream().reduce((a,b)->(a<b)?a:b).orElse(null);
    
    if(min!=null)
    {
    	arr.remove(min);
    }
    
    System.out.println(arr);	

	}

}
