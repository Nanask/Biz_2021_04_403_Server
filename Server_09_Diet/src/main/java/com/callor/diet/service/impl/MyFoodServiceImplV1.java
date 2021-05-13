package com.callor.diet.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.callor.diet.config.DBContract;
import com.callor.diet.model.MyFoodDTO;
import com.callor.diet.model.MyFoodVO;
import com.callor.diet.service.MyFoodService;

public class MyFoodServiceImplV1 implements MyFoodService{

	protected Connection dbConn;
	
	public MyFoodServiceImplV1() {
		dbConn = DBContract.getDBConnection();
	}
	
	@Override
	public List<MyFoodDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyFoodDTO findById(Long seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyFoodDTO findByName(String mf_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyFoodDTO findByDate(String mf_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(MyFoodVO myFoodVO) {
		// TODO Auto-generated method stub
		
		String sql = " INSERT INTO tbl_myfoods ";
		sql +="my_seq";
		sql +="my_date";
		sql +="my_pcode";
		sql +="my_amt)";
		sql +=" VALUES(";
		sql += "seq_myfoods.NEXTVAL,";
		sql +="?,";
		sql +="?,";
		sql +="? )";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, myFoodVO.getMy_pcode());
			pStr.setString(2, myFoodVO.getMy_date());
			pStr.setFloat(3, myFoodVO.getMy_amt());
			//여기 작성해야함
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
