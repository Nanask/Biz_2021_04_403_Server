package com.callor.guest.service;

import java.util.List;

import com.callor.guest.model.GuestBookVO;

/*
 * tbl_guest_book table의 CRUD를 선언하기
 */

public interface GuestBookService {
	
	public List<GuestBookVO> selectAll();
	
	//PK로 검색하는 것이기 때문에 seq를 매개변수로 받는다.
	public GuestBookVO findById(Long seq);
	
	public List<GuestBookVO> findByWriter(String gb_writer);
	public List<GuestBookVO> findByDate(String gb_date);
	public List<GuestBookVO> findByContent(String gb_text);
	
	public Integer insert(GuestBookVO gbVO);
	public Integer update(GuestBookVO gbVO);
	public Integer delete(Long seq);
	
	
	

}
