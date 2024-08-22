import java.util.Scanner;
public class AreaOfRectangle {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Length of Rectangle");
		double l=sc.nextDouble();
		System.out.println("ENter breadth of Rectangle");
		double b=sc.nextDouble();
		
		double area=l*b;
		
		System.out.println("Area of Rectangle: "+area);
		
		

	}

}
