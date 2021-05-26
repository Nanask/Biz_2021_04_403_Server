package com.callor.todo.service;

import java.util.List;
import java.util.Map;

public interface TodoService {
	
	// VO class를 만드는 대신에 Map을 대신 사용하여 만들었음
	// 과거에는 이렇게 주로 만들었는데 VO와는 장단점이 다르다
	
	public List<Map<String,Object>> selectAll();
	public Map<String,Object> findById(Long seq);
	
	public Integer insert(Map<String,Object> vo);
	public Integer update(Map<String,Object> vo);
	public Integer delete(Long seq);
	

}
