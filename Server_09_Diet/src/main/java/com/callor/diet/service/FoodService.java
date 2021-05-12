package com.callor.diet.service;

import java.util.List;

import com.callor.diet.model.FoodDTO;
import com.callor.diet.model.FoodVO;

public interface FoodService {
	
	// CRUD를 구현할 method 정의(설계)
	
	// 데이터 조회(read)
	public List<FoodDTO> selectALL(); //모든 데이터 조회
	public FoodDTO findById(String fd_code); // PK로 조회하는 메서드
	public List<FoodDTO> findByName(String fd_name); // 이름으로 조회
	
	// 데이터 변환(추가, 수정, 삭제)
	public Integer insert(FoodVO foodVO);
	public Integer update(FoodVO foodVO);
	public Integer delete(String fd_code);

}
