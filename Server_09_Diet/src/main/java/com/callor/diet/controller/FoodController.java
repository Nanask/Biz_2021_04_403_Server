package com.callor.diet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.diet.model.FoodDTO;
import com.callor.diet.service.FoodService;
import com.callor.diet.service.impl.FoodServiceImplV1;

@WebServlet("/food/*")
public class FoodController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1404737917968004169L;
	protected FoodService fdService;
	
	public FoodController() {
		
		fdService = new FoodServiceImplV1();
	}

	// anchor link�� Ŭ������ �� ó���� mehtod
	// a tag : <a href>
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// ��û�ּҿ� /food ������ ���� 
		//			sub ��û ���ڿ��� ����
		// /food/search ��� ��û�� ������
		//			/search ���ڿ� ����
		String subPath = req.getPathInfo();
		
		if(subPath == null || subPath.equals("")) {
			System.out.println("��û subPath ����");
			
		}else if (subPath.equals("/search")) {
			
			//ReqController���� �������� ���� �ڵ带 ����� �� ����
			//��ǰ�˻� ȭ�� �����ֱ�
			ReqController.forward(req, resp, "search");
		}
				
		
	}

	//form���� input Box�� �Է��� �����͸� �������� �� method�� POST�� �����ϸ� ó���ϴ� �Լ�
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		req.setCharacterEncoding("UTF-8");
		
		String subPath = req.getPathInfo();
		
		if(subPath == null || subPath.equals("")) {
			System.out.println("��û subPath�� ����");
		}else if(subPath.equals("/search")) {
			
			// form�� �Էµ� �����͸� ����(�Ķ���͸� get)�ϰ�
			String f_name = req.getParameter("f_name");
			// DB���� ��ȸ�Ͽ� �ٽ� Web�� �����ֱ�
			List<FoodDTO> foodList 
			= fdService.findByName(f_name);
			
//			System.out.println(foodList); �׽�Ʈ�ڵ�
			
			// foodList�� �Ӽ��� ��� ����?
			req.setAttribute("FOODS", foodList);
			ReqController.forward(req, resp, "search");
					
		}
		
		
	}
	
	

}
