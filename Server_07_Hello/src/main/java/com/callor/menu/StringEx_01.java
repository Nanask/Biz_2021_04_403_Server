package com.callor.menu;

public class StringEx_01 {

	public static void main(String[] args) {
		
		String menu = null;
		if(menu == null) {
			System.out.println("menu ���� null�̴�.");
		} else if(menu.equals("1")) {
			System.out.println("menu�� ����� ���� 1");
		}else if(menu.equals("2")){
			System.out.println("����� �� 2");
		}else if(menu.equals("3")){
			System.out.println("����� �� 3");
		}else if(menu.equals("3")){
			System.out.println("����� �� 3");
		} else {
			System.out.println("�𸣰���");
		}
		
		
		// ù��° ������ �����Ǹ� ������ ���鵵 ����� �Ѵ�.
		// ����ġ�� null ���� ������ �� ����.
		// �׷��� null���� ���� Ȯ���� �ִٸ� !=ǥ���� �Ἥ ����ϵ��� ����
		
		// switch ����� ���� if else, else if�� ����Ͽ� ����� �� �մ� �������� ��ɹ��̴�.
		// �ݵ�� case ������ ������ ���� break;�� �����Ͽ� ���̻� ���ʿ��� �ڵ尡 ����Ǵ� ���� ���ƾ� �ϸ�
		
		// ���� ������ ���� �� ���� null�̸� �̸� if ��ɵ��� �̿��Ͽ� �˻縦 �ϴ��� , 
		// ���� ������ null���� ������� �ʵ��� �̸� ��ġ�� �� �־�� �Ѵ�.
		
		// java 1.5�������� switch ������ ���ڿ��� ���� ó���� �� ������.
		
		// switch�� ������ �������� ��쿡�� ����ϴ� ���� ������ ���� ����� �ڵ尡 �� �� �ִ�.
		
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
				System.out.println("�𸣰���");
			}
		
		}
	}
}