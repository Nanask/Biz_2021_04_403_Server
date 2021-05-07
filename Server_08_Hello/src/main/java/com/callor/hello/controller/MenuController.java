package com.callor.hello.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String rootPath = req.getContextPath();
		String id = req.getParameter("id");
		
		// 밑에 if문과 같은 작용을 한다.
		// 사용자가 입력해준 id값에 따라 자동으로 이동하도록 설정함
		resp.sendRedirect(rootPath + "/" + id);
		/*
		if(id.equals("buyer")) {
			resp.sendRedirect(rootPath + "/buyer");
			
		}else if(id.equals("product")) {
			resp.sendRedirect(rootPath + "/product");
			
		}else if(id.equals("mypage")) {
			resp.sendRedirect(rootPath + "/mypage");
			
		}else {
			//입력된게 없다면 처음 화면으로 돌아가라
			resp.sendRedirect("/hello");
		}
		*/
	}
	
	

}
