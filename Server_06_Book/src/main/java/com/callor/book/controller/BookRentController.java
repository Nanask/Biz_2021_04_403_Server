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

import com.callor.book.model.BookRentDTO;
import com.callor.book.model.BookRentVO;
import com.callor.book.model.BuyerDTO;
import com.callor.book.service.BookRentService;
import com.callor.book.service.BuyerService;
import com.callor.book.service.impl.BookRentServiceImplV1;
import com.callor.book.service.impl.BuyerServiceImplV1;

//DBD���� �����ο� �������̽��� ����� �����ϴ°�

/*
 * Web Browser�� Request�� ó���� Ŭ����
 */

@WebServlet("/rent/*")
public class BookRentController extends HttpServlet {

	private static final long serialVersionUID = 921652892464670154L;
	protected BookRentService brService;
	
	//ȸ���̸��� ��ȸ�ϱ� ���� �����
	protected BuyerService buService;

	public BookRentController() {
//		brService = null; // new... �߰��ϱ�
		brService = new BookRentServiceImplV1(); // ����
		buService = new BuyerServiceImplV1(); 

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// rent/* �� ��û�� �Ǹ� *��ġ�� �����Ǵ� Sub ��û�� �и��س���.
		// rent/seq��� ��û�� �ϸ� subPath���� /seq��� ���ڿ��� ��� ���̴�.
		String subPath = req.getPathInfo();

		// outputStream�� ����Ͽ� ���ڿ� ������� ������ �ϱ� ���� �غ�
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		// rent/seq�� ��û�� ������ ����
		if (subPath.equals("/seq")) {
			// �ֹ���ȣ�� ã��

			// getParameter�� ���������� ���� �� ��� seq�� ���ڿ��� �Է¹���
			String strSeq = req.getParameter("id");
			
			// ����ڿ� ���� 1�� ����?
			if(strSeq == null || strSeq.equals("")) {
				out.println("�ֹ� ��ȣ�� ����");
				out.close();
			}
			
			Long nSeq = Long.valueOf(strSeq);
			BookRentDTO brDTO = brService.findById(nSeq);

			// view���� ������ ������ ����
			/*
			 * ServletContext
			 * Tomcat�� ������� �ۼ��� Web App Service���� ��û(Req) ����(Res)�� �Ѱ��ϴ� ������ ��� ��ü
			 * Web App Service�� �����ϱ� ���Ͽ� Req, Res�� ó���ϴ� �������� ����� �����ؾ� �ϴµ�
			 * �׷��� ����� �̸� ������ ���ұ� ������
			 * ServletContext�� getter�ϴ� �͸����ε� ����ϴ�.
			 * 
			 * DB �� ���κ��� ��ȸ�� �����͸� Web���� �����ϰ��� �Ҷ� ���� ������� ������ �� �ֵ��� �ϴ� ����� �̸� �����Ǿ� �ִ�.
			 */
			ServletContext app = this.getServletContext();
			
			// bService�� return�� brDTO��
			// app��ü�� Book�̶�� �Ӽ������� �����ϱ�
			// app ��ü�� Book�̶�� ��ü������ �����ϰ� 
			// �� BOOK������ brDTO ���� �����Ѵ�.
			// object BOOK = brDTO �̷� ������ �ڵ尡 ����ȴ�.
			// ���õ� BOOK ��ü������ jsp ���Ͽ��� �����Ͽ� ���� ǥ���� �� �ִ�.
			app.setAttribute("Book", brDTO);

			
			// book.jsp ������ �о app�� setting�� BOOK ������ �Բ� Rendering�� �϶�
			// wepapp/WEB-INF/view/book.jsp ������ �о Java�ڵ�� ��ȯ�ϰ�, ������ �غ� �϶�.
			RequestDispatcher disp = app.getRequestDispatcher("/WEB-INF/views/book.jsp");
			// Rendering�� view �����͸� web browser�� response�϶�
			disp.forward(req, resp);

		} else if (subPath.equals("/list")) {
			// �����뿩 ��ü���
			brService.selectAll();
			out.println("�����뿩 ��ü��� ����");

		} else if (subPath.equals("/isbn")) {
			// �����ڵ�� ã��
			brService.findByBISBN("isbn");

		} else if (subPath.equals("/buyer")) {
			// ȸ���ڵ�� ã��
			brService.findByBuyerCode("buyercode");

			// rent/order�� ��û�ϸ� �ֹ��� �ۼ� ó��ȭ�� �����ֱ�
			// ȸ���̸��� �Է��ϴ� ȭ���� �����ֱ�
		} else if (subPath.equals("/order")) {
			// �뿩���� �߰�, �뿩�ϱ�
			System.out.println("order");
//			ServletContext app = req.getServletContext();
			
			//ServletContext �ʿ���� req�� �ٷ� ���� �� �ְ� ��
			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/order.jsp");
			disp.forward(req, resp);
			
		} else if(subPath.equals("/order/page1")) {
			String bu_name = req.getParameter("bu_name");
			if(bu_name == null || bu_name.equals("")) {
				out.println("ȸ�� �̸��� �ݵ�� �Է��ؾ� �մϴ�.");
				out.close();
				
				//ȸ���̸��� ��������
			}else {
			List<BuyerDTO> buList = buService.findByName(bu_name);
			
			// Service���� ���޵� �����Ͱ� �� �Դ��� Ȯ���ϴ� �׽�Ʈ �ڵ�
			System.out.println("=".repeat(50));
			for(BuyerDTO d :buList) {
				System.out.println(d.toString());
			}
			System.out.println("=".repeat(50));
			//test end
			
			ServletContext app = req.getServletContext();
			app.setAttribute("BUYERS", buList);
			
			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/page1.jsp");
			disp.forward(req, resp);
			}		
			} else if(subPath.equals("/order/page2")) {
				String bu_code = req.getParameter("bu_code");
				BuyerDTO buyerDTO = buService.findById(bu_code);
				
				ServletContext app = req.getServletContext();
				
				app.setAttribute("BUYER", buyerDTO);
				
				RequestDispatcher disp
				= req.getRequestDispatcher("/WEB-INF/views/page2.jsp");
			
			
		} else if (subPath.equals("/return")) {
			// �ݳ��ϱ�
			BookRentVO bookRentVO = new BookRentVO();
			brService.update(bookRentVO);

		} else {
			// ���̻� �׸��ϱ�
			//test �ڵ�
//			out.println("����");
//			out.close();
		}

	}

}
