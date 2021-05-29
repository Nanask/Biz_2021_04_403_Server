package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {

	private static Connection dbConn;

	/*
	 * static �ʱ�ȭ �� static���� ����� ������ ��ü�� ������Ʈ�� ���۵ɶ� �ڵ����� �����ϴ� �ڵ带 �ۼ��ϴ� �κ�
	 * 
	 * Connection ��ü�� dbConn�� ����� �غ� �ϱ� DB Server�� ������ �����Ͽ� ���� session �� �����صд� �ʿ��Ҷ�
	 * get() method�� ���Ͽ� �������ش�
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
				System.out.println("mySQL ���ӿϷ�");
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
	// Instance : ����غ�(������, �ʱ�ȭ��) ��ü
	// private static ���� ����� ����, ��ü��
	// �ٸ� ������ ����Ҽ� �ֵ��� �����ϴ� method
	public static Connection getDbConn() {
		return dbConn;
	}
}
