import java.util.Scanner;

public class CheckSumOfDigitsIsOddAndDivisibleBy3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the number");
		int num = sc.nextInt();
		
		int sum=0;
		
		while(num!=0)
		{
			int d=num%10;
			sum=sum+d;
			num=num/10;
		}
		
		if(sum%2!=0)
		{
			if(sum%3==0)
			{
				System.out.println("sum is odd and divisible by 3");
			}
		}
		if(sum%2!=0)
		{
			if(sum%3!=0)
			{
				System.out.println("sum is odd and not divisible by 3");
			}
		}
		else 
		{
			System.out.println("sum is even");
		}
		
		
	}

}
