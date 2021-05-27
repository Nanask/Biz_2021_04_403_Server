package com.callor.todo.service.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.callor.todo.config.DBContract;
import com.callor.todo.config.DBInfo;
import com.callor.todo.service.TodoService;

public class TodoServiceImplV1 implements TodoService {

	protected Connection dbConn;

	public TodoServiceImplV1() {
		dbConn = DBContract.getDbConn();
	}
	/*
	 * ��ü(Entity,�����̼�) DataBase�� ����� Table�� ������ �� Insert�� �����ϸ� ������Ȳ�� �����Ͱ� Table��
	 * ����ȴ�. Insert�� ������ �� Select�� �����Ͽ� ��ȸ�� �� �� �ִ� �����͵�
	 * 
	 * ��Ÿ������ ������ Database, table, sequence, view ... �� � ������ ������� �ִ°� ���� ������
	 * ��Ÿ�����Ͷ�� �Ѵ�. ��) MyDB��� Database�� ��� table�� �ִ°� ���� ������ �˰� ������ myDB ��Ÿ�����͸� �����ϸ�
	 * �ȴ�.
	 * 
	 * 
	 */

	protected List<Map<String, Object>> select(ResultSet rSet) throws SQLException {
	      
	      // ResultSet���� ��Ÿ�����͸� �����Ͽ� SELECT�� ����� ���޹��� Table(tbl_todolist)�� �� ���� Į���� �ִ� �� Ȯ��
	      ResultSetMetaData md = rSet.getMetaData(); // (add throws)
	      int colums = md.getColumnCount();
	      
	      List<Map<String, Object>> tdList = new ArrayList<Map<String, Object>>();
	      
	      // rSet(SELECT�� ������)�� �� ���ξ� �����ϰ� 
	      while(rSet.next()) {
	         
	         Map<String, Object> tdVO = new HashMap<String, Object>();
	         
	         // �� �������� Į���� index�� �������� ���� �����غ���
	         for(int i = 0; i < colums; i++) {
	            // ��Ÿ�������� index ��ġ�� Į�� �̸� ��������
	            String colName = md.getColumnName(i + 1);
	            // ResultSet�� index ��ġ�� ���� ������ ��������
	            Object objData = rSet.getObject(i + 1);
	            // Į�������͸� VO�� pull
	            tdVO.put(colName, objData);
	         }
	         tdList.add(tdVO);
	      }
	      return tdList;
	   }

	@Override
	public List<Map<String, Object>> selectAll() {
		// TODO ��ü ��� ��������

		String sql = " SELECT * FROM tbl_todolist ";
		sql += " ORDER BY td_edate, td_sdate, td_stime ";

		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			ResultSet rSet = pStr.executeQuery();

			List<Map<String, Object>> tdList = this.select(rSet);
			rSet.close();
			pStr.close();
			return tdList;

			/*
			 * ResultSetMetaData md = rSet.getMetaData(); int count = md.getColumnCount();
			 * 
			 * System.out.println("=".repeat(80)); for(int i = 0; i < count; i++) {
			 * System.out.print(md.getColumnName(i + 1) + "\t"); } System.out.println();
			 * System.out.println("=".repeat(80));
			 * 
			 * 
			 * while(rSet.next()) { // System.out.print(rSet.getString("td_sdate" + "\t"));
			 * // System.out.print(rSet.getString("td_stime" + "\t")); //
			 * System.out.print(rSet.getString("td_doit" + "\n"));
			 * 
			 * for(int i = 0; i < count; i++) { System.out.print(rSet.getString(i + 1) +
			 * "\t"); } System.out.println(); }
			 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	

	@Override
	public Map<String, Object> findById(Long td_seq) {
		// TODO seq�� ã��
		
		String sql = "SELECT * FROM tbl_todolist ";
		sql += " WHERE td_seq = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, td_seq);
			ResultSet rSet = pStr.executeQuery();
			List<Map<String,Object>> tdList = this.select(rSet);
			if(tdList != null && tdList.size() > 0) {
				return tdList.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> findBySDate(String td_sdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> findByDoit(String td_doit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(Map<String, Object> tdVO) {
		// TODO TodoList ����ϱ�

		// ȣȯ���� ���� ���
		// ���糯¥ ��������
		Date date = new Date(System.currentTimeMillis());

		// ��¥�� ���ڿ� �ϱ� ���� ���� Ŭ����
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");

		String curDate = sd.format(date);
		String curTime = st.format(date);

		// tdVO�� 2���� Į���� �����ϰ� �����͸� �߰�
		tdVO.put(DBInfo.td_sdate, curDate);
		tdVO.put(DBInfo.td_stime, curTime);

		String sql = " INSERT INTO tbl_todolist (";
//		td_seq,";  
//		td_edate,";
//		td_etime,";		
		sql += " td_sdate, ";
		sql += " td_stime, ";
		sql += " td_doit ) ";

		sql += " VALUES(?,?,?) ";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setObject(1, tdVO.get(DBInfo.td_sdate));
			pStr.setObject(2, tdVO.get(DBInfo.td_stime));
			pStr.setObject(3, tdVO.get(DBInfo.td_doit));

			Integer ret = pStr.executeUpdate();
			pStr.close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Integer update(Map<String, Object> tdVO) {
		// TODO ���� �� �߰��ϱ�?
		
		String sql = " UPDATE tbl_todolist SET ";
		
		sql += " td_sdate= ?," ;
		sql += " td_stime= ?," ;
		sql +=" td_doit= ?," ;
		sql +=" td_edate= ?," ;
		sql +=" td_etime= ? " ;
		sql += " WHERE td_seq = ? " ;
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setObject(1, tdVO.get(DBInfo.td_sdate));
			pStr.setObject(2, tdVO.get(DBInfo.td_stime));
			pStr.setObject(3, tdVO.get(DBInfo.td_doit));
			pStr.setObject(4, tdVO.get(DBInfo.td_edate));
			pStr.setObject(5, tdVO.get(DBInfo.td_etime));
			pStr.setObject(6, tdVO.get(DBInfo.td_seq));
			
			Integer ret = pStr.executeUpdate();
			pStr.close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return null;
	}

	@Override
	public Integer deletd(Long td_seq) {
		// TODO Auto-generated method stub
		return null;
	}

}
