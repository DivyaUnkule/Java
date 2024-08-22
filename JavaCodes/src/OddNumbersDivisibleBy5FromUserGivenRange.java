import java.util.Scanner;
public class OddNumbersDivisibleBy5FromUserGivenRange {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter starting point");
		int start=sc.nextInt();
		
		System.out.println("enter ending point");
		int end=sc.nextInt();
		
		
		
		while(start!=(end+1))
		{
			if(start%2!=0)
			{
			if(start%5==0)
			{
				System.out.println(start+" ");
			}
			}
			start++;
		}
		

	}

}
