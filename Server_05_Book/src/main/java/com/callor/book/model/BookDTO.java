package com.callor.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * VO Ŭ������ DTOŬ����
 * �Ϲ����� ������ ���� ����
 * 
 * DB�� ������ �Ҷ��� �ణ�� ���̰� �ִ�.
 * VO: CRUD ��忡�� ����ϴ� ������
 * DTO : �б����� �����͸� ���� �뵵
 * 
 */
@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
	
	private String bk_isbn;
	private String bk_title;
	private String bk_cname;
	private String bk_cceo;
	
	private String bk_author;
	private String bk_au_tel;
	
	private Integer bk_price;
	private Integer bk_pages;

}
