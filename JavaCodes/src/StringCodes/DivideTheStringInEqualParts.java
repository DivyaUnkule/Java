package StringCodes;
import java.util.Scanner;
public class DivideTheStringInEqualParts {

	public static void main(String[] args) {
		
       Scanner sc=new Scanner(System.in);
       
       System.out.println("Enter the string");
       String str=sc.next();
       
       System.out.println("Enter the number in which you want to divide the string in equal parts");
       int n=sc.nextInt();
       
       if(str.length()%n!=0)
       {
    	   System.out.println("String can't be divide in equal parts");
       }
       
       else
       {
    	   int num=str.length()/n;
    	   int num1=num;
    	   char[] str1=str.toCharArray();
    	   int i=0;
    	   while(i!=str1.length) {
    		   for(int i1=0;i1<num1;i1++)
        	   {
        		  System.out.print(str1[i]);
        		  i++;
        		  
        	   }
    		   System.out.println();
    		   num1=num;
    		   
    	   }
    	   
    	  
       }
       
       
	}

}
