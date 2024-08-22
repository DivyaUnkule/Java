import java.util.Scanner;
public class NumberPositiveOrNegativeEvenOrOddOrZero {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		System.out.println("ENter number to check");
		int n=sc.nextInt();
		if(n>0)
		{
			if(n%2==0)
			{
			System.out.println(n+" is positive even number");
			}
			else
			{
			System.out.println(n+" is positive odd number");
			}
		}
		else if(n<0)
		{
			if(n%2==0)
			{
			System.out.println(n+" is negative even number");
			}
			else
			{
			System.out.println(n+" is negative odd number");
			}
		}
		else
		{
			System.out.println(n+" is zero");
		}
		
		

	}

}
