package com.callor.diet.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.diet.config.DBContract;
import com.callor.diet.config.DBInfo;
import com.callor.diet.config.DBInfo.FOOD;
import com.callor.diet.model.FoodDTO;
import com.callor.diet.model.FoodVO;
import com.callor.diet.service.FoodService;

public class FoodServiceImplV1 implements FoodService {

	protected Connection dbConn;
	
	public FoodServiceImplV1() {
		// dbConn�� ����� �غ� �ϴ� �ڵ�
		dbConn = DBContract.getDBConnection();
	}
	// DBMS�� SQL�� ������ ����� �޾Ƽ� List �����ͷ� ����� �ִ� �Լ�
	protected List<FoodDTO> select(PreparedStatement pStr) throws SQLException {
		
		ResultSet rSet =pStr.executeQuery();
		
		List<FoodDTO> foodList = new ArrayList<FoodDTO>();
		
		//DBMS���� ���� �����Ͱ� ������
		while(rSet.next()) {
			
			FoodDTO dto = new FoodDTO();
			
			dto.setCp_addr(null);
			
			dto.setFd_code	(rSet.getString(DBInfo.FOOD.fd_code));
			dto.setFd_name	(rSet.getString(DBInfo.FOOD.fd_name));
			dto.setFd_year	(rSet.getString(DBInfo.FOOD.fd_year));
			dto.setFd_ccode	(rSet.getString(DBInfo.FOOD.fd_ccode));
			dto.setFd_icode	(rSet.getString(DBInfo.FOOD.fd_icode));
			dto.setFd_one	(rSet.getInt(DBInfo.FOOD.fd_one));
			dto.setFd_capa	(rSet.getInt(DBInfo.FOOD.fd_capa));
			dto.setFd_cal	(rSet.getInt(DBInfo.FOOD.fd_cal));
			dto.setFd_protein	(rSet.getInt(DBInfo.FOOD.fd_protein));
			dto.setFd_fat	(rSet.getInt(DBInfo.FOOD.fd_fat));
			dto.setFd_carbo	(rSet.getInt(DBInfo.FOOD.fd_carbo));
			dto.setFd_sugar	(rSet.getInt(DBInfo.FOOD.fd_sugar));
			
			dto.setCp_cname	(rSet.getString(DBInfo.FOOD.cp_cname));
			dto.setCp_ceo	(rSet.getString(DBInfo.FOOD.cp_ceo));
			dto.setCp_tel	(rSet.getString(DBInfo.FOOD.cp_tel));
			dto.setCp_addr	(rSet.getString(DBInfo.FOOD.cp_addr));
			dto.setCp_item	(rSet.getString(DBInfo.FOOD.cp_item));
			dto.setIt_group	(rSet.getString(DBInfo.FOOD.it_group));
			foodList.add(dto);

			
			
		}
		return foodList;
	}
	
	
	@Override
	public List<FoodDTO> selectALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodDTO findById(String fd_code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodDTO> findByName(String fd_name) {
		// TODO ��ǰ������ �˻��ϱ�
		
		String sql = "SELECT * FROM view_��ǰ����";
		sql += " WHERE ��ǰ�� LIKE '%' || ? || '%' ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, fd_name.trim());
			List<FoodDTO> foodList = this.select(pStr);
			pStr.close();
			return foodList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer insert(FoodVO foodVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(FoodVO foodVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(String fd_code) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
