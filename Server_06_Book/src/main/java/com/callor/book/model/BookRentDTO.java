package com.callor.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * �ֹ���ȣ, NUMBER, br_seq
 * ȸ���ڵ�	CHAR(5), br_bcode
 * ȸ����	NVARCHAR2(50), br_bname
 * ȸ������ó	VARCHAR2(20), br_tel
 * ISBN	CHAR(13), br_isbn
 * ������	NVARCHAR2(125), br_title
 * �ݳ���	VARCHAR2(10), br_edate
 * �뿩��	NUMBER, br_price
 * �뿩��	VARCHAR2(10), br_sdate
 */

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor

/*
 * ��ȸ�Ҷ�(SELECT) Service �� method�� return �� type
 */
public class BookRentDTO {
	
	 Long br_seq = 0L;
	 String br_bcode;
	 String br_bname;
	 String br_tel;
	 String br_isbn;
	 String br_title;
	 String br_edate;
	 Integer br_price = 0;
	 String br_sdate;
}
