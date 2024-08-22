import java.util.Scanner;
public class SwapWithoutUsingThirdVariable {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first number");
		int n1=sc.nextInt();
		
		System.out.println("Enter Second Number");
		int n2=sc.nextInt();
		
		System.out.println("Before Swapping: a:"+n1+" b:"+n2);
		
		n1=n1+n2;
		n2=n1-n2;
		n1=n1-n2;
		
		System.out.println("After Swapping: a:"+n1+" b:"+n2);
		
		
		
		
		
		
	

	}

}
