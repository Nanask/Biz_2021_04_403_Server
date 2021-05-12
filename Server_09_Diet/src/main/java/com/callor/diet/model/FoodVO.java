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
public class FoodVO {
	
	private String fd_code; //	char(7 byte)
	private String fd_name; //	nvarchar2(125 char)
	private Integer fd_year; //	number
	private String fd_ccode; //	char(6 byte)
	private String fd_icode; //	char(4 byte)
	private Integer fd_once; //	number
	private Integer fd_capa; //	number
	private Integer fd_cal; //	number
	private Integer fd_protein; //	number
	private Integer fd_fat; //	number
	private Integer fd_carbo; //	number
	private Integer fd_sugar; //	number

}
