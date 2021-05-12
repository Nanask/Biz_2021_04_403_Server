package com.callor.diet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReqController {
	
	public static void forward(HttpServletRequest req, HttpServletResponse resp, String file) throws ServletException, IOException {
		
		// file = " WEB-INF/views/search.jsp "를 일일히 적는 것을 막기 위해 reqController라는 클래스를 따로 만들어
		// 요청하면 file에서 입력받을 수 있게 해 놓음
		file = "/WEB-INF/views/" + file + ".jsp";
		
		//생성하면 빨간줄이 생기는데 그때 add throws로 패스를 시킨다.
		req.getRequestDispatcher(file).forward(req, resp);
		
	}

}
