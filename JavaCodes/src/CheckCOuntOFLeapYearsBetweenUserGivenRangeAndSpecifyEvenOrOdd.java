import java.util.Scanner;

public class CheckCOuntOFLeapYearsBetweenUserGivenRangeAndSpecifyEvenOrOdd {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("ENter start Year");
		int y1=sc.nextInt();
		
		System.out.println("ENter end Year");
		int y2=sc.nextInt();
		
		int count =0;
		while(y1!=(y2+1))
		{
		
		if(y1%100==0)
		{
			if(y1%400==0 && y1%4==0)
			{
			count++;
			}
			
		}
		else if(y1%100!=0)
		{
			if(y1%4==0)
			{
			count++;
			}
			
		}
		y1++;
		}
		
		if(count%2==0)
		{
		System.out.println("Total No of Leap years between given range is:  "+count+" ,which is even");
		}
		else
		{
			
			System.out.println("Total No of Leap years between given range is:  "+count+" ,which is odd");
			
		}
		
		
		
	}

	}


