package com.Nanask.school.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Nanask.school.model.SchoolVO;
import com.Nanask.school.service.SchoolService;
import com.Nanask.school.service.impl.SchoolServiceImplV1;

@WebServlet("/")
public class Homecontroller extends HttpServlet{
	protected SchoolService scService;
	
	public Homecontroller() {
		scService = new SchoolServiceImplV1();
				
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ReqController.forward(req, resp, "home");
		
		String st_name = req.getParameter("st_name");
		List<SchoolVO> schoolList = null;
		
		if(st_name == null || st_name.equals("")) {
			System.out.println("일치하는 학생정보가 없습니다");
			
		}else {
			schoolList = scService.findByName(st_name);
		}
		req.setAttribute("SCHOOL", schoolList);
		ReqController.forward(req, resp, st_name);
	}
	
	

}
