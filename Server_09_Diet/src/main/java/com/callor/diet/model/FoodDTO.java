package com.callor.diet.model;

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

public class FoodDTO {
	
	private String fd_code; //	��ǰ�ڵ�
	private String fd_name; //	��ǰ��
	private String fd_year; //	��ÿ���
	private String fd_ccode; //	�������ڵ�
	private String fd_icode; //	�з��ڵ�
	
	private Integer fd_one; //	������
	private Integer fd_capa; //	�ѳ��뷮
	private Integer fd_cal; //	������
	private Integer fd_protein; //	�ܹ���
	private Integer fd_fat; //	����
	private Integer fd_carbo; //	ź��ȭ��
	private Integer fd_sugar; //	�Ѵ��
	private String cp_cname; //	�������
	private String cp_ceo; //	��ǥ
	private String cp_tel; //	��ǥ��ȭ
	private String cp_addr; //	�ּ�
	private String cp_item; //	�ֿ�ǰ��
	private String it_group; //	�з���


}
