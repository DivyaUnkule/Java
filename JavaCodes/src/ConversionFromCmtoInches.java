import java.util.Scanner;
public class ConversionFromCmtoInches {

	public static void main(String[] args) {
		Scanner sc =new Scanner (System.in);
		System.out.println("ENter value of cm");
		double cm=sc.nextDouble();
		
		double inches=cm*0.393701;
		System.out.println("Conversion from cm to inches is:"+inches);
	}

}
