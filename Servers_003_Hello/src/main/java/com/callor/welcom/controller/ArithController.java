package com.callor.welcom.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class ArithController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String strnum1 = req.getParameter("num1");
		String strnum2 = req.getParameter("num2");
		
		Integer intNum1 = Integer.valueOf(strnum1);
		Integer intNum2 = Integer.valueOf(strnum2);
		
		Integer sum = intNum1 + intNum2;
		
		// webapp 폴더의 경로(path)가져오기 위한 객체
		ServletContext app = this.getServletContext();
		
		// 변수를 세팅
		app.setAttribute("num1", intNum1);
		app.setAttribute("num2", intNum2);
		app.setAttribute("sum", sum);
		
		// jsp 파일을 Randering을 강제로 수행하기
		RequestDispatcher dispatcher
		= app.getRequestDispatcher("/result.jsp");
		dispatcher.forward(req, resp);
		
		
	}
	
	//http://localhost:8080/welcome/add?num1=30&num2=50
	//
	
	
	
	

}
