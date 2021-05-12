package com.callor.diet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Homecontroller extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9167625700553979048L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// MVC패턴, 서버를 가동하면 맨처음 home.jsp로 가라!
//		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		
		//위에와 같은 맥락이나 reqController를 사용해 file에 연동시켜 홈으로 연동할 수 잇게 함
		ReqController.forward(req, resp, "home");
	}
	
	

}
