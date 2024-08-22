import java.util.Scanner;
public class SumOFEvenNumbersFromUSerGivenRange {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter starting point");
		int start=sc.nextInt();
		
		System.out.println("enter ending point");
		int end=sc.nextInt();
		
		int sum=0;
		
		while(start!=(end+1))
		{
			if(start%2==0)
			{
				sum=sum+start;
			}
			start++;
		}
		
		System.out.println("Sum: "+sum);

	}

}
