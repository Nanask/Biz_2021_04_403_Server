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

/*
 * Servlet App ������ Servlet(Controller) Ŭ������
 * �ټ� �����ϰ�, �ʿ��Ҷ����� URI(URL)�� mapping�Ͽ�
 * ����� �����Ҽ� �ֵ��� �Ѵ�
 * 
 * ������
 * ������Ʈ�� Ŀ���� �ټ��� Controller �����ǰ�
 * �׶����� URI mapping�� �ϴµ� ���� ������� ���� �� �ִ�
 * �Ȱ��� ��ü�� ��ӹް�, ���� method(doGet, doPost)�� ����Ͽ�
 * �ڵ带 �ۼ��ϴµ�
 * ������ ��������� �����Ѵ�
 * 
 * URI mapping�� �Ѱ����� �����ϰ�
 * POJO
 * (Plan Old Java Object, � Ŭ������ ��ӹ��� ����
 * �Ϲ����� �ڹ� Ŭ���� ������ �ڵ�)�� ����Ͽ�
 * ������Ʈ�� �����ϵ��� �ϴ� ��
 * Dispatcher Servlet Controller ��� �Ѵ�
 * 
 */

@WebServlet("/")
public class FrontController extends HttpServlet {
	// URI mapping�� �����Ͽ�
	// URI �� ���� ��ü�� �غ��Ͽ� ������ ���
	// TodoCommand �������̽���
	// command ��ü���� prototype���� ����Ǿ� �ְ�
	// ������ commands mapper ��ü����
	// �������� command ��ü���� ������ �Ѽ� �ִ�
	// �������̽��� ������� �ʰ� Object�� ����Ҽ� ������
	// Object Ŭ������ ��������� �������� ���� �ҿ�Ǵ�
	// Ŭ���� ��ü�̹Ƿ� ���ݴ� ȿ�������� ����ϱ� ���Ͽ�
	// �������̽��� ������ �ξ���

	// FrontController�� ���� ȣ��ɶ�
	// �ѹ� ����Ǿ
	// �������� ���� ���� �ʱ�ȭ �ϴ� �ڵ� , method
	// java util Map import
	
	// �������̽��� todoCommand�� ������ �����?
	// �� todocommand�� ���°�?
	protected Map<String, TodoCommand> commands;

	// FrontController�� ���� ȣ��� �� �ѹ� ����Ǿ �������� ���� ���� �ʱ�ȭ �ϴ� �ڵ�
	@Override
	public void init(ServletConfig config) throws ServletException {

		commands = new HashMap<String, TodoCommand>();

		// �븮�� ���? subpath�� �� ��� ���⼭ �����ϵ��� �Ѵ�?
		// ���� http://localhost : 8080/todo/rootPath/ �� ��û�� ���� HomeCommandImplV1 ��ü�� ����Ͽ�
		// ��û�� ó���ϱ� ���� �غ�
		
		commands.put("/", new HomeCommandImplV1()); // ��� ����, ���������� �ʰ� �̵������� ������ 
		// "/"Ű �� , impl�� value

		// ���� http://localhost : 8080/todo/insert/�� ��û�� ����
		// HomeCommandImplV1 ��ü�� ����Ͽ� ��û�� ó���ϱ� ���� �غ�
		commands.put("/insert", new TodoCommandImplV1()); 
		commands.put("/expire", new TodoCommandImplV1());
	}

	// doGet(), doPost()�� �и��Ͽ� ��û�� ó���ϴ� ���
	// �Ѱ��� method���� ���ÿ� ó���ϱ�
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		// Web���� ��û�� path ��������
		String urlPath = req.getRequestURI(); // urI�� ��ü path�� �����´�.
		String path = urlPath.substring(req.getContextPath().length()); // .getContextPath() �̰� ��Ʈ�� ������ ���� = ���⼭�� todo
		// substring ���̸� �ڸ��� ��
		// rootpath�� �� ������! �׷��ϱ� ���⼭�� todo / ���Ⲩ!!!!! todo �ڿ�!!!!!

		System.out.println(path);

		// req �� URI �߿��� ���� subPath �κ��� ����Ͽ� ó���� ��ü�� Map���� ���� ����
		// TodoCommand command = new TodoCommandImplV1();
		TodoCommand subCommand = commands.get(path); // �����س��� Ŀ��带 �ҷ���
		if (subCommand != null) {

			// �� Command ��ü�� execute() method���� ���� ��û�� ó���ϵ��� �����ϱ�
			subCommand.execute(req, res);
		}
	}

}
