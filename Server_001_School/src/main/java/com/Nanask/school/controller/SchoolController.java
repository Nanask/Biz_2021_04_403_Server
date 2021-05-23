package com.Nanask.school.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Nanask.school.service.SchoolService;
import com.Nanask.school.service.impl.SchoolServiceImplV1;

@WebServlet("/school/*")
public class SchoolController extends HttpServlet{
	
	SchoolService scService;

	public SchoolController() {
		scService = new SchoolServiceImplV1();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String subPath = req.getPathInfo();
		
		if(subPath == null || subPath.equals("")) {
			System.out.println("요청 subPath 없음");
		}else if(subPath.equals("/search")) {
			ReqController.forward(req, resp, "search");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String subPath = req.getPathInfo();
		if(subPath == null || subPath.equals("")) {
			System.out.println("요청 subPath 없음");
		}else if(subPath.equals("/search")) {
			
			
		}
		
	}
	
	
	
	

}
