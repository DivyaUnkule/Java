package Custom_Sorting;

import java.util.Comparator;

import com.app.core.Customer;

public class CustomerDobLastNameComparator implements Comparator<Customer> {
	@Override
	
	public int compare(Customer c1,Customer c2)
	{
		int value=(c1.getDob()).compareTo(c2.getDob());
		
		if(value == 0)
		{
			
				return (c1.getLastName()).compareTo(c2.getLastName());
			
		}
		return value;
	}
	

}
