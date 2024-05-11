package runnable_tasks;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;
import static utils.IOUtils.*;
import com.app.core.Student;

public class DetailsByDobSorter implements Runnable {
	private Map<String,Student> smap;
	private String fName;
	
	public DetailsByDobSorter(Map<String,Student> smap,String fName)
	{
		this.smap=smap;
		this.fName=fName;
		
		System.out.println("Constructor of class: "+getClass()+"\n Called by: "+Thread.currentThread().getName());
		
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" Started");
		
		Comparator<Student>cmp=(s1,s2)->(s1.getDob().compareTo(s2.getDob()));
		Stream<Student>s=smap.values().stream().sorted(cmp);
		
		try {
			writeDetails(s, fName);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("File Written Successfully");
		System.out.println(Thread.currentThread().getName()+" Over");
		
	}

}
