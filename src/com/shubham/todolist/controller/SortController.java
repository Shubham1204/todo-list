package com.shubham.todolist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shubham.todolist.model.todolistOperation;

/**
 * Servlet implementation class SortController
 */
@WebServlet("/sort")
public class SortController extends HttpServlet {
	todolistOperation opr = new todolistOperation();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pend = opr.pendingcount;
		int comp = opr.completecount;
		opr.sort();
		request.setAttribute("mydata", opr.list);
		request.setAttribute("pending", pend);
		request.setAttribute("complete", comp);
		request.setAttribute("totallist", opr.list.size());
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}