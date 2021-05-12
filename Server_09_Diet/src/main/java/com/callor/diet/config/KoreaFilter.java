package com.callor.diet.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/*
 * Web Browser -> url req -> tomcat -> context -> Filter.doFilter() -> Filter�� ������ ������ ���� 
 * 													Filter�� ������	-> Controller.doGet �Ǵ� Conteroller.doPost()
 * 
 *  Controller���� ���� ������ ����Ǹ鼭 ���(����) Controller���� �������� �����ؾ� �ϴ� �͵�
 *  �������� ó���ؾ� �ϴ� �͵��� �̸� Filter���� ó���� �ϰ�
 *  ó���� ����� Controller���� �����ϴ� Tomcat WAS�� ó�� ����
 *  
 *  Filter���� ó���� ������ ��� Controller�� ������ �����ϴ� �Ͱ� ���� ȿ���� �����Ѵ�.
 *  
 *  login�� ���� ó���� ������ Controller�� ������� ��û�� ������ �׻� login�� �Ǿ� �ִ��� �˻��ϰ�
 *  �׿� ���� ó���� �����ؾ� �ϴµ�
 *  
 *  �׷��� ������ �̸� Filter���� ó���ϰ�
 *  login�� ���� ������ login ���ο� ���� Controller�� �������� �������� �Ǵ��Ͽ� �̸� �ѹ��� ó�� �� �� �ִ�.
 */

// ��� ó���� �����Ű�� ���� /*�� ǥ��!
// urlPatterns = "/food/*"�� �����ϸ� 
// localhost:8080/diet/food�� ��û�ϴ� �κи� ó��
@WebFilter(urlPatterns = "/*")
public class KoreaFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO �ѱ� Encoding ����
		
		/*
		 * ������Ʈ�� ��� Controller�� ��û�Ǵ� �����͵��� ���� Encoding�� �����ϰ� 
		 * 
		 * Controller���� Web���� �����ϴ� �����͵��� ContentType�� �����ϱ�
		 */
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		// �Ǵٸ� ���Ͱ� �ִٸ� �����ؼ� �϶�� �ǹ�����
		// �� ��� ���Ͱ� ���������� �۵��Ѵ�.
		chain.doFilter(req, res);
		
		
	}

}
