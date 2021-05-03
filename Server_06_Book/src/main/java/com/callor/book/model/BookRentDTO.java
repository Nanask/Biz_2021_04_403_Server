package com.callor.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 주문번호, NUMBER, br_seq
 * 회원코드	CHAR(5), br_bcode
 * 회원명	NVARCHAR2(50), br_bname
 * 회원연락처	VARCHAR2(20), br_tel
 * ISBN	CHAR(13), br_isbn
 * 도서명	NVARCHAR2(125), br_title
 * 반납일	VARCHAR2(10), br_edate
 * 대여금	NUMBER, br_price
 * 대여일	VARCHAR2(10), br_sdate
 */

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor

/*
 * 조회할때(SELECT) Service 각 method가 return 할 type
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
