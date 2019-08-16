package com.shubham.todolist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shubham.todolist.model.todolist;
import com.shubham.todolist.model.todolistOperation;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	todolistOperation opr = new todolistOperation();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
//		todolist obj = new todolist();
//		int pend = opr.ispending(obj, "del");
//		int comp = opr.completecount;
		
		int index = opr.search(Integer.parseInt(id));
		todolist todo = new todolist(index,opr.list.get(index).getTaskName(),opr.list.get(index).getDesc(),opr.list.get(index).getStartDate(),opr.list.get(index).getEndDate());
		
		int pend = opr.ispending(todo, "del");
		int comp = opr.iscomplete(todo, "del");
		
		if(opr.delete(Integer.parseInt(id))) {
//			todolist todo = new todolist(Integer.parseInt(id),opr.list.get(Integer.parseInt(id)).getEndDate());
//			int pend = opr.iscomplete(todo, "del");
//			int comp = opr.ispending(todo, "del");
			request.setAttribute("totallist", opr.list.size());
			request.setAttribute("mydata", opr.list);
			request.setAttribute("pending", pend);
			request.setAttribute("complete", comp);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		else {
			out.println("NO ID FOUND CAN'T DELETE ");
		}
		out.close();
		//System.out.println("I am in Delete "+id);
	}

}