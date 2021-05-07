package com.callor.menu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * WebBrowser를 통해서 /hello/menu라는 요청이 오면 처리후 응답할 클래스
 * 이런 클래스를 HttpServlet 클래스라고 한다.
 * 
 * Web에서 /hello/menu/ 라는 요청이 들어오면 controller의 코드가 반응하도록 설정
 * @WebServlet
 * 
 */

@WebServlet("/menu")
public class MenuController extends HttpServlet {

	// 컨트롤러가 반응할 때 실행될 method
	// Tomcat 호출하여 여러가지 정보를 전달해줄 method
	// Tomcat이 전달하는 정보는
	// HttpServletRequest, HttpServletResponse 클래스의 객체를 통해 받을 수 있다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// WebBrower의 req에 반응한 클래스 이름이 무엇인가.
		String servletName = this.getServletName();
		System.out.println("Servlet name : " + servletName);
		
		// 현재 Project의 Context가 무엇인가
		String rootPath = req.getContextPath();
		System.out.println("Root Path : " + rootPath);
		
		// 요청 path에 부착된 질의데이터 보기
		String queryString = req.getQueryString();
		System.out.println("query String : " + queryString);
		
		String strId = req.getParameter("id");
		System.out.println("ID 값 :" + strId);
		
		PrintWriter out = resp.getWriter(); 
		
		//전달받은 id 변수에 담긴 값에 따라 기능 수행
		if(strId.equals("rent")) {
			// 도서 대여 처리
//			out.println("도서대여처리");
			
			//처음화면에서 주소에 rent라는 값이 담기면 /hello/rent/list에 다시 요청해라
			resp.sendRedirect("/hello/rent/list");
			
			
		}else if(strId.equals("book")) {
			// 초기화면의 메뉴에서 도서정보를 클릭하면 처리할 부분
			// 여기에서 처리할 코드가 도서정보를 변수에 세팅하고 book.jsp에 보내서 보여주는 코드를 작성
			// 도서정보 처리
			
			// 이미 bookcontroller에 만들어 뒀으니 book을 입력받으면 /hello/book/list으로 넘겨주겠다.
			resp.sendRedirect("/hello/book/list");
			
		}else if(strId.equals("author")) {
			// 저자정보 처리
		}else if(strId.equals("comp")) {
			// 출판사 정보 처리
		}else if(strId.equals("buyer")) {
			// 회원정보 처리
		}
		

	}

}
