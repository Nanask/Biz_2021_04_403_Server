package com.callor.menu;

public class StringEx_01 {

	public static void main(String[] args) {
		
		String menu = null;
		if(menu == null) {
			System.out.println("menu 값이 null이다.");
		} else if(menu.equals("1")) {
			System.out.println("menu에 저장된 값은 1");
		}else if(menu.equals("2")){
			System.out.println("저장된 값 2");
		}else if(menu.equals("3")){
			System.out.println("저장된 값 3");
		}else if(menu.equals("3")){
			System.out.println("저장된 값 3");
		} else {
			System.out.println("모르겠음");
		}
		
		
		// 첫번째 조건이 성립되면 나머지 값들도 출력을 한다.
		// 스위치는 null 값을 수행할 수 없다.
		// 그래서 null값이 나올 확률이 있다면 !=표현을 써서 사용하도록 하자
		
		// switch 명령은 다중 if else, else if를 대신하여 사용할 수 잇는 구조적인 명령문이다.
		// 반드시 case 조건을 수행한 다음 break;를 실행하여 더이상 불필요한 코드가 실행되는 것을 막아야 하며
		
		// 만약 변수에 저장 된 값이 null이면 미리 if 명령등을 이용하여 검사를 하던지 , 
		// 절대 변수에 null값이 저장되지 않도록 미리 조치를 해 주어야 한다.
		
		// java 1.5이전에는 switch 문으로 문자열을 조건 처리할 수 없었다.
		
		// switch는 변수가 숫자형일 경우에만 사용하는 것이 오류를 막고 깔끔한 코드가 될 수 있다.
		
		if(menu != null) {
			switch (menu) {
			case "1" :
				System.out.println("1");
				break;
			case "2" :
				System.out.println("2");
				break;
			case "3" :
				System.out.println("3");
				break;
			default:		
				System.out.println("모르겠음");
			}
		
		}
	}
}