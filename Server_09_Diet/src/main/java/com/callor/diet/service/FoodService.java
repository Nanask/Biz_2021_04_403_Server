package com.callor.diet.service;

import java.util.List;

import com.callor.diet.model.FoodDTO;
import com.callor.diet.model.FoodVO;

public interface FoodService {
	
	// CRUD�� ������ method ����(����)
	
	// ������ ��ȸ(read)
	public List<FoodDTO> selectALL(); //��� ������ ��ȸ
	public FoodDTO findById(String fd_code); // PK�� ��ȸ�ϴ� �޼���
	public List<FoodDTO> findByName(String fd_name); // �̸����� ��ȸ
	
	// ������ ��ȯ(�߰�, ����, ����)
	public Integer insert(FoodVO foodVO);
	public Integer update(FoodVO foodVO);
	public Integer delete(String fd_code);

}
