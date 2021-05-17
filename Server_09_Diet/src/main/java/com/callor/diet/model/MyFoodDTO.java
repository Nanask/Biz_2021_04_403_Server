package com.callor.diet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/*
 * DTO(Data Transfer Object)
 * DB로부터 SELECT 데이터를 출력하는 곳으로
 * 옮길때 사용할 객체
 * 
 * VO나 DTO는 DB와 관련된 데이터를 옮길때 사용하는 객체
 * 대부분의 역할이 유사하지만 특별히 구분을 하는 이유는 한개의 Table에 대하여 다양한 view를 사용할때
 * 여러개의 VO나 DTO를 만들면서 이름을 짓는 것이 번거로워서 구분을 한다.
 * 
 * MyFoodVO : Insert, Update용
 * MyFoodDTO : SELECT 용
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MyFoodDTO {
	
	private Long mf_seq;
	private String mf_date; // = 섭취일자";
	private String mf_pcode; //=식품코드";
	private String mf_name; //=식품명";
	private int mf_amt; //=섭취량";
	private int mf_one; //=제공량";
	private int mf_capa; //=총내용량";
	private int mf_cal; //=에너지";
	private int mf_protein; //=단백질";
	private int mf_fat; //=지방";
	private int mf_carvo; //=탄수화물";
	private int mf_sugar; //=총당류";

}
