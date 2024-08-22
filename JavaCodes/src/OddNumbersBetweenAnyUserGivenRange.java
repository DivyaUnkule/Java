import java.util.Scanner;
public class OddNumbersBetweenAnyUserGivenRange {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter starting point");
		int start=sc.nextInt();
		
		System.out.println("enter ending point");
		int end=sc.nextInt();
		
		if(start >end)
		{
			int temp=start;
			start=end;
			end=temp;
		}
		
		while(start!=(end+1))
		{
			if(start%2!=0)
			{
			
				System.out.println(start+" ");
			
			}
			start++;
		}
		

	}

}
