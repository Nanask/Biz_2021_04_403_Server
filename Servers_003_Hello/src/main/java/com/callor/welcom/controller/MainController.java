package com.callor.welcom.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Controller : Web Server App���� 
 * 		Web Application Service(WAS) : ���� ����
 * 		Web Application Server(WAS) : ����Ʈ����, �ý���
 * 
 * Request
 */
//WebServlet Annotation
//���ݺ��� �� Ŭ������ ������ ��ü�� Web Service���� Request�� ó���� ��ü�̴� ��� ����
//main() mathod�� ������ �����Ѵ�.
//���� Request�� ó���ϱ� ���ؼ��� ���� �ڵ带 �ۼ��ؾ� �Ѵ�.
//�׷��� Network�� ���õ� �ڵ�� �ʹ� �����ϰ� �پ��� ����� �䱸�ϱ� ������ �ڵ带 ���� �ۼ��ϴ� ���� ��ƴ�.
//�׷��� java���� �����ϴ� JDK�� ��ӹ޾Ƽ� ��κ��� ����� ó���ϰ� �� �ʿ��� ��ɸ� ������ �ϰ� �ȴ�.

//WebServlet Annotation�� ������ �մ� Ŭ������ Tomcat�� ���ؼ� �����ǰ� ������� Request�� ����
//Tomcat�� Ŭ������ method�� ȣ���ϰ� ����� �����Ѵ�.

//���� ����ڰ� http://localhost:8080/welcome/home �̶�� ��û�� �ϸ�

//1.���� ��ǻ�Ϳ��� ������ tomcat�� ������ �޴´�.
//	http://localhost:8080 : tomcat�� ȣ���ϴ� Request
//2.tomcat ���Ŀ� �������� ���ڿ��� �м��ϱ� �����Ѵ�.
//	/welcome �κ��� �м��Ͽ� Run As Server�� ���۵� ������Ʈ �߿���
// 	root context�� welcome�� ������Ʈ�� ã�´�.
//3.������Ʈ ������ /home ���ڿ��� �ٽ� �м��Ͽ� ������Ʈ ���� Ŭ���� �߿���
// 	@WebServlet("/home") Annotation���� ������ Ŭ������ ã�´�.
//4.Ŭ�������� doGet(...) method�� ȣ���Ѵ�.
//5.doGet() method�� �ڵ带 ������(overriding)�Ͽ� ���񽺸� �����ϰ� �ȴ�.

@WebServlet("/home")
public class MainController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("����� book Controller");
		out.print("<a href ='");
		out.print("http://localhost");
		out.print(":8080");
		out.print("/welcome/book'>");
		out.print("Book ����</a>");
		out.close();
	}

}
