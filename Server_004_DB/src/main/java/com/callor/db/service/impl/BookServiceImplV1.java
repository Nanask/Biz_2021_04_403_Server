package com.callor.db.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.db.model.BookVO;
import com.callor.db.service.BookService;

public class BookServiceImplV1 implements BookService {
	protected Connection dbConn;
	
	public BookServiceImplV1() {
		this.dbConnection();
	}
	
	
	// DB�� �����Ͽ� CRUD ������ �ϱ� ���� �غ� �ϴ� method
	
	private void dbConnection() {
		
		// Java ������ ���� �ణ ���̰� �־ Java 9 �̻󿡼��� jdbc.OracleDriver�� ����ؾ� �Ѵ�.
		// "oracle.jdbc.driver.OracleDriver"
		
		/*
		 * WAS ������Ʈ���� ojdbc6.jar�� ����� ���
		 * Tomcat ������ lib ������
		 */
		// DB������ ���� �⺻����
		String dbDriver = "oracle.jdbc.OracleDriver";
		
		
		// jdbc:oracle:thin:������ �ڹٿ���
		// ������Ʈ���� SQL�� �����ϸ� url�� ������ ��θ� ���ؼ� ����� �����ϰ�
		// ����� �ްڴ�
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "bookuser";
		String password = "bookuser";
		
		try {
			// oracle�� ������ �̵��� �����϶�
			// Java 7 �̻󿡼��� �������̴�. ȣȯ���� ����: ������ ���� ������� ������ ������ ���� �ʴ� ������ �߻��ϱ� ����
			Class.forName(dbDriver);
			
			//������ ���ο��� �ϰ� ������ �޼ҵ带 ���� ���������Ѵ�.
			//url, user, password ������ ����Ͽ� Oracle�� �����϶�
			dbConn = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(BookVO bookVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BookVO> selectAll() {
		// TODO ��ü �������� ��ȸ �� return
		
		// SQL�� DBMS�� ���Ҷ� ����� ���� ����
		PreparedStatement pStr = null;
		String sql = "SELECT * FROM tbl_books";
		
		// ���ڿ��� �Ǿ��ִ� SQL ����� url�� ���� DB�� �����ϱ� ���Ͽ� packing�϶�
		
		/*
		 * packing�϶�
		 * ��Ʈ��ũ�� ���ؼ� �����͸� �ְ� �������� ������ �ܿ� �������� �������� ���ԵǾ�� �Ѵ�.
		 * �޴°� �ּ�, �����°� �ּ� ���
		 */
		try {
			//��Ʈ��ũ�� ���� �����Ͱ� ���۵Ǳ� ������ try���� ����ؾ� �Ѵ�.
			pStr = dbConn.prepareStatement(sql);
			
			// pStr�� �ϴ� �� 
			// packing�� ����� DBMS�� �����϶�
			// ���۵� ����� ������ ����� ResultSet Ÿ���� �����ͷ� return ���ش�.
			ResultSet result = pStr.executeQuery();
			result.next();
			
			List<BookVO> bookList = new ArrayList<BookVO>();
			
//			while(true) {
			while( result.next() ) {
				// return���� ������� ������ 1���� ���� �غ� ����
				// ���� �����Ͱ� ������ true�� return
				// ���̻� �����Ͱ� ���ٸ� false return
//				if( !result.next() ) break;
				
				BookVO bookVO = new BookVO();
				bookVO.setBk_isbn(result.getString("ISBN"));
				bookVO.setBk_title(result.getString("������"));
				bookVO.setBk_ccode(result.getString("���ǻ��"));
				bookVO.setBk_acode(result.getString("���ڸ�"));
				
				// price, pages�� ���������� ������� ������ getInt�� ����Ͽ� �޴´�.
				bookVO.setBk_price(result.getInt("bk_price"));
				bookVO.setBk_pages(result.getInt("bk_pages"));
				
				bookList.add(bookVO);
				System.out.println(bookVO.toString());
			}//end while
			result.close();
			pStr.close();
			return bookList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public BookVO findByID(String bk_isbn) {
		// TODO ISBN���� �������� ��ȸ�� ������ return
		PreparedStatement pStr = null;
		String sql = "SELECT * FROM view_�������� WHERE ISBN= '" + bk_isbn + "'";
		
		try {
			pStr =dbConn.prepareStatement(sql);
			ResultSet result = pStr.executeQuery();
			if(result.next()) {
				BookVO bookVO = new BookVO();
				bookVO.setBk_isbn(result.getString("ISBN"));
				bookVO.setBk_title(result.getString("������"));
				bookVO.setBk_ccode(result.getString("���ǻ��"));
				bookVO.setBk_acode(result.getString("���ڸ�"));
				return bookVO;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<BookVO> findByTitle(String bk_title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByComp(String bk_comp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BookVO bookVO) {
		// TODO Auto-generated method stub
		
	}

	//bk_isbn = 10R1=1
	@Override
	public void delete(String bk_isbn) {
		// TODO ISBN�� ���޹޾Ƽ� ������ ����
		String sql = "DELETE FROM tbl_books WHERE bk_isbn";
		
	}

}
