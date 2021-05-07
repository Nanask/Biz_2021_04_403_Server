package com.callor.menu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * Web���� /hello/rent/~~, /hello/rent/insert ��� ���� subPath�� �ִ� ���·� ��û�� �ϸ� �����ϵ��� ����
 * 
 * rent�ڿ� �ٸ� �ܾ ������ �� �ܾ ���󰡵��� ����
 * 
 */
@WebServlet("/rent/*")
public class BookRentController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// rent/~~ ó�� ��û�� �ϸ� 
		// ~~~�κ��� ���ڿ��� �и��Ͽ� �����ϴ� method
		String subPath = req.getPathInfo();
		System.out.println("subPath : " + subPath);
		
		// ���� �����ؼ� ��� ó���� ����
		req.getRequestDispatcher("/WEB-INF/views/rent.jsp")
				.forward(req, resp);
	}
	
	

}
