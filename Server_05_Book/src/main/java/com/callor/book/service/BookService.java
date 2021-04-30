package com.callor.book.service;

import java.util.List;

import com.callor.book.model.BookDTO;
import com.callor.book.model.BookVO;

/*
 * DB�����ϴ� ������Ʈ���� �ʼ������� �����ؾ� �� method�� �ִ�.
 * �ʼ� method�� �ݵ�� table�� �������� CRUD�� �����Ѵ�.
 * 
 * Create : insert()
 * Read : select()
 * Update : update()
 * Delete : delete()
 */

public interface BookService {
	
	// ���� ���� �����͸� 1�� ���޹޾Ƽ� DB insert�� �ϴ� ��� ����
	// ���� ���� ���� �����ʹ� ISBN, ������, ���ǻ��ڵ�, �����ڵ�
	// 		������, ����, �������� �����Ͱ� ���Եȴ�.
	// ���� ������ VO ��ü�� ��� ���޹޾� DB�� insert ��� ����
	public void insert(BookVO bookVO);
	
	// ���� ���� �����͸� ��� ��ȸ�Ͽ� return �ϴ� ��� ����
	public List<BookDTO> selectAll();
	
	
	// �����ڵ�(ISBN)�� 1�� ���޹޾Ƽ� �������� 1���� return�ϴ� ��� ����
	// PK �Ѱ��� ���޹޾� ��ȸ�ϴ� method�� 0 �Ǵ� 1���� ���� return�Ѵ�.
	// �����Ͱ� ���� ���� null�� �������� ���� �����Ͱ� ��� DTO�� return �ȴ�.
	public BookDTO findByID(String bk_isbn);
	
	// �������� 1�� ���޹޾Ƽ� ���������� ��ȸ�� �ϰ� ����� return�ϴ� ��� ����
	public List<BookDTO> findByTitle(String bk_title);
	
	// ������ ���������� 1���� ���޹޾Ƽ� �����͸� ����(����, ����)�ϴ� ��� ����
	public void update(BookVO bookVO);
	
	// ������ ������ ISBN�� 1�� ���޹޾Ƽ� �Ѱ��� ���� ������ �����ϴ� ��� ����
	public void delete(String bk_isbn);

}
