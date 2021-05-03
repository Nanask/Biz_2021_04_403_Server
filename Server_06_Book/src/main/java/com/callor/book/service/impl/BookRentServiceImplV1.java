package com.callor.book.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.book.model.BookRentDTO;
import com.callor.book.model.BookRentVO;
import com.callor.book.persistence.DBContract;
import com.callor.book.service.BookRentService;

public class BookRentServiceImplV1 implements BookRentService{
	
	protected Connection dbConn;
	   public BookRentServiceImplV1() {
	      dbConn = DBContract.getDBConnection();
	   }
	   
	   /*
	    * ecception ó�� ��� 2����
	    * 1. try-catch�� ����ϱ�
	    * 		exception�� �߻��� �ڵ带 ���μ� "����" exception�� ó���ϱ�
	    * 
	    * 2. ���ѱ��(������)
	    * 		method throws�� �߰��Ͽ� ȣ���� method���� exception�� �ǵ��� ������
	    * 		���� method���� ���� exception�� ó���ϴ� �ڵ尡 ��� �ڵ尡 �ټ� ����ȭ �ȴ�.
	    * 
	    * 		ȣ���� ������ ��� exception�� ó���Ѵ�
	    */
	   
	   // 
	   protected List<BookRentDTO> select(PreparedStatement pStr) throws SQLException {
		   List<BookRentDTO> brList = new ArrayList<BookRentDTO>();
		   
		   ResultSet rStr = pStr.executeQuery();
		   while(rStr.next()) {
			   
			   BookRentDTO brDTO = new BookRentDTO();
			   brDTO.setBr_seq(rStr.getLong("�ֹ���ȣ"));
			   brDTO.setBr_sdate(rStr.getString("�뿩��"));
			   
			   brDTO.setBr_bcode(rStr.getString("ȸ���ڵ�"));
			   brDTO.setBr_bname(rStr.getString("ȸ����"));
			   brDTO.setBr_tel(rStr.getString("ȸ������ó"));
			   
			   brDTO.setBr_isbn(rStr.getString("ISBN"));
			   brDTO.setBr_title(rStr.getString("������"));
			   
			   brDTO.setBr_price(rStr.getInt("�뿩��"));
			   brDTO.setBr_edate(rStr.getString("�ݳ���"));
			   
			   brList.add(brDTO);
		   }
		   return brList;
	   }
	

	@Override
	public List<BookRentDTO> selectAll() {
		// TODO ��ü����Ʈ
		
		String sql = "SELECT * FROM view_�����뿩����";
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			
			//�޼��带 �з������ ������ �ʿ���� �κ��� ��
//			ResultSet rSet = pStr.executeQuery();
//			
//			List<BookRentDTO> brList = new ArrayList<BookRentDTO>();
//			
//			while(rSet.next()) {
//				//ResultSet�� ��� �����͸� List�� �Űܴ��
//			}
			List<BookRentDTO> brList = this.select(pStr);
			pStr.close();
			return brList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BookRentDTO findById(long seq) {
		// TODO PK�� ��ȸ�ϱ�
		
		
		/*
		 * DB Injection ���ݿ� ���Ǵ� �ſ� ����� �ڵ�
		 * ���� �Ű������� ���� SQL ��ɹ��� ������ ���� �����
		 * "WHERE ������ = " + title;
		 * title �������� " 1 OR 1 = 1 �� ���� ���ڿ��� ��Ƽ� ������
		 * ���� ������ 
		 * WHERE ������ 1 or = 1 �� ���� ������� ������.
		 * 
		 * Prepare... �� ����Ҷ��� ���ǹ��� ������ ���Ե� ��ġ�� ? ��ȣ�� ����Ѵ�.
		 * WHERE ������ = ? �� ���� ����Ѵ�.
		 *  
		 */
		
		String sql = " SELECT * FROM view_�����뿩����";
		sql += " WHERE �ֹ���ȣ = ? ";
		
		PreparedStatement pStr = null;
		try {
			// �Ʒ��� 2�� �ڵ忡 ���ؼ� WHERE �ֹ���ȣ = �� ������ SQL�� ���������.
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, seq);
			
//			ResultSet rSet = pStr.executeQuery();
//			if(rSet.next()) {
//				// VO�� ���
//			}
//			rSet.close();
			
			// PK�� ��ȸ�� �߱� ������ List���� 1���ۿ� �����Ͱ� ����
			// list�� 0�� �����͸� getter�Ͽ� DTO�� ��´�
			BookRentDTO brDTO = this.select(pStr).get(0);
			pStr.close();
			return brDTO;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<BookRentDTO> findByBISBN(String isbn) {
		// TODO ISBN���� ��ȸ
		String sql = " SELECT * FROM view_�����뿩���� ";
		sql += " WHERE ISBN = ?";
		
		PreparedStatement pStr = null; 
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, isbn);
			
			List<BookRentDTO> brList = this.select(pStr);
			pStr.close();
			return brList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<BookRentDTO> findByBookName(String name) {
		// TODO ���������� ��ȸ
		String sql = " SELECT * FROM view_�����뿩���� ";
		sql += " WHERE ������ LIKE '%' || ? || '%' ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, name);
			List<BookRentDTO> brList = this.select(pStr);
			pStr.close();
			return brList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<BookRentDTO> findByBuyerCode(String bCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookRentDTO> findByBuyerName(String bName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookRentDTO> findByOverDue(String eDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookRentDTO> findByTerm(String sDate, String eDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BookRentVO bookRentVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BookRentVO bookRentVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long seq) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
