package com.callor.todo.command;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.callor.todo.config.DBInfo;
import com.callor.todo.service.TodoService;
import com.callor.todo.service.Impl.TodoServiceImplV1;

public class TodoCommandImplV1 implements TodoCommand {

	// Logger ��ü�� log�� �����ϰ�
	//   ������ �Ҷ� �����̸����� TODO�� �����϶�
	// 	 TODO��� �̸����� Logger�� �̱������� �����϶�
	// Factory ����
	// 	 ��ü�� �����ϴ� Ŭ����.method()�� �غ��� �ΰ�
	// 	 �ʿ信 ���� ������ ��ü�� �����޴� ����
	private static final Logger log
		= LoggerFactory.getLogger("TODO");
	
	private TodoService toService;
	public TodoCommandImplV1() {
		toService = new TodoServiceImplV1();
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String td_doit = req.getParameter("td_doit");
		String td_seq = req.getParameter("td_seq");
		
		// Server APP���� System.out.printf() ���
		// ����� console ��� method
		log.debug("td_doit {} ", td_doit);
		log.debug("td_seq {} ", td_seq);
		
		// Map���� ���� ����(Dynamic) vo
		// value�� Object�� ���� ����
		//	table���� �����͸� SELECT �ϰų�,
		//		INSERT, UPDATE �� �����Ҷ�
		//		�� Į���� Data Type�� ���ڿ�, ���� ��
		//		�پ��� Type���� �����Ǿ� �ֱ� ������
		//		�̸� � Type���� �����ϱⰡ �����
		//		Super parent Type�� Object Ŭ���� type����
		//		�����Ѵ�
		Map<String,Object> tdVO = null; 
		
		// ���ʷ� TODO �߰��ϴ� ��¥, �ð��� �ڵ�����
		
		// ���� �ý����� ��¥��������
		Date date 
			= new Date(System.currentTimeMillis());
		
		// ��¥�� ���ڿ��� ��ȯ�ϱ� ���Ͽ�
		// format �� �����ϰ�
		SimpleDateFormat sd 
			= new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st 
			= new SimpleDateFormat("HH:mm:ss");
		
		// ������ form�� ����Ͽ� ��¥, �ð� �����͸�
		// ���ڿ��� ��ȯ�Ͽ� ������ ����
		String curDate = sd.format(date);
		String curTime = st.format(date);

		// request�� ���� URI ������ �����ϱ�
		String uriPath = req.getRequestURI();
		log.debug("URI {} ",uriPath);
		
		// rootPath == contextRootPath == contextPath
		String rootPath = req.getContextPath();
		
		// ���ڿ�.substring(��𼭺���) : ��𼭺��� ~ ������
		// uriPath���� rootPath�� ������ ������ �����Ͽ� �޶�
		String path 
			= uriPath.substring(rootPath.length());
		
		log.debug("PATH: {}" , path);
		
		if(path.equals("/insert")) {
			
			// list�� ���� new arraylist�� ������ ������ ������ map�� ������ �̰� ����
			tdVO = new HashMap<String, Object>();

			tdVO.put(DBInfo.td_sdate, curDate);
			tdVO.put(DBInfo.td_stime, curTime);
			tdVO.put(DBInfo.td_doit, td_doit);
			
			log.debug("VO ������ {} ", tdVO.toString());
			
			// insert�� ���� ���޹��� ����
			// 1�̻��̸� ���� insert�̰� 
			// �׷��� ������ �߰��� �߸��Ȱ�
			Integer ret = toService.insert(tdVO);
			
			
			
		} else if(path.equals("/expire")) {
			
			// ���޹��� seq�� �ش��ϴ� ������ ��������
			Long seq = Long.valueOf(td_seq);
			tdVO = toService.findById(seq);
			
			log.debug("Find By Id {}", tdVO.toString());

			// ���� ��ȸ�� TODO ��������
			// �������ڸ� �˻��Ͽ�
			// null �̰ų� "" �̸�
			Object e_date = tdVO.get(DBInfo.td_edate);
			if(e_date == null || e_date.equals("")) {
				tdVO.put(DBInfo.td_edate, curDate);
				tdVO.put(DBInfo.td_etime, curTime);
			}
			// ���� ������
			else {
				tdVO.put(DBInfo.td_edate, null);
				tdVO.put(DBInfo.td_etime, null);
			}
			
			log.debug("after set {} ", tdVO.toString());
			toService.update(tdVO);
		
		}

		// Map type�� VO�� ���� ��¥, �ð�, ���� ������
		// �����ϱ�
		// VO�� Į���� �߰��ϸ鼭 ���ÿ� ������ �����ϱ�
		// Map type�� VO�� �����͸� put() �Ҷ�
		//		���� key�� �ش��ϴ� �����Ͱ� �̹� ������
		//		������ �����͸� �����Ѵ�
		//		������ ������ Į���� �߰��ϰ� ������ ����
		tdVO.put("name", "ȫ�浿");
		tdVO.put("name", "�̸���");
		tdVO.put("name", "������");
		
//		if(ret < 1) {
//			req.setAttribute("ERROR", "INSERT ����!!");
//		} else {
//			req.setAttribute("COMP", "INSERT ����!!");
//		}
		
		// "/todo/"
		res.sendRedirect( req.getContextPath() );
		
	}
}