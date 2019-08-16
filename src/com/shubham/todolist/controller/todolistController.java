package com.shubham.todolist.controller;
import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shubham.todolist.model.MailModel;
import com.shubham.todolist.model.todolist;
import com.shubham.todolist.model.todolistOperation;

/**
 * Servlet implementation class ToDoListController
 */
@WebServlet("/todo")
public class todolistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	todolistOperation opr ;
	
	public void init() {
		opr = new todolistOperation();
		System.out.println("init call");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String sortbtn = request.getParameter("sort-asc-btn");
//		if(sortbtn!=null && sortbtn.equals("SortIt")) {
//			RequestDispatcher rd  = request.getRequestDispatcher("sort");
//			rd.forward(request, response);
//			return ;
//			}
		
		
		String btn = request.getParameter("searchitbtn");
		if(btn!=null && btn.equals("SearchIt")) {
			RequestDispatcher rd  = request.getRequestDispatcher("/searchctrl");
			rd.forward(request, response);
			return ;
			}
		
		String id = request.getParameter("id");
		String taskname = request.getParameter("taskname");
		String desc = request.getParameter("desc");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		//Date d = new Date(date);
		LocalDate sd = LocalDate.parse(startdate);
		LocalDate ed = LocalDate.parse(enddate);
		
		System.out.println("Date is "+ed+" "+sd);
		todolist obj = new todolist(Integer.parseInt(id), taskname, desc, sd, ed);
		opr.add(obj);
		int pend = opr.ispending(obj,"add");
		int comp = opr.iscomplete(obj,"add");
		
//		obj.getStartDate(),obj.getEndDate()		
		//System.out.println("   I am in Post "+id+" "+name+" "+desc+"   "+date );
		
		
		if (request.getParameter("addtask") != null) {
		    int tsize = opr.list.size();
		    System.out.println("size is "+tsize);
		    request.setAttribute("totallist", opr.list.size());
			request.setAttribute("mydata", opr.list);
			request.setAttribute("pending", pend);
			request.setAttribute("complete", comp);
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		}else if (request.getParameter("addtaskandmail") != null) {
		    
			String smail = request.getParameter("smail");
			String spwd = request.getParameter("spwd");
			String rmail = request.getParameter("rmail");
//			String smail = "shubhama12499@gmail.com";
//			String spwd = "shubham987";
//			String rmail  = "12shubhamgupta1999@gmail.com";
			
			MailModel.sendMail(taskname,desc, obj.getStartDate(),obj.getEndDate(),smail,spwd,rmail);
			request.setAttribute("mydata", opr.list);
			request.setAttribute("totallist", opr.list.size());
			request.setAttribute("pending", pend);
			request.setAttribute("complete", comp);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
	}

}