package com.Nanask.school.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class SchoolVO {
	
	private String st_num; // 학번
	private String st_name; // 학생이름
	private String st_tel; // 학생전화번호
	private String st_addr; // 주소
	private int st_grade; // 학년
	private String st_dpcode; // 학과코드
	private String st_dname; // 학과명
	private String st_dpro; // 주임교수
	private String dp_code; // 학과코드
	private String dp_name; // 학과명
	private String dp_pro; // 교과교수
	private Long sc_seq; // SEQ
	private String sc_stnum; // 학번
	private String sc_sbname; // 과목명
	private float sc_score; // 점수


}
