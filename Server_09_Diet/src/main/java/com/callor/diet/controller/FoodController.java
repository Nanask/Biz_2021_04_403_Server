package com.callor.diet.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.diet.model.FoodDTO;
import com.callor.diet.model.MyFoodVO;
import com.callor.diet.service.FoodService;
import com.callor.diet.service.MyFoodService;
import com.callor.diet.service.impl.FoodServiceImplV1;
import com.callor.diet.service.impl.MyFoodServiceImplV1;

@WebServlet("/food/*")
public class FoodController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1404737917968004169L;
	protected FoodService fdService;
	protected MyFoodService mfService;

	public FoodController() {

		fdService = new FoodServiceImplV1();
		mfService = new MyFoodServiceImplV1();
		
	}

	// anchor link를 클릭했을 때 처리할 mehtod
	// a tag : <a href>
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 요청주소에 /food 다음에 오는
		// sub 요청 문자열을 추출
		// /food/search 라고 요청을 보내면
		// /search 문자열 추출
		String subPath = req.getPathInfo();

		if (subPath == null || subPath.equals("")) {
			System.out.println("요청 subPath 없음");

		} else if (subPath.equals("/search")) {

			// ReqController에서 생성으로 인해 코드를 사용할 수 잇음
			// 식품검색 화면 보여주기
			ReqController.forward(req, resp, "search");
		} else if (subPath.equals("/insert")) {
			/*
			 * 식품을 선택하여 식품코드를 전달받은 후 식품정보를 입력하기 위한 화면을 보여주기 식품코드, 식품이름
			 * 
			 * 전달받은 식품코드로 식품정보를 조회하여 insert.jsp에 전달하기
			 */
			String mf_code = req.getParameter("fd_code");

			FoodDTO foodDTO = fdService.findById(mf_code);
			
			req.setAttribute("FOOD", foodDTO);
			
			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			String today = sd.format(date);
			
			req.setAttribute("TODAY", today);
					

			ReqController.forward(req, resp, "insert");

		}
	}

	// form에서 input Box에 입력한 데이터를 전송했을 때 method를 POST로 지정하면 처리하는 함수
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		req.setCharacterEncoding("UTF-8");

		String subPath = req.getPathInfo();

		if (subPath == null || subPath.equals("")) {
			System.out.println("요청 subPath가 없음");
		} else if (subPath.equals("/search")) {

			// form에 입력된 데이터를 추출(파라메터를 get)하고
			String f_name = req.getParameter("f_name");
			// DB에서 조회하여 다시 Web에 보여주기
			List<FoodDTO> foodList = fdService.findByName(f_name);
			

//			System.out.println(foodList); 테스트코드

			// foodList를 속성에 담는 역할?
			req.setAttribute("FOODS", foodList);
			ReqController.forward(req, resp, "search");
			

		} else if (subPath.equals("/insert")) {
			
	         String strFcode = req.getParameter("my_pcode");
	         String strDate = req.getParameter("my_date");
	         String strAmt = req.getParameter("my_amt");
	         
	         MyFoodVO myFoodVO = new MyFoodVO();
	         myFoodVO.setMy_pcode(strFcode);
	         myFoodVO.setMy_date(strDate);
	         myFoodVO.setMy_amt(Float.valueOf(strAmt));
	         
	         int result = mfService.insert(myFoodVO);
	         if(result > 0) {
	            System.out.println("추가 성공");
	            resp.sendRedirect("/diet/");
	         } else {
	            System.out.println("추가 실패");
	         }
			

	

		}

	}

}
