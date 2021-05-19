package com.callor.diet.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.diet.config.DBContract;
import com.callor.diet.config.DBInfo;
import com.callor.diet.model.MyFoodDTO;
import com.callor.diet.model.MyFoodVO;
import com.callor.diet.service.MyFoodService;

public class MyFoodServiceImplV1 implements MyFoodService {

	protected Connection dbConn;

	public MyFoodServiceImplV1() {
		dbConn = DBContract.getDBConnection();

	}

	public List<MyFoodDTO> select(PreparedStatement pStr) throws SQLException {

		List<MyFoodDTO> mfList = new ArrayList<MyFoodDTO>();

		ResultSet rSet = pStr.executeQuery();
		while (rSet.next()) {
			MyFoodDTO dto = new MyFoodDTO();

			dto.setMf_seq(rSet.getLong(DBInfo.�����������.mf_seq));
			dto.setMf_date(rSet.getString(DBInfo.�����������.mf_date)); // = ��������";
			dto.setMf_pcode(rSet.getString(DBInfo.�����������.mf_fcode)); // =��ǰ�ڵ�";
			dto.setMf_name(rSet.getString(DBInfo.�����������.mf_fname)); // =��ǰ��";
			dto.setMf_amt(rSet.getInt(DBInfo.�����������.mf_amt)); // =���뷮";
			dto.setMf_one(rSet.getInt(DBInfo.�����������.mf_one)); // =������";
			dto.setMf_capa(rSet.getInt(DBInfo.�����������.mf_capa)); // =�ѳ��뷮";
			dto.setMf_cal(rSet.getInt(DBInfo.�����������.mf_cal)); // =������";
			dto.setMf_protein(rSet.getInt(DBInfo.�����������.mf_protein)); // =�ܹ���";
			dto.setMf_fat(rSet.getInt(DBInfo.�����������.mf_fat)); // =����";
			dto.setMf_carvo(rSet.getInt(DBInfo.�����������.mf_carbo)); // =ź��ȭ��";
			dto.setMf_sugar(rSet.getInt(DBInfo.�����������.mf_sugar)); // =�Ѵ��";
			
			mfList.add(dto);

		}

		return mfList;

	}

	@Override
	public List<MyFoodDTO> selectAll() {
		// TODO ��ü ��ǰ���� ����Ʈ
		String sql = " SELECT * FROM view_���뷮��� ";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			List<MyFoodDTO> myList = this.select(pStr);
			pStr.close();
			return myList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public MyFoodDTO findById(Long seq) {
		// TODO ��ü ��ǰ���� ����Ʈ
		String sql = " SELECT * FROM view_���뷮��� ";
		sql += " WHERE �Ϸù�ȣ = ? ";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, seq);
			List<MyFoodDTO> myList = this.select(pStr);
			pStr.close();
			if(myList != null && myList.size() > 0) {
				return myList.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public MyFoodDTO findByName(String mf_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyFoodDTO> findByDate(String mf_date) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM view_���뷮��� ";
		sql += " WHERE �������� = ? ";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, mf_date);
			List<MyFoodDTO> myList = this.select(pStr);
			pStr.close();
			pStr.close();
	         if(myList != null && myList.size() > 0 ) {
	            return myList;  
	         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Integer insert(MyFoodVO myFoodVO) {
		// TODO Auto-generated method stub

		String sql = " INSERT INTO tbl_myfoods (";
		sql += "my_seq,";
		sql += "my_date,";
		sql += "my_pdcode,";
		sql += "my_eat)";
		sql += " VALUES(";
		sql += "seq_myfoods.NEXTVAL,";
		sql += "?,";
		sql += "?,";
		sql += "? )";
		System.out.println(sql);
		System.out.println(myFoodVO.toString());

		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, myFoodVO.getMf_date());
			pStr.setString(2, myFoodVO.getMf_pcode());
			pStr.setInt(3, myFoodVO.getMf_amt());
			
			// set�� �� ���� �Ѿ���°� �ƴ϶� �ٸ����� �Ѿ���µ� �װ� ����? �װ� �˷��� DB�� ���������....................................
			// insert�� �����ϸ�! ������� 0 �̻����� �Ѿ�´�? �׷��� ������ integer�� �޴´�.
			Integer result = pStr.executeUpdate();
			pStr.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Integer update(MyFoodVO myFoodVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Long seq) {
		// TODO Auto-generated method stub
		return null;
	}

}
