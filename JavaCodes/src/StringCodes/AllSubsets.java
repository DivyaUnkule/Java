package StringCodes;
import java.util.Scanner;
public class AllSubsets {

	public static void main(String[] args) {
		
        Scanner sc=new Scanner(System.in);
        
        
        System.out.println("Enter the string");
        String str1=sc.next();
        
       
        
        
        int num=0;
        int n=0;
        int n1=str1.length();
        while(n!=n1)
        {
        	 for(int i=0;i<str1.length();i++)
             {
             	num=i+1;
             	String s=str1.substring(i,num);
             	System.out.println(s);
             }
        	 n++;
        }
        
       
        
       
        
	}

}
