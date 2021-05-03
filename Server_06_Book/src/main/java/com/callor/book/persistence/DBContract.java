package com.callor.book.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 *  DB ������ ���� dbConnect ��ü�� �̸� ������ �ΰ� �ʿ��Ҷ� ����� �� �ֵ��� �ϴ� Ŭ����
 *  static class�� ����
 *  Ŭ������ ���Ե� �ʵ庯��, ��� method �� 1���� static Ű���尡 �����Ǹ� static class�� �ȴ�.
 *  ������Ʈ�� Run �Ǵ� ���� �̸� ��ü�� �����Ǿ� �غ�Ǵ� Ŭ����
 */
public class DBContract {
	private static Connection dbConn = null;
	
	// static ���� ����� dbConn ��ü�� �ʱ�ȭ�ϴ� �ڵ�
	static {
		
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "bookuser";
		String password = "bookuser";
		
		try {
			// Java 1.7�̻󿡼��� ������� �ʾƵ� �Ǵ� �ڵ�
			Class.forName(jdbcDriver);
			
			if(dbConn == null) {
				dbConn 
				= DriverManager.getConnection(url,
						username,password);
			}
			System.out.println("����Ŭ ���� OK!!!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("����Ŭ Drvier�� ã�� �� ����");
			System.out.println("����Ŭ Ojdbc6.jar �� Ȯ���ϼ���");
		} catch (SQLException e) {
			System.out.println("=".repeat(30));
			System.out.println("���� DBMS ���� ����!!");
			System.out.println("���� ������ Ȯ���ϼ���!!");
			System.out.println("-".repeat(30));
			System.out.println("URL : " + url);
			System.out.println("User : " + username);
			System.out.println("PW : " + password);
			System.out.println("=".repeat(30));
		}
	} // end static
	
	public static Connection getDBConnection() {
		return dbConn;
	}
	
}