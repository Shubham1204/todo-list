package com.shubham.todolist.model;

import java.time.LocalDate;

import sun.security.x509.IssuingDistributionPointExtension;



public class todolist{
	
	private int id;
	private String taskname;
	private String desc;
	private LocalDate startdate;
	private LocalDate enddate;
//	private boolean pending;
//	private boolean complete;
	private LocalDate localdate = LocalDate.now();
	
	@Override
	public boolean equals(Object object) {
		if(object == this) {
			return true;
		}
		if(object instanceof todolist) {
			todolist l = (todolist)object; 
			if(this.id>0 && this.taskname==null) {
				if(this.id == l.id) {
					System.out.println(this.id+" "+l.id);
					return true;
				}
			}
			if(this.taskname!=null) {
				if(this.id == l.id && this.taskname.equals(l.taskname) ) {
					System.out.println(this.taskname+" "+l.taskname);
					return true;
				}
			}
			
		}
		return false;
	}

	public LocalDate getLocaldate() {
		return localdate;
	}

	public void setLocaldate(LocalDate localdate) {
		this.localdate = localdate;
	}

	public todolist(){ }
	
	public todolist(int id) {
		this.id = id;
		
	}

	public todolist(int id, String taskname, String desc,LocalDate startdate, LocalDate enddate) {
		super();
		this.id = id;
		this.taskname = taskname;
		this.desc = desc;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public int getId() {
		return id>0?id:0;
	}

	public void setId(int id) {
		System.out.println("set id"+id);
		this.id = id;
		System.out.println("this.id setid"+this.id);
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

//	public LocalDate getStartdate() {
//		return startdate;
//	}
//
//	public void setStartdate(LocalDate startdate) {
//		this.startdate = startdate;
//	}
//
//	public LocalDate getEnddate() {
//		return enddate;
//	}
//
//	public void setEnddate(LocalDate enddate) {
//		this.enddate = enddate;
//	}

	public String getTaskName() {
		return taskname;
	}

	public void setTaskName(String taskname) {
		this.taskname = taskname;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public LocalDate getEndDate() {
		return enddate;
	}

	public void setEndDate(LocalDate enddate) {
		this.enddate = enddate;
//		if(enddate.isBefore(localdate)) {
//			setComplete(true);
//		}
//		else {
//			setPending(true);
//		}
//		if(enddate.isBefore(localdate)) {
//			setIsComplete(isComplete);;
//			System.out.println("Complete"+isComplete);
//		}
//		else {
//			setIsPending(isPending);
//			System.out.println("Pending"+isPending);
//		}
	}


//	public boolean isPending() {
//		return pending;
//	}
//
//	public void setPending(boolean pending) {
//		this.pending = pending;
//	}
//
//	public boolean isComplete() {
//		return complete;
//	}
//
//	public void setComplete(boolean complete) {
//		this.complete = complete;
//	}

	public LocalDate getStartDate() {
		return startdate;
	}

	public void setStartDate(LocalDate startdate) {
		this.startdate = startdate;
	}
	

	@Override
	public String toString() {
		return "todolist [id=" + id + ", taskname=" + taskname + ", desc=" + desc + ", startdate=" + startdate
				+ ", enddate=" + enddate + "]";
	}
	
}
