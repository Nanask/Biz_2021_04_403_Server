package com.callor.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.book.model.BookRentDTO;
import com.callor.book.model.BookRentVO;
import com.callor.book.service.BookRentService;
import com.callor.book.service.impl.BookRentServiceImplV1;

//DBD���� �����ο� �������̽��� ����� �����ϴ°�

/*
 * Web Browser�� Request�� ó���� Ŭ����
 */

@WebServlet("/rent/*")
public class BookRentController extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 921652892464670154L;
	protected BookRentService brService;

	public BookRentController() {
//		brService = null; // new... �߰��ϱ�
		brService = new BookRentServiceImplV1(); // ����

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String subPath = req.getPathInfo();
		
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		if(subPath.equals("/list")) {
			// �����뿩 ��ü���
			brService.selectAll();
			out.println("�����뿩 ��ü��� ����");
			
		}else if(subPath.equals("/seq")) {
			// �ֹ���ȣ�� ã��
			
			// getParameter�� ���������� ���� �� ��� seq�� ���ڿ��� �Է¹���
			String strSeq = req.getParameter("id");
			Long nSeq = Long.valueOf(strSeq);
			BookRentDTO brDTO = brService.findById(nSeq);
			
			// view���� ������ ������ ����
			ServletContext app = this.getServletContext();
			app.setAttribute("Book", brDTO);
			
			
			// bService�� return�� brDTO��
			// app��ü�� Book�̶�� �Ӽ������� �����ϱ�
			//book.jsp ������ �о app�� setting�� BOOK ������ �Բ� Rendering�� �϶�
			RequestDispatcher disp = app.getRequestDispatcher("/WEB-INF/views/book.jsp");
			//Rendering�� view �����͸� web browser�� response�϶�
					disp.forward(req, resp);
			
		}else if(subPath.equals("/isbn")) {
			// �����ڵ�� ã��
			brService.findByBISBN("isbn");
			
		}else if(subPath.equals("/buyer")) {
			// ȸ���ڵ�� ã��
			brService.findByBuyerCode("buyercode");
			
		}else if(subPath.equals("/rent")) {
			// �뿩���� �߰�, �뿩�ϱ�
			BookRentVO bookRentVO = new BookRentVO();
			brService.insert(bookRentVO);
			
		}else if(subPath.equals("/return")) {
			// �ݳ��ϱ�
			BookRentVO bookRentVO = new BookRentVO();
			brService.update(bookRentVO);
			
		}else {
			// ���̻� �׸��ϱ�
		}
		
	}

}
