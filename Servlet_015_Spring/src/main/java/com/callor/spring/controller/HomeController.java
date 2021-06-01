package com.callor.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.spring.model.MyVO;
import com.callor.spring.service.HomeService;

@Controller
public class HomeController {
	
	/*
	 * Controller���� HomeService �������̽��� ��ӹ��� MyServiceImplV1 Ŭ������ ����Ͽ� 
	 * findById() method�� ȣ���� �� vo�����͸� �ް� �ʹ�
	 * 
	 * �������� Java Ŭ�������� ������ �������̽��� ��ü�� �����ϰ� 
	 * 	Ŭ������ ��ü�� ����(�ʱ�ȭ)�Ͽ� ������ �ִٰ� �ʿ��� method�� ȣ���� �� �ֵ��� �������Ѵ�.
	 * 
	 * 	������ SpringFramework ȯ�濡���� �ʿ��� ��ü�� �̸� Spring�� ���� �����ϰ� �ִٰ�
	 * 	�ʿ��� ���� ������ �׶��׶� ����Ͽ� ����� �� �ֵ��� ������ش�.
	 * 
	 * 	������Ʈ�� Ŀ���� ���� ��ü�� �ʿ��� �� ������ ���α׷����� ��� ��ü�� ���� �� �����Ͽ� ������(�޸𸮿� ����) �־�� �ϱ� ������
	 * 	������� ������Ʈ�� Ŀ���� �������� �����ؾ� �� �ϵ��� ��������. (�޸�, �ӵ� ���� ��)
	 * 
	 * SpringFrameworkȯ�濡���� �׷��� �͵��� �غ��ϱ� ���Ͽ� �̸� ��ü�� ����� Spring �����̳ʶ�� ���� ������ �ΰ�
	 * 	�ʿ��� ���� ������ ������ ���ش�.
	 * 
	 * 	�̷��� ������ DI(Depndency Inject)��� �ϸ� �����İ� �ݴ�Ǵ� �����̿��� ������ ����(IOC)��� �θ���.
	 */
	private final HomeService hService;
	
	@Autowired
	public HomeController(HomeService hService) {
		
		this.hService = hService;
	}
	
	// ������ �����ϸ� home���� �޾Ƽ� hello korea��� ���ڿ��� ȭ�鿡 �������
	@ResponseBody // ���ڿ��� �״�� ������!
	@RequestMapping(value = "/")
	public String home() {
		return "Hello Korea";
	}
	
	//@ResponseBody�� ���ٸ� ����ġ�� �޾Ƽ� InternalResourceViewResolver�� ������ �ּҸ� �°� ���Խ��� �����
	@RequestMapping(value = "/see",method=RequestMethod.GET)
	public String index(Model model) {
		
		//���񽺿��� �����ϴ� �͵��� ���������� �� �����ڰ� �ʿ��� ����(ȣ���Ҷ�) ��û�ϸ� �����ش�.? �����ǿ���/�����������?? 
		model.addAttribute("MY",hService.findById());
		return "home";
	}
	@RequestMapping(value = "/see",method=RequestMethod.POST)
	public String index(MyVO vo, Model model) {
		
		System.out.println(vo.toString());
		
		model.addAttribute("MY",vo);
		return "home";
	}
	
		
}
