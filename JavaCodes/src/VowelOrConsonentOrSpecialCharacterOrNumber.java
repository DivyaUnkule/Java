import java.util.Scanner;
public class VowelOrConsonentOrSpecialCharacterOrNumber {
	public static void main(String[]args)
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Any Character");
		char ch=sc.next().charAt(0);
		char c=Character.toLowerCase(ch);
		
		if((c<=90 && c>=65) || (c<=122 && c>=97))
		{
		if(c=='a' ||c=='e'||c=='i'||c=='o'||c=='u')
		{
			System.out.println(ch+" is vowel");
		}
		else 
		{
			System.out.println(ch+" is consonent");
		}
		}
		else if(c<=57 && c>=48)
		{
			System.out.println(ch+" is number");
		}
		else 
		{
			System.out.println(ch+" is special character");
		}
		
	}

}
