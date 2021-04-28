package com.callor.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {
	
	 @Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			   throws ServletException, IOException {
	      
	      // Request : req, Client(Web)���� ������ ��û�ϴ� ������ ����ִ� �Ű�����(������ VO)
	      // Response : resp, �������� Client�� ������ �Ҷ� ���� �������� ����� 
	      //      return ����
	      
	      resp.setContentType("text/html;charset=UTF-8");
	      
	      PrintWriter out = null;
	      out = resp.getWriter();
	      
	      out.println("<h1>�ݰ����ϴ� ���� Servlet �Դϴ�</h1>");
	      out.println("<h3>�츮���󸸼�</h3>");
	      
	      out.close();
	      
	      
	   }

	   
	   
	}