import java.util.Scanner;
public class PositiveOrNegativeNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("ENter number to check");
		int n=sc.nextInt();
		
		if(n>0)
		{
			System.out.println(n+" is positive number");
		}
		else if(n<0)
		{
			System.out.println(n+" is negative number");
		}
		else
		{
			System.out.println(n+" is zero");
		}

	}

}
