package com.callor.hello.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buyer/*")
public class buyerController extends HttpServlet {

	// doget�� �����ִ°� 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/buyer.jsp")
			.forward(req, resp);
	}
	/*
	 * Web���� input box�� �����͸� �Է��ϰ� �����Ҷ� form�� method="POST"�� �����ϸ�
	 * controller�� doPost() method�� ó���� �Ѵ�.
	 */

	// post�� �����ϴ� ��
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String addr = req.getParameter("addr");
		
		System.out.println("�̸�: " + name);
		System.out.println("��ȭ��ȣ: " + tel);
		System.out.println("�ּ�: " + addr);
	}
	
	
	
	

}
