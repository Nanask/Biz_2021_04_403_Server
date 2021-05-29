package com.callor.todo.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.callor.todo.config.DBContract;
import com.callor.todo.config.DBInfo;
import com.callor.todo.service.TodoService;

public class TodoServiceImplV1 implements TodoService {
	protected static final Logger log = LoggerFactory.getLogger("TD Service");

	protected Connection dbConn;

	public TodoServiceImplV1() {
		// TODO Auto-generated constructor stub
		dbConn = DBContract.getDbConn();
	}

	protected List<Map<String, Object>> Select(ResultSet rSet) throws SQLException {

		// metaDate�� getter
		ResultSetMetaData md = rSet.getMetaData();

		// Select�� table�� Į�� ���� getter
		int columns = md.getColumnCount();

		// ������ List<VO> ������ ����
		// ResultSet�� ����ִ� table �����͸�
		// List<VO> �� ��ȯ
		List<Map<String, Object>> tdList = new ArrayList<Map<String, Object>>();

		while (rSet.next()) {

			Map<String, Object> tdVO = new HashMap<String, Object>();
			// Į�� ������ŭ �ݺ��� ����
			for (int index = 0; index < columns; index++) {

				// ��Ÿ�����Ϳ���
				// index ��ġ�� Į���� getter
				// index���� 1 ���� �����Ѵ�
				String colName = md.getColumnName(index + 1);

				// ResultSet���� ����
				// index ���� Į���� ����� ���� ������ getter
				Object objData = rSet.getObject(index + 1);

				// key:colName, value:objData ��
				// Map �����͸� tdVO�� �߰��ϱ�
				tdVO.put(colName, objData);

			} // end for

			// ����Ʈ�� VO �߰�
			tdList.add(tdVO);
		} // end while
		log.debug("TDLIST {}", tdList.toString());

		return tdList;
	}

	@Override
	public List<Map<String, Object>> selectAll() {
		// TODO ��ü������ Select
		String sql = " SELECT * FROM tbl_todolist ";

		// �Ϸ���� ����(td_edate���� ����) �����͸�
		// �켱 ���̰�
		// INSERT �� ������ ������
		// �̿Ϸ�� TODO�� ���� ��µǴ� ȿ��
		sql += " ORDER BY td_edate, td_sdate, td_stime ";
		log.debug("SQL : {}", sql);

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			ResultSet rSet = pStr.executeQuery();

			List<Map<String, Object>> tdList = this.Select(rSet);

			rSet.close();
			pStr.close();

			log.debug("SELECT Result: {}", tdList.toString());

			return tdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Map<String, Object> findById(Long seq) {
		// TODO seq�� ã��
		
		String sql = " SELECT * FROM tbl_todolist ";
		sql += " WHERE td_seq = ? ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setObject(1, seq);
			ResultSet rSet = pStr.executeQuery();
			
			List<Map<String,Object>> tdList = this.Select(rSet);
			
			rSet.close();
			pStr.close();
			
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
	public Integer insert(Map<String, Object> vo) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO tbl_todolist( ";
//		sql += "td_seq,";
		sql += "td_sdate,";
		sql += "td_stime,";
		sql += "td_doit )";
//		sql += "td_edate,";
//		sql += "td_etime,";
		sql += "VALUES(?,?,?) ";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setObject(1, vo.get("td_sdate"));
			pStr.setObject(2, vo.get("td_stime"));
			pStr.setObject(3, vo.get("td_doit"));
//			pStr.setObject(3, vo.get(DBInfo.td_doit));

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
	public Integer update(Map<String, Object> vo) {
		// TODO ����
		
		String sql = " UPDATE tbl_todolist SET ";
		// td_sdate = ?,
		sql += String.format(" %s = ?,", DBInfo.td_sdate );
		sql += String.format(" %s = ?,", DBInfo.td_stime);
		sql += String.format(" %s = ?,", DBInfo.td_doit);
		sql += String.format(" %s = ?,", DBInfo.td_edate );
		sql += String.format(" %s = ? ", DBInfo.td_etime);
		sql += String.format(" WHERE %s = ? ", DBInfo.td_seq );
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setObject(1, vo.get(DBInfo.td_sdate));
			pStr.setObject(2, vo.get(DBInfo.td_stime));
			pStr.setObject(3, vo.get(DBInfo.td_doit));
			pStr.setObject(4, vo.get(DBInfo.td_edate));
			pStr.setObject(5, vo.get(DBInfo.td_etime));
			pStr.setObject(6, vo.get(DBInfo.td_seq));
			
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
	public Integer delete(Long seq) {
		// TODO Auto-generated method stub
		return null;
	}
	// @SuppressWarnings("unused") ������� ���� �ڵ����� �ּ��� �Ʊ��ϱ�!! �̰Ŵ� �����Ҳ��ϱ� ���������!!
	@SuppressWarnings("unused")
	private void viewSelect(ResultSet rSet) throws SQLException {
		
		/*
		 * ResultSet���� DB�� ���� ���ŵ����Ϳ���
		 * ��Ÿ�����͸� Ȱ���Ͽ� List<VO>�� �� �����ϱ�
		 */
		// rSet���� ���� ��Ÿ������ ����(getter)
		ResultSetMetaData md = rSet.getMetaData();
		
		// Select �� table�� Į������ ����
		// 1. Į���� ��ΰ�
		int columns = md.getColumnCount();

		// 2. Į���� �̸����� �����϶�
		System.out.println("=".repeat(50));
		for(int i = 0 ; i < columns ; i++) {
			System.out.print(md.getColumnName( i+1 ) +"\t");
		}
		System.out.println("\n" + "-".repeat(50));
		
		/*
		 * rSet���� select table�� ����� ��� ����Ǿ� �ִ�
		 * ���������Ϳ� ��Ÿ�����Ͱ� ��� ���ԵǾ� �ִ�
		 * rSet��ü�� next() method�� �ѹ� ȣ���ϸ�
		 * 	��� table�� ù��° ���ڵ带 ���� �� �ֵ���
		 * 	�غ����ش�
		 * �̾ next() method�� ����ؼ� ȣ���ϸ�
		 * 	���پ� ������� ���� �� �ֵ��� �غ��� �ش�
		 * ���� ���̻� ���� �����Ͱ� ������ false return�Ѵ�
		 * while() �ݺ����� ����Ͽ� select �� �����͸�
		 * 	������� �����Ҽ� �ֵ��� �Ѵ�.
		 */
		while(rSet.next()) {
			for(int i = 0 ; i < columns ; i++) {
				System.out.print(rSet.getObject(i+1) + "\t");
			}
			System.out.println();
		}
		System.out.println("=".repeat(50));
	}
}


