package com.callor.diet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReqController {
	
	public static void forward(HttpServletRequest req, HttpServletResponse resp, String file) throws ServletException, IOException {
		
		// file = " WEB-INF/views/search.jsp "�� ������ ���� ���� ���� ���� reqController��� Ŭ������ ���� �����
		// ��û�ϸ� file���� �Է¹��� �� �ְ� �� ����
		file = "/WEB-INF/views/" + file + ".jsp";
		
		//�����ϸ� �������� ����µ� �׶� add throws�� �н��� ��Ų��.
		req.getRequestDispatcher(file).forward(req, resp);
		
	}

}
