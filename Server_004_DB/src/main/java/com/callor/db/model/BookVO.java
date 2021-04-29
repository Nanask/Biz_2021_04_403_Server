package com.callor.db.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok�� ����Ҷ� @Data�� ������ ������� �� ��
// �ʿ���� �����͵鵵 �߰� �Ǳ� ����
//@Data

@Getter
@Setter
@ToString

// ��� ������ �Ű������� ���� ������
@AllArgsConstructor
// �⺻������
@NoArgsConstructor
public class BookVO {
	
	// DB�� �����ϴ� ������Ʈ������ �ڵ��� ȥ���� ���̱� ����
	// snake case�� VO ������ �����Ѵ� . VO���� ����!
	private String bk_isbn;
	private String bk_title;
	private String bk_ccode;
	private String bk_acode;
	private String bk_date;
	
	// ������ ������ �����Ҷ� Integer�� �����ϸ� 0���� �ʱⰪ�� �����ϰų� �����ڸ� ���������
	private Integer bk_price = 0;
	private Integer bk_pages = 0;

}
