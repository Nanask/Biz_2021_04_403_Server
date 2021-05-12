package com.callor.diet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * VOŬ������ Insert, Update�� �����Ҷ�
 * �����(web)�� �Է���(���޹���) ���� ���� ��ü
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MyFoodVO {
	
	private Long my_seq;//	number
	private String my_date;//	varchar2(10 byte)
	private String my_pcode;//	char(7 byte)
	private Float my_amt;//	number(10,2)
}
