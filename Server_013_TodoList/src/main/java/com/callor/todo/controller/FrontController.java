package com.callor.todo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.command.HomeCommandImplV1;
import com.callor.todo.command.TodoCommand;
import com.callor.todo.command.TodoCommandImplV1;

@WebServlet("/")
public class FrontController extends HttpServlet{
	
	//java util Map import
	protected Map<String, TodoCommand> commands;
	
	// FrontController�� ���� ȣ��� �� �ѹ� ����Ǿ �������� ���� ���� �ʱ�ȭ �ϴ� �ڵ�
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		commands = new HashMap<String, TodoCommand>();
		
		// �븮�� ���? subpath�� �� ��� ���⼭ �����ϵ��� �Ѵ�?
		// ���� http://localhost : 8080/todo/rootPath/ �� ��û�� ���� HomeCommandImplV1 ��ü�� ����Ͽ� ��û�� ó���ϱ� ���� �غ�
		commands.put("/", new HomeCommandImplV1());
		
		// ���� http://localhost : 8080/todo/insert/�� ��û�� ����
		// HomeCommandImplV1 ��ü�� ����Ͽ� ��û�� ó���ϱ� ���� �غ�
		commands.put("/insert", new TodoCommandImplV1());
	}
	
	// doGet(), doPost()�� �и��Ͽ� ��û�� ó���ϴ� ���
	// �Ѱ��� method���� ���ÿ� ó���ϱ�
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		// Web���� ��û�� path ��������
		String urlPath = req.getRequestURI(); 
		String path = urlPath.substring(req.getContextPath().length());
		
		System.out.println(path);
		
		
		// req �� URI �߿��� ���� subPath �κ��� ����Ͽ� ó���� ��ü�� Map���� ���� ����
		TodoCommand subCommand = commands.get(path);
		if(subCommand != null) {
			
			// �� Command ��ü�� execute() method���� ���� ��û�� ó���ϵ��� �����ϱ�
			subCommand.execute(req, res);
		}
	}

	
	

}
