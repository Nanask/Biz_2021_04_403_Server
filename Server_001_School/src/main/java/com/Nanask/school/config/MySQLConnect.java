package com.Nanask.school.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnect {

	private static Connection dbConn;

	static {

		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/school";
		String username = "scUser";
		String password = "1234";

		try {
			Class.forName(jdbcDriver);
			if (dbConn == null) {

				dbConn = DriverManager.getConnection(url, username, password);

			}
			
			System.out.println("MySQL ���� �Ϸ�");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getDBConnection() {
		return dbConn;

	}

}
