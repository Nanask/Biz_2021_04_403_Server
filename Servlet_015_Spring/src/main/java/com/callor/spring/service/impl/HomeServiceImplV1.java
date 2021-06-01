package com.callor.spring.service.impl;

import org.springframework.stereotype.Service;

import com.callor.spring.model.MyVO;
import com.callor.spring.service.HomeService;

@Service
public class HomeServiceImplV1 implements HomeService{

	@Override
	public MyVO findById() {
		// TODO Auto-generated method stub
		
		MyVO vo = new MyVO();
		vo.setT_name("ȫ�浿");
		vo.setT_tel("010-222-2122");
		vo.setT_age("10");
		return vo;
	}

}
