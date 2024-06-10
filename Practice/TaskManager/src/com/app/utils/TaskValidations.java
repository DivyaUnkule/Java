package com.app.utils;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

import com.app.task_exceptions.TaskManagementException;
import com.app.taskmanaging.Status;
import com.app.taskmanaging.TaskManager;

public class TaskValidations {
	public static String addNewTaskToList(String taskName, String description, String taskDate,Map<Integer,TaskManager>map) throws TaskManagementException
	{
		validateExistingTaskAndItsDesription(taskName,description,map);
		LocalDate d=parsetaskDate(taskDate);
		TaskManager t=new TaskManager(taskName,description,d);
		int id=t.getTaskId();
		 map.put(id, t);
		return "Task Addded successfully";
	}

public static LocalDate parsetaskDate(String taskDate) {
		
		return LocalDate.parse(taskDate);
	}



public static void validateExistingTaskAndItsDesription(String taskName,String description,Map<Integer,TaskManager>map) throws TaskManagementException
   {
	  Collection<TaskManager> c=map.values();
	  
	  for(TaskManager t:c)
	  {
		  if(t.getTaskName().endsWith(taskName))
		  {
			  if(t.getDescription().equals(description))
			  {
				  throw new TaskManagementException("Task Already Exist and Status of the task is"+t.getStatus());
			  }
		}
	  }
	  
	   
   }
public static String deleteTask(int id,Map<Integer,TaskManager>map) throws TaskManagementException
{
	validateTaskId(id,map);
	map.remove(id);
	return "Task Deleted Successfully";
}

public static void validateTaskId(int id,Map<Integer,TaskManager>map) throws TaskManagementException
{
	if(!(map.containsKey(id)))
	{
		throw new TaskManagementException("Task doesnot exist");
	}
}
public static String taskUpdate(int taskID,String status,Map<Integer,TaskManager>map) throws TaskManagementException
{
	validateTaskId(taskID,map);
	Status s=parseAndValidateStatus(status);
	TaskManager t=map.get(taskID);
	t.setStatus(s);
	return "TAsk Updated Successfully";
}
public static Status parseAndValidateStatus(String status) throws TaskManagementException
{
	Status s=Status.valueOf(status.toUpperCase());
	if(s==null)
	{
		throw new TaskManagementException("Status provided doesnot exist");
	}
	return s;
}
public static void pendingTasks(Map<Integer,TaskManager>map)
{
	System.out.println("All Pending tasks");
	(map.values()).stream().filter(p->p.getStatus().equals(Status.PENDING)).forEach(p->System.out.println(p));
}
public static void pendingTasksOfToday(Map<Integer,TaskManager>map)
{
	System.out.println("All today's Pending Tasks");
	(map.values()).stream()
	.filter(p->(p.getStatus().equals(Status.PENDING))&&(p.getTaskDate().equals(LocalDate.now())))
	.forEach(p->System.out.println(p));
}
}