package com.shubham.todolist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

public interface TodolistDAO {
		public static boolean  register(String userid, String password) throws ClassNotFoundException, SQLException, NamingException {
			Connection con = null;
			PreparedStatement pstmt = null;
			
//			String msg ="Unable to Register";
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement("insert into user_mst (userid, password) values(?,?)");
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			int recordCount = pstmt.executeUpdate();
			if(recordCount>0) {
//				msg = "Register SuccessFully";
				System.out.println("register successfully");
				return true;

			}
			
			pstmt.close();
			con.close();
//			return msg;
			return false;
		}
	public static boolean login(String userid, String password) throws ClassNotFoundException, SQLException, NamingException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		String msg ="Invalid Userid or Password";
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("select userid, password "
				+ "from user_mst where userid=? and password=?");
		pstmt.setString(1, userid);
		pstmt.setString(2, password);
		rs = pstmt.executeQuery();
		System.out.println(pstmt);
		System.out.println(rs);
		if(rs.next()) {
//			msg = "Welcome "+userid;
			System.out.println("Login successful");
			return true;
		}
		rs.close();
		pstmt.close();
		con.close();
//		return msg;
		return false;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException, NamingException {
//		System.out.println(TodolistDAO.register("tom", "4343"));
		System.out.println(TodolistDAO.login("ram", "1234"));
	}
}
