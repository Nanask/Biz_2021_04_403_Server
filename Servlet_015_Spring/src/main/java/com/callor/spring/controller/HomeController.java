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
	 * Controller에서 HomeService 인터페이스를 상속받은 MyServiceImplV1 클래스를 사용하여 
	 * findById() method를 호출한 후 vo데이터를 받고 싶다
	 * 
	 * 전통적인 Java 클래스간의 연결은 인터페이스로 객체를 선언하고 
	 * 	클래스로 객체를 생성(초기화)하여 가지고 있다가 필요한 method를 호출할 수 있도록 만들어야한다.
	 * 
	 * 	하지만 SpringFramework 환경에서는 필요한 객체를 미리 Spring이 만들어서 보관하고 있다가
	 * 	필요한 곳이 있으면 그때그때 배분하여 사용할 수 있도록 만들어준다.
	 * 
	 * 	프로젝트가 커져서 많은 객체가 필요할 때 전통적 프로그래밍은 모든 객체를 선언 및 생성하여 가지고(메모리에 보관) 있어야 하기 때문에
	 * 	어느정도 프로젝트가 커지면 여러가지 관리해야 할 일들이 많아진다. (메모리, 속도 문제 등)
	 * 
	 * SpringFramework환경에서는 그러한 것들을 극복하기 위하여 미리 객체를 만들어 Spring 컨테이너라는 곳에 보관해 두고
	 * 	필요한 곳에 적절히 주입을 해준다.
	 * 
	 * 	이러한 개념을 DI(Depndency Inject)라고 하며 전통방식과 반대되는 개념이여서 제어의 역전(IOC)라고 부른다.
	 */
	private final HomeService hService;
	
	@Autowired
	public HomeController(HomeService hService) {
		
		this.hService = hService;
	}
	
	// 서버를 실행하면 home으로 받아서 hello korea라는 문자열을 화면에 보여줘라
	@ResponseBody // 문자열을 그대로 보여라!
	@RequestMapping(value = "/")
	public String home() {
		return "Hello Korea";
	}
	
	//@ResponseBody가 없다면 디스패치가 받아서 InternalResourceViewResolver로 보내서 주소를 맞게 대입시켜 띄워라
	@RequestMapping(value = "/see",method=RequestMethod.GET)
	public String index(Model model) {
		
		//서비스에서 생성하던 것들을 스프링에서 그 생성자가 필요한 순간(호출할때) 요청하면 보내준다.? 제어의역전/디펜던시주입?? 
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
