package com.callor.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {

	private static Connection dbConn;

	static {

		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "myfood";
		String password = "myfood";

		if (dbConn == null) {

			try {
				Class.forName(jdbcDriver);
				dbConn = DriverManager.getConnection(url, username, password);
				System.out.println("����Ŭ���� OK");
			} catch (ClassNotFoundException e) {
				System.out.println("ojdbc.jar�� Ȯ���ϼ���");
			} catch (SQLException e) {
				System.out.println("=".repeat(30));
				System.out.println("Drvier : " + jdbcDriver);
				System.out.println("url :" + url);
				System.out.println("UserName : " + username);
				System.out.println("PassWord : " + password);
				System.out.println("-".repeat(30));
				System.out.println("����Ŭ DBMS ���� ����");
				System.out.println("������ Ȯ���ϼ���");
				System.out.println("=".repeat(30));
			}

		}
	}
	
	public static Connection getDBConnection() {
		return dbConn;
	}

}
