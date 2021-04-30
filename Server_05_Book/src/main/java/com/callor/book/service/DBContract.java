package com.callor.book.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * �̱���(Single Tone) ����
 * ������Ʈ�� �����ϴµ� �ʿ��� �ڿ�(Resource)�� ����� �������
 * ���� �ڿ��� ����ؼ� ������ �ʰ� �ѹ��� ����� �ΰ� ���������� Ȱ���ϴ� ���
 * 
 */
public class DBContract {
	
	
	private static Connection dbConn;
	
	//method�̸��� ���� method
	/*
	 * static �ڵ� ������
	 * ������Ʈ�� Run �Ǹ� ������ �ڵ尡 ����Ǵ� method
	 */
	static {
		
		 String jdbcDriver= "oracle.jdbc.OracleDriver";
		 String url = "jdbc:oracle:thin:@localhost:1521:xe";
		 String username = "bookuser";
		 String password = "bookuser";
		 
		 try {
			Class.forName(jdbcDriver);
			dbConn = DriverManager.getConnection(url, username, password);
			System.out.println("DB Connection OK!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("����Ŭ DB Driver ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("����Ŭ DB ���� ����");
		}
	} // end static
	
	public static Connection getDBConnection() {
		
		return dbConn;
	}

}
