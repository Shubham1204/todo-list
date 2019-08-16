package com.shubham.todolist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.NamingException;

public interface CommonDAO {
	
	 static Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = null;
//		InitialContext initContext = new InitialContext();
//		Context context = (Context) initContext.lookup("java:comp/env");
//		DataSource dataSource = (DataSource)context.lookup("jdbc/todopool");
//		con = dataSource.getConnection();
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist","root","shubham");
		if(con!=null) {
			System.out.println("Connnection Created.");
//			con.close();
		}
		else {
			System.out.println("Not Created.");
		}
		return con;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException, NamingException {
		CommonDAO.getConnection();
	}

}
