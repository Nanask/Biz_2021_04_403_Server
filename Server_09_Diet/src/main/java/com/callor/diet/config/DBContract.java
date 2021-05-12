package com.callor.diet.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {
	
	//private로 만든것은 직접 접속하지 못하게 하기 위함
	private static Connection dbConn;
	
	static {
		
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "myfood";
		String password = "myfood";
		
		// 이 프로젝트에서 어딘가 이미 dbConn이 만들어져 있다면 다시 만들지 않기 위한 코드
		if(dbConn == null) {
			
			// 호환성을 위해 사용
			try {
				Class.forName(jdbcDriver);
				dbConn = DriverManager.getConnection(url,username,password);
				System.out.println("오라클 접속 OK!!!");
			} catch (ClassNotFoundException e) {
				System.out.println("ojdbc6.jar를 확인하세요");
			} catch (SQLException e) {
				System.out.println("=".repeat(30));
				System.out.println("Driver : " + jdbcDriver);
				System.out.println("URL : " + url);
				System.out.println("UserName : " + username);
				System.out.println("Password : " + password);
				System.out.println("-".repeat(30));
				System.out.println("오라클 DBMS 접속 오류");
				System.out.println("접속 정보를 확인하세요");
				System.out.println("=".repeat(30));
			}
		}
	}
	
	// 미리 생성해 둔 dbConn 연결 객체를 가져갈 수 있도록 하는 통로
	public static Connection getDBConnection() {
		return dbConn;
	}

}
