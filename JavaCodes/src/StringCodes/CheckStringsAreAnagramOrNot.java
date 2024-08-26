package StringCodes;
import java.util.Arrays;
import java.util.Scanner;
public class CheckStringsAreAnagramOrNot {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter first string");
		String str1=sc.nextLine();
		
		System.out.println("Enter second string");
		String str2=sc.nextLine();
		
		str1=str1.toLowerCase();
		str2=str2.toLowerCase();
		
		//check length of the strings
		if(str1.length()!=str2.length())
		{
			System.out.println("Strings are not anagram");
		}
		else
		{
			char[] st1=str1.toCharArray();
			char[] st2=str2.toCharArray();
			
			Arrays.sort(st1);
			Arrays.sort(st2);
			
			if(Arrays.equals(st1,st2)==true)
			{
				System.out.println("strings are anagram");
			}
			else
			{
				System.out.println("strings are not anagram");
			}
			
			
		}
		
		
		
	}

}
