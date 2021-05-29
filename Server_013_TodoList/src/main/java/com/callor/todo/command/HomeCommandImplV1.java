package com.callor.todo.command;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.callor.todo.service.TodoService;
import com.callor.todo.service.Impl.TodoServiceImplV1;

public class HomeCommandImplV1 implements TodoCommand{

	protected static final Logger log = LoggerFactory.getLogger("HOME");
	
	/*
	 * (����)���� Ŭ������ ��ü�� �����Ͽ�
	 * Ŭ���� ������ ���� method���� �������� ����� ���
	 * ��ü�� Ŭ������ �ɹ� ������ �����Ѵ�
	 * �̶� ��ü�� ���������ڸ� protected�� �ϸ�
	 * 		�� Ŭ������ ��ӹ޴� �������� ��������
	 * 		����Ҽ� �ִ�
	 * 
	 * �̷��� �ڵ尡 ����� ������ �ִµ�
	 * 		��Ȥ �޸� leak(����)�� �߻��� �� �ִ�
	 * 		�̷����� ��ü�� final�� ������ �ִ°͵� 
	 * 		�Ѱ��� ����̴�
	 * 
	 * ��, ��ü�� final�� ������ ����
	 * 		�ݵ�� �����ڿ��� �ʱ�ȭ�� ����� �Ѵ�
	 * 
	 */
	protected final TodoService tdService;
	public HomeCommandImplV1() {
		tdService = new TodoServiceImplV1();
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Map<String,Object>> tdList 
				= tdService.selectAll();
		
		log.debug("SELECT {} ", tdList.toString());
		req.setAttribute("TDLIST", tdList);
		
		ReqCommand.forward(req,res,"home");
		
		
	}

}