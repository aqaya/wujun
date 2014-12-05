package com.primeton.wujun.shenzhoudb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.oscar.Driver");
		Connection conn  = DriverManager.getConnection("jdbc:oscar://192.168.6.55:2003/osrdb","SYSDBA","szoscar55");
		System.out.println(conn==null?"conn==null":"Success!");
	}

}
