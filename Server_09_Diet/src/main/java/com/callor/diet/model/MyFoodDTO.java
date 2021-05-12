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
	
	private String mf_date; // = ��������";
	private String mf_pcode; //=��ǰ�ڵ�";
	private String mf_name; //=��ǰ��";
	private Float mf_amt; //=���뷮";
	private Float mf_once; //=������";
	private Float mf_capa; //=�ѳ��뷮";
	private Float mf_cal; //=������";
	private Float mf_protein; //=�ܹ���";
	private Float mf_fat; //=����";
	private Float mf_carvo; //=ź��ȭ��";
	private Float mf_sugar; //=�Ѵ��";

}
