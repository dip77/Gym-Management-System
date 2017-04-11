package com.digimation.goldengym.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {

	private static String username = "root";
	private static String password = "root";
	private static String URL = "jdbc:mysql://localhost:3306/gym";
	private static String driverClass = "com.mysql.jdbc.Driver";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(URL, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}

	public static void main(String[] args) {
		if (getConnection() != null)
			System.out.println(1);
		else
			System.out.println(0);

	}

}
