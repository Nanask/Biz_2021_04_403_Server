package com.callor.todo.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReqController {
	
	private static final String prefix = "/WEB-INF/views/";
	private static final String subfix = ".jsp";
	
	/*
	 * Controller���� ���޹��� jsp ������ forwarding �ϱ� ���� Command method
	 */
	public static void forward(HttpServletRequest req, HttpServletResponse reps, String file) throws ServletException, IOException {
		
		// "/WEB-INF/views/" + file + ".jsp"
		String path = String.format("%s%s%s", prefix, file, subfix);
		
		req.getRequestDispatcher(path).forward(req, reps);
		
	}

}

