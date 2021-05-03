package com.callor.book.service;

import java.util.List;

import com.callor.book.model.BookRentDTO;
import com.callor.book.model.BookRentVO;

// book_rent table�� CRUD�� �����ϱ� ���� �������̽� ����

// PK������ ��ȸ�Ǵ� Ŭ������ �����ϰ�� ���� ListŸ��
public interface BookRentService {
	
	public List<BookRentDTO> selectAll();
	
	// PK������ ��ȸ�ϱ�
	public BookRentDTO findById(long seq);
	
	// �����ڵ�� �뿩��� ��ȸ
	public List<BookRentDTO> findByBISBN(String isbn);
	
	// ���������� �뿩��� ��ȸ
	public List<BookRentDTO> findByBookName(String name);
	
	// ȸ���ڵ�� �뿩��� ��ȸ
	public List<BookRentDTO> findByBuyerCode(String bCode);
	
	// ȸ�������� �뿩��� ��ȸ
	public List<BookRentDTO> findByBuyerName(String bName);
	
	// �̹ݳ� �뿩��� ��ȸ
	// (��ü�ڸ��)
	public List<BookRentDTO> findByOverDue(String eDate);
	
	// �뿩���ڸ� �����Ͽ� ��� ��ȸ
	public List<BookRentDTO> findByTerm(String sDate, String eDate);
	
	// Prepare ..�� ���ؼ� SQL�� �����ϸ� 
	// CUR�� ���������� ����Ǹ� ������� ���� 1�̻��� �ǵ��� ����
	// �׷��� ���ϸ� 0���� �ǵ��ƿ´�.
	public int insert(BookRentVO bookRentVO);
	public int update(BookRentVO bookRentVO);
	public int delete(Long seq);
	
	

}
