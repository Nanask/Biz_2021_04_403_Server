package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {

	private static Connection dbConn;

	/*
	 * static 초기화 블럭 static으로 선언된 변수나 객체를 프로젝트가 시작될때 자동으로 생성하는 코드를 작성하는 부분
	 * 
	 * Connection 객체인 dbConn을 사용할 준비를 하기 DB Server와 연동을 시작하여 연결 session 을 생성해둔다 필요할때
	 * get() method를 통하여 제공해준다
	 */

	static {

		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/guestbook";
		String user = "gbUser";
		String password = "12345";

		try {
			Class.forName(jdbcDriver);
			if (dbConn == null) {
				dbConn = DriverManager.getConnection(url, user, password);
				System.out.println("mySQL 접속완료");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// get Instance method
	// Instance : 사용준비(생성된, 초기화된) 객체
	// private static 으로 선언된 변수, 객체를
	// 다른 곳에서 사용할수 있도록 제공하는 method
	public static Connection getDbConn() {
		return dbConn;
	}
}
