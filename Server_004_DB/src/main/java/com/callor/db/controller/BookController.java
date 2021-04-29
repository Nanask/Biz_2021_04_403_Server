package com.callor.db.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.db.model.BookVO;
import com.callor.db.service.BookService;
import com.callor.db.service.impl.BookServiceImplV1;

// localhost:8080/db/book(URI) �̶�� ��û�� �ϸ�
// localhost:8080 = Tomcat�� ȣ���ϴ� �κ� = URL
// /db : ContextRoot = ������Ʈ�� ����
// /book : ��û path
// ?���� = �� : Query ��û ��
// /* book������ ������û�� ����� �� �ִ�.
@WebServlet("/book/*")
public class BookController extends HttpServlet{
	
	private BookService bService;
	
	public BookController() {
		bService = new BookServiceImplV1();
	}

	/*
	 * WAS ���� ������Ʈ�� ������ �� Ŭ������ ����� ������ �ѹ� Run �� �Ŀ� �ٽ� Ŭ���� �ڵ带 �����ϸ� Tomcat�� �ڵ����� ����� �ȴ�.
	 * �׶� Tomcat�� ���������� Ŭ������ ������ �����ϴ� ������ key ��
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		 * db/book/* �� pattern���� ��û�� �ϸ�
		 * * �κп� �߰��� subPath�� �����Ͽ� �������� ��û�� ó�� �� �� �ִ�.
		 * �̶� �߰��� subPath�� �����Ҷ��� req.getPathInfo()�� ����Ͽ� �����Ѵ�.
		 */
		resp.setContentType("text/html;charset = UTF-8");
		PrintWriter out = resp.getWriter();
		String subPath = req.getPathInfo();
		if(subPath.equals("/select")) {
			List<BookVO> bookList = bService.selectAll();
			out.println(bookList.toString());
		}else if(subPath.equals("/find")) {
			
			String isbn = req.getParameter("isbn");
			BookVO bookVO = bService.findByID(isbn);
			if(bookVO == null) {
				out.println("ã�� �����Ͱ� ����");
			}else {
				out.println(bookVO.toString());
			}
			
		}
		out.println(subPath);
		out.close();
		
	} //end doGet()
	
	private void selectAll() {
List<BookVO> bookList = bService.selectAll();
		
//		resp.setContentType("text/html;charset=UTF-8");
		
		
		
		PrintWriter out = null; //resp.getWriter();
		out.println("Welcome to my home :");
//		out.println(req.getContextPath());
		
		for(BookVO vo : bookList) {
			out.print("<p>");
			out.print(vo.getBk_isbn());
			out.print(vo.getBk_ccode());
			out.print(vo.getBk_acode());
			out.print(vo.getBk_price());
			out.print(vo.getBk_pages());
			out.print(vo.getBk_title());
			out.print(vo.getBk_date());
		}
		
		out.close();
	}
	
	private void callService() {
		
		
		String bk_title = "�ڹ��Թ�";
		String bk_comp = "������";
		String bk_author = "������";
		
		BookVO bookVO = new BookVO();
		bookVO.setBk_title("�ڹ��Թ�");
		bookVO.setBk_ccode("C0001");
		bookVO.setBk_acode("A0001");
		
		
		//insert�� �������� ���� : insert �޼��忡 �Ű������� ���� ����
		
		//������ �߰�
		bService.insert(bookVO);
		
		//��ü����Ʈ
		List<BookVO> bookList = bService.selectAll();
		
		//���� 1�� ���� ��ȸ
		BookVO retVO = bService.findByID("97000000");
		
		// �������� ����
		bService.update(bookVO);
		
		// �������� ������ �Ѱ� ����
		bService.delete("97000000");
				

		
	}
	
	
	
	

}
