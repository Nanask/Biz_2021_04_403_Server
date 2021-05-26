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
	
	private String st_num; // �й�
	private String st_name; // �л��̸�
	private String st_tel; // �л���ȭ��ȣ
	private String st_addr; // �ּ�
	private int st_grade; // �г�
	private String st_dpcode; // �а��ڵ�
	private String st_dname; // �а���
	private String st_dpro; // ���ӱ���
	private String dp_code; // �а��ڵ�
	private String dp_name; // �а���
	private String dp_pro; // ��������
	private Long sc_seq; // SEQ
	private String sc_stnum; // �й�
	private String sc_sbname; // �����
	private float sc_score; // ����


}
