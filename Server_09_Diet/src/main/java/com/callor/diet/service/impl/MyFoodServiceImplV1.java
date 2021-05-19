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

			dto.setMf_seq(rSet.getLong(DBInfo.섭취정보계산.mf_seq));
			dto.setMf_date(rSet.getString(DBInfo.섭취정보계산.mf_date)); // = 섭취일자";
			dto.setMf_pcode(rSet.getString(DBInfo.섭취정보계산.mf_fcode)); // =식품코드";
			dto.setMf_name(rSet.getString(DBInfo.섭취정보계산.mf_fname)); // =식품명";
			dto.setMf_amt(rSet.getInt(DBInfo.섭취정보계산.mf_amt)); // =섭취량";
			dto.setMf_one(rSet.getInt(DBInfo.섭취정보계산.mf_one)); // =제공량";
			dto.setMf_capa(rSet.getInt(DBInfo.섭취정보계산.mf_capa)); // =총내용량";
			dto.setMf_cal(rSet.getInt(DBInfo.섭취정보계산.mf_cal)); // =에너지";
			dto.setMf_protein(rSet.getInt(DBInfo.섭취정보계산.mf_protein)); // =단백질";
			dto.setMf_fat(rSet.getInt(DBInfo.섭취정보계산.mf_fat)); // =지방";
			dto.setMf_carvo(rSet.getInt(DBInfo.섭취정보계산.mf_carbo)); // =탄수화물";
			dto.setMf_sugar(rSet.getInt(DBInfo.섭취정보계산.mf_sugar)); // =총당류";
			
			mfList.add(dto);

		}

		return mfList;

	}

	@Override
	public List<MyFoodDTO> selectAll() {
		// TODO 전체 식품섭취 리스트
		String sql = " SELECT * FROM view_섭취량계산 ";

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
		// TODO 전체 식품섭취 리스트
		String sql = " SELECT * FROM view_섭취량계산 ";
		sql += " WHERE 일련번호 = ? ";

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
		String sql = " SELECT * FROM view_섭취량계산 ";
		sql += " WHERE 섭취일자 = ? ";

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
			
			// set을 한 값이 넘어오는게 아니라 다른값이 넘어오는데 그게 뭐죠? 그거 알려면 DB에 물어봐야함....................................
			// insert가 성공하면! 결과값이 0 이상으로 넘어온다? 그렇기 때문에 integer로 받는다.
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
