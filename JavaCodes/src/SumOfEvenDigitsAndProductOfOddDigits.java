import java.util.Scanner;
public class SumOfEvenDigitsAndProductOfOddDigits {

	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the number");
		int num = sc.nextInt();
		
		int sum=0;
		int product=1;
		
		while(num!=0)
		{
			int d=num%10;
			if(d%2==0)
			{
			sum=sum+d;
			}
			else if(d%2!=0)
			{
				product=product*d;
			}
			num=num/10;
		}
		
		System.out.println("Sum of Even Digits: "+sum);
		System.out.println("Product of odd digits: "+product);
		

	}

}
