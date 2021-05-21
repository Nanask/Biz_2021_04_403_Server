package com.callor.guest.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.guest.config.DBInfo;
import com.callor.guest.model.GuestBookVO;
import com.callor.guest.service.GuestBookService;
import com.callor.guest.service.impl.GuestBookServiceImplV1;

@WebServlet("/guest/*")
public class GuestBookController extends HttpServlet {

	protected GuestBookService gbService;

	public GuestBookController() {
		gbService = new GuestBookServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// /*로 WebServlet을 표시해놓으면 subPath를 사용할 수 있음

		String subPath = req.getPathInfo();
		if (subPath.equals("/view")) {
			String strSeq = req.getParameter("gb_seq");
			Long gb_seq = Long.valueOf(strSeq);
			GuestBookVO gbVO = gbService.findById(gb_seq);

			req.setAttribute("GB", gbVO);
			// 주석처리한 코드와 같으나 RequestForwardController를 이용하여 부르기
			RequestForwardController.forword(req, resp, "view");
			// command(명령자) 패턴 , Delegate(대리자) 패턴
			// req.forword()를 다른 Class에게 일임하기
//			req.getRequestDispatcher("/WEB-INF/views/view.jsp").forward(req, resp);
		} else if (subPath.equals("/insert")) {

			GuestBookVO gbVO = new GuestBookVO();

			// 글쓰기를 시작할 때 자동으로 현재 날짜와 시각을 만들어주기
			// 자바 1.7이하에서도 사용할 수 있는 코드이다.
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd"); // 날짜

			SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss"); // 시간

			Date date = new Date(System.currentTimeMillis());

			gbVO.setGb_seq(0L);
			// 시간과 날짜를 문자열로 변환시킴
			gbVO.setGb_date(sd.format(date));
			gbVO.setGb_time(st.format(date));

			req.setAttribute("GB", gbVO);

			RequestForwardController.forword(req, resp, "write");

		}else if (subPath.equals("/delete")) {
			
			String strSeq = req.getParameter("gb_seq");
				
			System.out.println("SEQ :" + strSeq);
			Long gb_seq = Long.valueOf(strSeq);
			gbService.delete(gb_seq);
			resp.sendRedirect("/guest");
			
		}else if (subPath.equals("/update")) {
			
			//seq값으로 데이터를 1개 찾아서 vo에 담고 writer.jsp에 넘겨서 보여주기
			String strSeq = req.getParameter("gb_seq");
			Long gb_seq = Long.valueOf(strSeq);
			
			GuestBookVO gbVO = gbService.findById(gb_seq);
			
			req.setAttribute("GB", gbVO);
			
			RequestForwardController.forword(req, resp, "write");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String subPath = req.getPathInfo();

		String gb_date = req.getParameter(DBInfo.gb_date);
		String gb_time = req.getParameter(DBInfo.gb_time);
		String gb_writer = req.getParameter(DBInfo.gb_writer);
		String gb_email = req.getParameter(DBInfo.gb_email);
		String gb_password = req.getParameter(DBInfo.gb_password);
		String gb_content = req.getParameter(DBInfo.gb_content);
//		String gb_date = req.getParameter("gb_date");
//		String gb_time = req.getParameter("gb_time");
//		String gb_writer = req.getParameter("gb_writer");
//		String gb_email = req.getParameter("gb_email");
//		String gb_password = req.getParameter("gb_password");
//		String gb_content = req.getParameter("gb_content");
		GuestBookVO gbVO = new GuestBookVO();

		gbVO.setGb_date(gb_date);
		gbVO.setGb_time(gb_time);
		gbVO.setGb_writer(gb_writer);
		gbVO.setGb_email(gb_email);
		gbVO.setGb_password(gb_password);
		gbVO.setGb_content(gb_content);

		System.out.println(gbVO.toString());

		if (subPath.equals("/insert")) {


			gbService.insert(gbVO);
			
			// 작업이 끝나면 홈으로 이동하라
			resp.sendRedirect("/guest");

		}else if(subPath.equals("/update")) {
			
			String strSeq = req.getParameter("gb_seq");
			Long gb_seq = Long.valueOf(strSeq);
			
			gbVO.setGb_seq(gb_seq);
			gbService.update(gbVO);
			resp.sendRedirect("/guest/");
		}

		
	}
}
