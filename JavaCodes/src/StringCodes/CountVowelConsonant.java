package StringCodes;

import java.util.Scanner;

public class CountVowelConsonant {

	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
		
        System.out.println("Enter the String");
        String str=sc.nextLine();
        
        String str1=str.toLowerCase();
        int countc=0;
        int countv=0;
        
        for(int i=0;i<str1.length();i++)
        {
        	if(str1.charAt(i)=='a'||str1.charAt(i)=='e'||str1.charAt(i)=='i'||str1.charAt(i)=='o'||str1.charAt(i)=='u')
        	{
        		countv++;
        	}
        	else if(str1.charAt(i)<='z' && str1.charAt(i)>='a')
        	{
        	    countc++;
        	}
 
        }
        
        System.out.println("In String Count of Consonents: "+countc+" Count of Vowels:"+countv);
        

	}

}
