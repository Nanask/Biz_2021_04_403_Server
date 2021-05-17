package com.callor.diet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.diet.model.MyFoodDTO;
import com.callor.diet.service.MyFoodService;
import com.callor.diet.service.impl.MyFoodServiceImplV1;

@WebServlet("/")
public class Homecontroller extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9167625700553979048L;
	protected MyFoodService mfService;
	public Homecontroller() {
		mfService = new MyFoodServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mf_date = req.getParameter("mf_date");
		List<MyFoodDTO> mfList = null;
		if(mf_date == null || mf_date.equals("")) {
			mfList = mfService.selectAll();
		}else {
			mfList = mfService.findByDate(mf_date);
		}
		req.setAttribute("MFOODS", mfList);
		
		// MVC패턴, 서버를 가동하면 맨처음 home.jsp로 가라!
//		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		
		//위에와 같은 맥락이나 reqController를 사용해 file에 연동시켜 홈으로 연동할 수 있게 함
		ReqController.forward(req, resp, "home");
	}
	
	

}
