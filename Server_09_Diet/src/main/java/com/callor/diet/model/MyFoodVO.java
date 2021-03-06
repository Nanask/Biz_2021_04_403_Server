package com.callor.diet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * VO클래스는 Insert, Update를 수행할때
 * 사용자(web)가 입력한(전달받은) 값을 담을 객체
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MyFoodVO {
	
	private Long mf_seq;//	number
	private String mf_date;//	varchar2(10 byte)
	private String mf_pcode;//	char(7 byte)
	private Integer mf_amt;//	number(10,2)
}
