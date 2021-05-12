package com.callor.diet.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {
	
	//private�� ������� ���� �������� ���ϰ� �ϱ� ����
	private static Connection dbConn;
	
	static {
		
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "myfood";
		String password = "myfood";
		
		// �� ������Ʈ���� ��� �̹� dbConn�� ������� �ִٸ� �ٽ� ������ �ʱ� ���� �ڵ�
		if(dbConn == null) {
			
			// ȣȯ���� ���� ���
			try {
				Class.forName(jdbcDriver);
				dbConn = DriverManager.getConnection(url,username,password);
				System.out.println("����Ŭ ���� OK!!!");
			} catch (ClassNotFoundException e) {
				System.out.println("ojdbc6.jar�� Ȯ���ϼ���");
			} catch (SQLException e) {
				System.out.println("=".repeat(30));
				System.out.println("Driver : " + jdbcDriver);
				System.out.println("URL : " + url);
				System.out.println("UserName : " + username);
				System.out.println("Password : " + password);
				System.out.println("-".repeat(30));
				System.out.println("����Ŭ DBMS ���� ����");
				System.out.println("���� ������ Ȯ���ϼ���");
				System.out.println("=".repeat(30));
			}
		}
	}
	
	// �̸� ������ �� dbConn ���� ��ü�� ������ �� �ֵ��� �ϴ� ���
	public static Connection getDBConnection() {
		return dbConn;
	}

}
