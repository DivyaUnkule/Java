package runnable_tasks;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

import com.app.core.Student;
import com.app.core.Subject;
import static utils.IOUtils.*;

public class DetailsSortByperticularSubjectAndGrade implements Runnable {

	private Subject sub;
	private Map<String,Student> sm;
	private String fName;
	
	
	public DetailsSortByperticularSubjectAndGrade(Map<String,Student> sm,Subject sub,String fName)
	{
		this.sm=sm;
		this.sub=sub;
		this.fName=fName;
		System.out.println("Called by class : "+getClass());
	}
	
	@Override
	public void run() 
	{
		System.out.println("Thread called by: "+Thread.currentThread().getName()+" Started");
		
		Comparator<Student>cmp= (g1,g2) -> (((Double)g1.getGpa()).compareTo(g2.getGpa()));
		
		Stream<Student>stm = sm.values().stream().filter(s-> s.getSubject()==sub).sorted(cmp);
		
		try {
			
			writeDetails(stm,fName);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("File Written successfully");
		
		System.out.println("Thread called by: "+Thread.currentThread().getName()+" Over");
		
		
	}
	

}
