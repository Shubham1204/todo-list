package com.shubham.todolist.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shubham.todolist.dao.TodolistDAO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/loginregister")
public class LoginRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		PrintWriter out = response.getWriter();
		try {
			if (request.getParameter("register") != null) {
				if(TodolistDAO.register(userid, pwd) == true) {
					HttpSession session = request.getSession(true);
					System.out.println(session.getId());
					session.setAttribute("uid", userid);
//					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//					rd.forward(request, response);
					response.sendRedirect("index.jsp");
				}
				else {
//					request.setAttribute("notregister", "Unable to register");
					out.println("Unable to register");
				}
			}else if(request.getParameter("login") != null) {
				if(TodolistDAO.login(userid, pwd) == true) {
					HttpSession session = request.getSession(true);
					System.out.println(session.getId());
					session.setAttribute("uid", userid);
					response.sendRedirect("index.jsp");
				}
				else {
//					request.setAttribute("notregister", "Unable to register");
					out.println("Unable to login");
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
