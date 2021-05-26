package com.Nanask.school.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Nanask.school.config.DBInfo;
import com.Nanask.school.config.MySQLConnect;
import com.Nanask.school.model.SchoolVO;
import com.Nanask.school.service.SchoolService;

public class SchoolServiceImplV1 implements SchoolService{
	
	protected Connection dbConn;
	
	public SchoolServiceImplV1() {
		
		dbConn = MySQLConnect.getDBConnection();
	}
	
	protected List<SchoolVO> select(PreparedStatement pStr) throws SQLException {
		
	
		List<SchoolVO> schoolList = new ArrayList<SchoolVO>();
		ResultSet rSet = pStr.executeQuery();
		
		while(rSet.next()) {
			
			SchoolVO sVO = new SchoolVO();
			
			sVO.setSt_num(rSet.getString("st_num"));
			sVO.setSt_name(rSet.getString("st_name"));
			sVO.setSt_tel(rSet.getString("st_tel"));
			sVO.setSt_addr(rSet.getString("st_addr"));
			sVO.setSt_grade(rSet.getInt("st_grade"));
			sVO.setSt_dpcode(rSet.getString("st_dpcode"));
			sVO.setSt_dname(rSet.getString("st_dname"));
			sVO.setSt_dpro(rSet.getString("st_dpro"));
			sVO.setDp_code(rSet.getString("dp_code"));
			sVO.setDp_name(rSet.getString("dp_name"));
			sVO.setDp_pro(rSet.getString("dp_pro"));
			sVO.setSc_stnum(rSet.getString("sc_stnum"));
			sVO.setSc_sbname(rSet.getString("sc_sbname"));
			sVO.setSc_score(rSet.getFloat("sc_score"));
			
			schoolList.add(sVO);
			
		}
		System.out.println(schoolList.toString());
		return schoolList;
	}
	

	@Override
	public List<SchoolVO> selectAll() {
		// TODO 전체조회
		
		String sql = " SELECT * FROM tbl_student ";
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			List<SchoolVO> schoolList = this.select(pStr);
			pStr.close();
			return schoolList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public SchoolVO findById(String st_num) {
		// TODO 학번으로 검색하기
		String sql = " SELECT * FROM tbl_student ";
		sql += " WHERE st_num = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, st_num);
			List<SchoolVO> schoolList = this.select(pStr);
			if(schoolList != null && schoolList.size() > 0) {
				return schoolList.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<SchoolVO> findByName(String st_name) {
		// TODO 이름으로 정보 찾기
		
		String sql = " SELECT * FROM tbl_student ";
		sql += " WHERE st_name LIKE '%' || ? || '%' ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, st_name);
			List<SchoolVO> schoolList = this.select(pStr);
			pStr.close();
			return schoolList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer insert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete() {
		// TODO Auto-generated method stub
		return null;
	}

}
