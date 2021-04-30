package com.callor.book.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.callor.book.model.BookDTO;
import com.callor.book.model.BookVO;
import com.callor.book.service.BookService;
import com.callor.book.service.DBContract;

/*
 * DB�� ������ Service
 * 
 * DB������ �ϰ�
 * 
 * SQL�� �ۼ��ϰ�
 * SQL Packing�ϰ�
 * Packing �� ��ü�� ����Ͽ� SQL ����
 * 
 * ��ȸ�� ���� ���ŵ� �����͸� ó��
 */

public class BookServiceImplV1 implements BookService {
	
	protected Connection dbConn;
	public BookServiceImplV1() {
		this.dbConn = DBContract.getDBConnection();
	}


	
	@Override
	public void insert(BookVO bookVO) {
		// TODO �������� �߰�
		
		String sql = " INSERT INTO tbl_books ";
		sql += "(bk_isbn, "
				+ " bk_title, bk_ccode, "
				+ " bk_acode, bk_date, "
				+ " bk_price, bk_pages) ";
		sql += "VALUES(?,?,?,?,?,?,?)";
		System.out.println(sql);
		System.out.println(bookVO);
//		sql = "(" + bookVO.getBk_isbn() + "," + bookVO.getBk_title();
		
		
		// String type�� SQL ��ɹ��� Oracle�� �����ϱ� ���� Packet�� �����
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, bookVO.getBk_isbn());
			pStr.setString(2, bookVO.getBk_title());
			pStr.setString(3, bookVO.getBk_ccode());
			pStr.setString(4, bookVO.getBk_acode());
			pStr.setString(5, bookVO.getBk_date());
			pStr.setInt(6, bookVO.getBk_price());
			pStr.setInt(7, bookVO.getBk_pages());
			pStr.executeUpdate();
			//pStr.executeUpdate();�� �ϸ� ������Ʈ�� ����ȴ�. DB�� �ݿ���Ű�� �뵵
			pStr.close();
			System.out.println("Insert OK!!");
			//sql�� ���� �� ������� values�� ?�� ���ʴ�� ���� �Ѵ�.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<BookDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookDTO findByID(String bk_isbn) {
		// TODO Auto-generated method stub
		
		String sql = " SELECT * FROM view_�������� ";
		sql += "WHERE ISBN = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, bk_isbn.trim());
			ResultSet result = pStr.executeQuery();
			
			if(result.next()) {
				BookDTO bookDTO = new BookDTO();
				bookDTO.setBk_isbn(result.getString("ISBN"));
				bookDTO.setBk_title(result.getString("������"));
				bookDTO.setBk_cname(result.getString("���ǻ��"));
				bookDTO.setBk_author(result.getString("���ڸ�"));
				bookDTO.setBk_cceo(result.getString("���ǻ��ǥ"));
				bookDTO.setBk_au_tel(result.getString("���ڿ���ó"));
				return bookDTO;
			} else {
				return null;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<BookDTO> findByTitle(String bk_title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BookVO bookVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String bk_isbn) {
		// TODO Auto-generated method stub
		
	}

}
