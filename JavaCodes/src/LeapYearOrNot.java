import java.util.Scanner;
public class LeapYearOrNot {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("ENter Year");
		int y=sc.nextInt();
		
		if(y%100==0)
		{
			if(y%400==0 && y%4==0)
			{
			System.out.println("Year is Leap Year");
			}
			else
			{
				System.out.println("Year is not leap year");
			}
		}
		else if(y%100!=0)
		{
			if(y%4==0)
			{
			System.out.println("Year is Leap Year");
			}
			else
			{
				System.out.println("Year is not leap year");
			}
		}
		
		
		
	}

}
