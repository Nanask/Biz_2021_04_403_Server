package com.callor.book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.book.model.BookDTO;
import com.callor.book.model.BookVO;
import com.callor.book.service.BookService;
import com.callor.book.service.impl.BookServiceImplV1;

// localhost:8080/book/book/~~~~�� ��û�� �ϸ� ���⿡�� ó�� �ϰڴ�.
@WebServlet("/book/*")
public class BookController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BookService bService;
	
	public BookController() {
		bService = new BookServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// ~~~�� �Ǿ��ִ� ���ڿ��� �����ϱ�
		// localhost:8080/book/book/input �� ��û�� �ϸ�
		// input ���ڿ��� ����ȴ�.
		
		String subPath = req.getPathInfo();
		
		//����� ���ڰ� ������ �ʵ��� �ѱ� ���ڵ����� ����
		resp.setContentType("text/html;charset=UTF-8");
		
		//�����͸� ���� �����ġ ����
		PrintWriter out = resp.getWriter();
		
		if(subPath.equals("/input")) {
			
			// ÷�ε� �����ٷ��� ��� ���빰 Ȯ��
			String bk_isbn = req.getParameter("bk_isbn");
			String bk_title = req.getParameter("bk_title");
			String bk_price = req.getParameter("bk_price");
			
			BookVO bookVO = new BookVO();
			bookVO.setBk_isbn(bk_isbn);
			bookVO.setBk_title(bk_title);
			bookVO.setBk_price(Integer.valueOf(bk_price));
			bookVO.setBk_ccode("C0001");
			bookVO.setBk_acode("A0001");
			bookVO.setBk_date("2019-10-01");
			
			bService.insert(bookVO);
			
			out.println("���� ������ Ȯ��");
			out.printf("ISBN : %s", bk_isbn);
			out.printf("������ : %s", bk_title);
			out.printf("���� : %s", bk_price);
			out.close();
		} else if(subPath.equals("/select")) {
			
			List<BookDTO> bookList = bService.selectAll();
		} else if(subPath.equals("/isbn")) {
			String bk_isbn = req.getParameter("bk_isbn");
			
			BookDTO bookDTO = bService.findByID(bk_isbn);
			System.out.println(bookDTO);
			
			ServletContext app = this.getServletContext();
			app.setAttribute("BOOK", bookDTO);
			
			RequestDispatcher disp = app.getRequestDispatcher("/WEB-INF/views/book.jsp");
			disp.forward(req, resp);
			
			
			
		} else {
			out.println("�ݰ����ϴ�");
			out.close();
		}
		
	}
	
	

}
