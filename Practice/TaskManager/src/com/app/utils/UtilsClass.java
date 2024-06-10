package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.taskmanaging.Status;
import com.app.taskmanaging.TaskManager;

public class UtilsClass {
	public static List<TaskManager> addTasks()
	{
		List<TaskManager>lst=new ArrayList<TaskManager>(
				Arrays.asList(new TaskManager(1, "Reading", "Read Java Notes",LocalDate.parse("2024-06-09"),Status.valueOf("pending".toUpperCase()),
						true),
				new TaskManager(2, "Writing", "Write Java STticky Notes",LocalDate.parse("2024-06-01"),Status.valueOf("Inprogress".toUpperCase()),
							false),

				new TaskManager(3, "Coding", "DO Java Exercise",LocalDate.parse("2024-06-09"),Status.valueOf("inprogress".toUpperCase()),
							true),
				new TaskManager(4, "Aptitute", "SOlve aptitute questions",LocalDate.parse("2024-04-04"),Status.valueOf("pending".toUpperCase()),
							false),
				new TaskManager(5, "Shopping", "shop necessary things",LocalDate.parse("2024-05-01"),Status.valueOf("completed".toUpperCase()),
							false)));
		return lst;
		
	}
	
	public static Map<Integer,TaskManager> populateMap(List<TaskManager> lst)
	{
		Map<Integer,TaskManager> map=new HashMap();
		lst.forEach(t->map.put(t.getTaskId(),t));
		return map;
	}


}
