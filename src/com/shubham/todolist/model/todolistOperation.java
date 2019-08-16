package com.shubham.todolist.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class todolistOperation {
	public static ArrayList<todolist> list = new ArrayList<>();
	public static int pendingcount;
	public static int completecount;
	

	public int iscomplete(todolist todo, String operation) {
		if(todo.getEndDate().isBefore(LocalDate.now()) && operation=="add") {
			completecount++;
		}
		else if(todo.getEndDate().isBefore(LocalDate.now()) && operation=="del") {
			completecount--;
		}
		System.out.println("complete "+completecount);
		return completecount;
	}
	
	public int ispending(todolist todo, String operation) {
		if(todo.getEndDate().isAfter(LocalDate.now()) && operation=="add") {
			pendingcount++;
		}else if(todo.getEndDate().isAfter(LocalDate.now()) && operation=="del") {
			pendingcount--;
		}
		System.out.println("pending "+pendingcount);
		return pendingcount;
	}
	
	public void add(todolist todo) {
		System.out.println(list.indexOf(todo));
		list.add(todo);
		System.out.println(list.indexOf(todo));
		System.out.println("list is"+list);
	}
	
	public int search(int id) {
		System.out.println("id in operations"+id);
		todolist todo = new todolist();
		System.out.println("search indexOf list before setId"+list.indexOf(todo));
		todo.setId(id);
		System.out.println("todo "+todo);
		int index = list.indexOf(todo);
		//int index = list.indexOf(todo);
		System.out.println("index in operations "+index);
		return index;
	}
	
	public boolean delete(int id) {
		int index = search(id);
		if(index>=0) {
			System.out.println("delete index"+index);
//			todolist todo = new todolist(list.get(index).getId(),list.get(index).getTaskName(),list.get(index).getDesc(),list.get(index).getStartDate(),list.get(index).getEndDate());
//			iscomplete(todo, "del");
//			ispending(todo, "del");
			list.remove(index);
//			if(todo.getEndDate().isBefore(LocalDate.now())) {
//				completecount--;
//			}
//			else {
//				pendingcount--;
//			}
			return true;
		}
		return false;
	}
	
	public int update(int id) {
		System.out.println("id in operations"+id);
		todolist todo = new todolist();
		System.out.println("search indexOf list before setId"+list.indexOf(todo));
		todo.setId(id);
		System.out.println("todo "+todo);
		int index = list.indexOf(todo);
		//int index = list.indexOf(todo);
		System.out.println("index in operations "+index);
		return index;
	}
	
	public void sort() {

		Collections.sort(list,
				(obj1,obj2)->
		((Integer)obj1.getId()).compareTo(obj2.getId()));
		
	}
	
}
