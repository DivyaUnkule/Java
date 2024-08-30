package StringCodes;
import java.util.Scanner;
public class SandwitchString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("ENter the String");
		String s=sc.next();
		
		System.out.println("Enter the number ");
		int n=sc.nextInt();
		
		char[]arr=new char[s.length()];
		arr=s.toCharArray();
		
		int result=1;
	
		
		for(int i=0;i<n;i++)
		{
			
			if(arr[i]!=arr[arr.length-1-i])
			{
				result=0;
				break;
			}
			
			
			
		}
		if(result==1)
		{
			System.out.println("Sandwitch String");
		}
		
		else
		{
			System.out.println("not a sandwitch String");
		}
		
		

	}

}
