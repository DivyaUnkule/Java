package TSystemCode;

import java.util.Scanner;

public class LuckyOrUnluckyYear {
    public static int LuckyYearMethod(int n,int[]a)
    {
    	int flag=1;
    	while(n<=20000)
    	{
    	int temp=n;
    	while(temp>0)
    	{
    		flag=1;
    		int d=temp%10;
    		for(int i=0;i<a.length;i++)
    		{
    			if(d==a[i])
    			{
    				flag=0;
    				break;
    				
    			}
    			else
    			{
    				flag=1;
    			}
    		}
    		if(flag==0)
    		{
    			break;
    		}
    	temp=temp/10;
    	}
    	if(flag==1)
    	{
    		break;
    	}
    	else
    	{
    		n++;
    	}
    	}
   
       return n;
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int num=sc.nextInt();
		System.out.println("Enter Size of an array");
		int k=sc.nextInt();
		int [] arr=new int[k];
		
		for(int i=0;i<k;i++)
		{
			System.out.println("enter the element");
			arr[i]=sc.nextInt();
		}
		
		int result=LuckyYearMethod(num,arr);
		
		System.out.println("Lucky Year: "+result);
		
		

	}

}
