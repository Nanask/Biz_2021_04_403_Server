package com.callor.db.service;

import java.util.List;

import com.callor.db.model.BookVO;

/*
 * �������� �м��� ���� ����� db ������Ʈ������ �ʼ������� �ʿ��� method�� �ִ�.
 * 
 * DB�� �����Ǵ� ������Ʈ�� 1���� table�̴�.
 * ���񽺰� ��������µ� CRUD�� �ּ��� �����ؾ� �Ѵ�.
 */

public interface BookService {
	
	/*
	 * WEB Browser���� �����͸� ������
	 * Controller���� �����͸� �ް�
	 * Service Ŭ������ �����͸� �����Ͽ�
	 * DB�� insert�� �����Ѵ�.
	 */
	
	public void insert(BookVO bookVO); // CREATE, ������ �߰�
	
	/*
	 * Web���� �����͸� �����޶�� ��û�� ������
	 * Controller���� Service�� select() method�� ȣ���� ���̸�
	 * 
	 * select() method��
	 * DB�κ��� �����͸� �о Controller���� return�Ѵ�.
	 */
	//��� �����͸� �������� List�� return�޾ƾ� �Ѵ�.
	public List<BookVO> selectAll(); // READ, ������ ��ȸ
	
	/*
	 * Controller�� ���� PKĮ��(bk_isbn)�� �ش��ϴ� �� 1���� ���޹ް�
	 * 
	 * PK Į���� ������ (1����) �ο��Ͽ� select�� �� �����͸� return�ϴ� method
	 */
	public BookVO findByID(String bk_isbn);
	// ���������� �˻�
	// �������� ���޹޾Ƽ� �ش絵������ ��� �����͸� return
	public List<BookVO> findByTitle(String bk_title);
	// ���ǻ��ڵ�� �˻�
	public List<BookVO> findByComp(String bk_comp);
	// �����ڵ�� �˻�
	// �����Ϸ� �˻�
	// �������� �˻�
	// �������� ����� ������
	
	// �����ϰ��� �ϴ� �����͸� ���޹޾Ƽ�(���޹��� �����Ϳ��� �ݵ�� PK���� ���ԵǾ� �־�� �Ѵ�)
	// PK�� ������ �����ϰ�
	// �����͸� Update�Ѵ�.
	public void update(BookVO bookVO); // UPDATE, ������ ����(����, ����)
	
	// �����ϰ��� �ϴ� �������� PK���� �Ű������� ���޹ް�
	// 1���� �����͸� �����Ѵ�.
	public void delete(String bk_isbn); // DELETE, ������ ����

}
