package com.callor.diet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/*
 * DTO(Data Transfer Object)
 * DB�κ��� SELECT �����͸� ����ϴ� ������
 * �ű涧 ����� ��ü
 * 
 * VO�� DTO�� DB�� ���õ� �����͸� �ű涧 ����ϴ� ��ü
 * ��κ��� ������ ���������� Ư���� ������ �ϴ� ������ �Ѱ��� Table�� ���Ͽ� �پ��� view�� ����Ҷ�
 * �������� VO�� DTO�� ����鼭 �̸��� ���� ���� ���ŷο��� ������ �Ѵ�.
 * 
 * MyFoodVO : Insert, Update��
 * MyFoodDTO : SELECT ��
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MyFoodDTO {
	
	private Long mf_seq;
	private String mf_date; // = ��������";
	private String mf_pcode; //=��ǰ�ڵ�";
	private String mf_name; //=��ǰ��";
	private int mf_amt; //=���뷮";
	private int mf_one; //=������";
	private int mf_capa; //=�ѳ��뷮";
	private int mf_cal; //=������";
	private int mf_protein; //=�ܹ���";
	private int mf_fat; //=����";
	private int mf_carvo; //=ź��ȭ��";
	private int mf_sugar; //=�Ѵ��";

}
