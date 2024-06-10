package com.app.taskmanaging;

import java.time.LocalDate;

public class TaskManager implements Comparable<TaskManager>{
	private int taskId;
	private String taskName;
	private String description;
	private LocalDate taskDate;
	private  Status status;
	private boolean active;
	private static int idGenerator;
	
	public TaskManager() {
		// TODO Auto-generated constructor stub
	}
	
	public TaskManager(int taskId, String taskName, String description, LocalDate taskDate, Status status,
			boolean active) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.description = description;
		this.taskDate = taskDate;
		this.status = status;
		this.active = active;
		idGenerator = Math.max(idGenerator, taskId + 1);
	}

	public TaskManager( String taskName, String description, LocalDate taskDate) {
		super();
		this.taskId =idGenerator++ ;
		this.taskName = taskName;
		this.description = description;
		this.taskDate = taskDate;
		this.status = Status.valueOf("pending".toUpperCase());
		this.active = true;
	}

	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "TaskManager [taskId=" + taskId + ", taskName=" + taskName + ", description=" + description
				+ ", taskDate=" + taskDate + ", status=" + status + ", active=" + active + "]";
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof TaskManager)
		{
			TaskManager t=(TaskManager)o;
			return  (this.taskId==t.taskId);
		}
		return false;
		
	}

	@Override
	public int compareTo(TaskManager o) {
		if(this.taskId<o.taskId)
		{
			return -1;
		}
		else if(this.taskId==o.taskId)
		{
			return 0;
		}
		return 1;
	}
	
	
	
	

}
