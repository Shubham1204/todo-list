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
 * Servlet implementation class SearchController
 */
@WebServlet("/searchctrl")
public class SearchController extends HttpServlet {
	todolistOperation opr = new todolistOperation();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("sid"));
		System.out.println(id);
		int index = opr.search(id);
		int pend = opr.pendingcount;
		int comp = opr.completecount;
	System.out.println("searchctrl "+index);
	if(index>=0) {
		request.setAttribute("mydata", opr.list);
		request.setAttribute("totallist", opr.list.size());
		request.setAttribute("pending", pend);
		request.setAttribute("complete", comp);
//		request.setAttribute("pending", opr.list.get(index).getIsPending());
		request.setAttribute("searchresult", opr.list.get(index).toString());
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
	else {
		out.println("Not Found");
	}
	out.close();
		
	}

}