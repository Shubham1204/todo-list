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
 * Servlet implementation class UpdateController
 */
@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	todolistOperation opr = new todolistOperation();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		int index = opr.update(Integer.parseInt((id)));
		if(index>=0) {
			todolist todo = new todolist(index,opr.list.get(index).getTaskName(),opr.list.get(index).getDesc(),opr.list.get(index).getStartDate(),opr.list.get(index).getEndDate());
			
			int pend = opr.ispending(todo, "del");
			int comp = opr.iscomplete(todo, "del");
//			request.setAttribute("mydata", opr.list);
//			request.setAttribute("totallist", opr.list.size());
			request.setAttribute("updateresultid", opr.list.get(index).getId());
			request.setAttribute("updateresulttname", opr.list.get(index).getTaskName());
			request.setAttribute("updateresultdesc", opr.list.get(index).getDesc());
			request.setAttribute("updateresultsdate", opr.list.get(index).getStartDate());
			request.setAttribute("updateresultedate", opr.list.get(index).getEndDate());
			if(opr.delete(Integer.parseInt(id))) {
				request.setAttribute("totallist", opr.list.size());
				request.setAttribute("mydata", opr.list);
				request.setAttribute("pending", pend);
				request.setAttribute("complete", comp);
			}
			doPost(request, response);
		}
		else {
			out.println("No id found can't update");
		}
		
		out.close();
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
}
		
			
//	System.out.println("searchctrl "+index);
//	if(index>=0) {
//		request.setAttribute("mydata", opr.list);
//		request.setAttribute("searchresult", opr.list.get(index).toString());
//		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//		rd.forward(request, response);
//	}