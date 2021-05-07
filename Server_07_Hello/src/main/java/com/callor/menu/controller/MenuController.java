package com.callor.menu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * WebBrowser�� ���ؼ� /hello/menu��� ��û�� ���� ó���� ������ Ŭ����
 * �̷� Ŭ������ HttpServlet Ŭ������� �Ѵ�.
 * 
 * Web���� /hello/menu/ ��� ��û�� ������ controller�� �ڵ尡 �����ϵ��� ����
 * @WebServlet
 * 
 */

@WebServlet("/menu")
public class MenuController extends HttpServlet {

	// ��Ʈ�ѷ��� ������ �� ����� method
	// Tomcat ȣ���Ͽ� �������� ������ �������� method
	// Tomcat�� �����ϴ� ������
	// HttpServletRequest, HttpServletResponse Ŭ������ ��ü�� ���� ���� �� �ִ�.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// WebBrower�� req�� ������ Ŭ���� �̸��� �����ΰ�.
		String servletName = this.getServletName();
		System.out.println("Servlet name : " + servletName);
		
		// ���� Project�� Context�� �����ΰ�
		String rootPath = req.getContextPath();
		System.out.println("Root Path : " + rootPath);
		
		// ��û path�� ������ ���ǵ����� ����
		String queryString = req.getQueryString();
		System.out.println("query String : " + queryString);
		
		String strId = req.getParameter("id");
		System.out.println("ID �� :" + strId);
		
		PrintWriter out = resp.getWriter(); 
		
		//���޹��� id ������ ��� ���� ���� ��� ����
		if(strId.equals("rent")) {
			// ���� �뿩 ó��
//			out.println("�����뿩ó��");
			
			//ó��ȭ�鿡�� �ּҿ� rent��� ���� ���� /hello/rent/list�� �ٽ� ��û�ض�
			resp.sendRedirect("/hello/rent/list");
			
			
		}else if(strId.equals("book")) {
			// �ʱ�ȭ���� �޴����� ���������� Ŭ���ϸ� ó���� �κ�
			// ���⿡�� ó���� �ڵ尡 ���������� ������ �����ϰ� book.jsp�� ������ �����ִ� �ڵ带 �ۼ�
			// �������� ó��
			
			// �̹� bookcontroller�� ����� ������ book�� �Է¹����� /hello/book/list���� �Ѱ��ְڴ�.
			resp.sendRedirect("/hello/book/list");
			
		}else if(strId.equals("author")) {
			// �������� ó��
		}else if(strId.equals("comp")) {
			// ���ǻ� ���� ó��
		}else if(strId.equals("buyer")) {
			// ȸ������ ó��
		}
		

	}

}
