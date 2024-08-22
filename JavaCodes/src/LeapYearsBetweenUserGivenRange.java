import java.util.Scanner;

public class LeapYearsBetweenUserGivenRange {

	public static void main(String[] args) {
		
			Scanner sc=new Scanner(System.in);
			
			System.out.println("ENter start Year");
			int y1=sc.nextInt();
			
			System.out.println("ENter end Year");
			int y2=sc.nextInt();
			while(y1!=(y2+1))
			{
			
			if(y1%100==0)
			{
				if(y1%400==0 && y1%4==0)
				{
				System.out.println(y1);
				}
				
			}
			else if(y1%100!=0)
			{
				if(y1%4==0)
				{
				System.out.println(y1);
				}
				
			}
			y1++;
			}
			
			
			
		}

	}


