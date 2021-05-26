package com.Nanask.school.service;

import java.util.List;

import com.Nanask.school.model.SchoolVO;

public interface SchoolService {
	
	public List<SchoolVO> selectAll();
	public SchoolVO findById(String st_num);
	public List<SchoolVO> findByName(String st_name);
	
	public Integer insert();
	public Integer update();
	public Integer delete();

}
