package com.callor.todo.command.exec;

import java.util.HashMap;
import java.util.Map;

public class Map_01 {
	
	/*
	 * Map<K,V>
	 * List �����Ϳ� �Բ� Java���� ���� ���Ǵ� �ڷᱸ��
	 * 
	 * Key, Value �������� �����͸� �����ϰ� ���� �� �ִ� �ڷᱸ��
	 * 
	 * list.add(��) : List�� ����
	 * list.get(index) : List���� ���� �б�
	 * 
	 * Map type
	 * map.put(key,��) : Map�� ������ ����
	 * map.get(key) : Map���� �� ���� ��
	 */
	public static void main(String[] args) {
		
		// Map interface�� �����ϰ� HashMap���� �����ϱ�
		Map<String, String> maps = new HashMap<String, String>();
		
		maps.put("�̸�", "ȫ�浿");
		maps.put("����", "30");
		maps.put("����", "IT������");
		
		System.out.println(maps.get("�̸�"));
		System.out.println(maps.get("����"));
		System.out.println(maps.get("����"));
		
		
	}
}
