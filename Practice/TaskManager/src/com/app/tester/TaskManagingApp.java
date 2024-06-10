package com.app.tester;

import static com.app.utils.TaskValidations.addNewTaskToList;
import static com.app.utils.TaskValidations.deleteTask;
import static com.app.utils.TaskValidations.pendingTasks;
import static com.app.utils.TaskValidations.pendingTasksOfToday;
import static com.app.utils.TaskValidations.taskUpdate;
import static com.app.utils.UtilsClass.addTasks;
import static com.app.utils.UtilsClass.populateMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.app.taskmanaging.TaskManager;

public class TaskManagingApp {
public static void main(String[] args) {
	Map<Integer,TaskManager>map=populateMap(addTasks());
	
	boolean exit=false;
	
	try(Scanner sc=new Scanner(System.in)) {
		
		while(!exit)
		{
			System.out.println("Enter Your Choice: 1.Display Tasks 2.Add NEw Task 3.Delete a task 4.Update task status"
					+ "5.Display all pending tasks 6.Display all pending tasks for today "
					+ "7.Display all tasks sorted by taskDate 0.Exit");
			switch(sc.nextInt())
			{
			case 1://display Tasks
				map.forEach((k,v)-> System.out.println(v));
				break;
			case 2://Add new Task
				System.out.println("Enter taskName, description,taskDate");
				String s=addNewTaskToList(sc.next(),sc.next(),sc.next(),map);
				System.out.println(s);
				break;
				
			case 3://delete task
				System.out.println("Enter Task ID:");
				String s1=deleteTask(sc.nextInt(),map);
				System.out.println(s1);
				break;
				
				
			case 4://Update task status 
				System.out.println("Enter task ID and status to update");
				String s2=taskUpdate(sc.nextInt(),sc.next(),map);
				System.out.println(s2);
				break;
				
			case 5://Display all pending tasks
				pendingTasks(map);
				break;
				
			case 6://Display all pending tasks for today
				pendingTasksOfToday(map);
				break;
				
			case 7://Display all tasks sorted by taskDate   
				Collection<TaskManager>c=map.values();
				List<TaskManager>lst=new ArrayList<>(c);
				Comparator<TaskManager> cmp = (o1, o2) -> {
				    return o1.getTaskDate().compareTo(o2.getTaskDate());
				};
				Collections.sort(lst,cmp);
				lst.forEach(p->System.out.println(p));
				break;
			case 0://exit
				exit=true;
				
			}
			
		}
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

}
