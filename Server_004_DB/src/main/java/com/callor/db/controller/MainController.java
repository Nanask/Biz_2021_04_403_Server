package com.callor.db.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet
 * Java를 사용한 WAS(Web Application Service)구현에서 Controller 클래스를 부르는 별칭
 * 
 * Servlet의 path를 "/"로만 설정한 controller는 localhost:8080/db/ URL의 요청에 응답한다.
 * rootPath 요청이라고 한다.
 * rootPath 요청은 Run On Server로 실행했을때 자동으로 호출되는 효과가 있다.
 */
// main을 입력하면 해당하는 곳으로 이동한다 라는 뜻
// @WebServlet("/main")
@WebServlet("/")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// printWriter대신 사용하는 코드
		response
		.getWriter()
		.append("Served at: ")
		.append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
