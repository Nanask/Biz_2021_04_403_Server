package com.callor.book.model;

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

public class BookDTO {
	
	private String bk_isbn;//ISBN	CHAR(13)
	private String bk_title;//������	NVARCHAR2(125)
	private String bk_cceo;//���ǻ��	NVARCHAR2(125)
	private String bk_cname;//���ǻ��ǥ	NVARCHAR2(20)
	private String bk_auname;//���ڸ�	NVARCHAR2(50)
	private String bk_autel;//���ڿ���ó	NVARCHAR2(20)
	private String bk_date;//������	VARCHAR2(10)
	private Integer bk_price;//����	NUMBER
	private Integer bk_pages;//������	NUMBER

}
