package com.callor.todo.service;

import java.util.List;
import java.util.Map;

/* 
 * �̹� ������Ʈ�� 1���� table ������ ������ ������ ������Ʈ �̹Ƿ�
 * ������ vo,dto�� ������ �ʰ� map<>�� ����Ͽ� �����Ѵ�.
 *  
 * Map�� kdy, value ������ �����͸� �����ϴ� �ڷᱸ��
 * put(key,value) method�� ����Ͽ� ������ �׸�(Į��)�� �߰��ϰ�
 * get(key) method�� ����Ͽ� ������ �׸��� �б�
 * 
 * Map<String,Class> map �������� type�� �����ϰ� 
 * map.put("�̸�",��ü) �������� �����͸� �߰��ϱ�
 * 
 * Class class = map.get("�̸�")�������� ���� �о �ٸ� ������ ���� �� �ִ�.
 * System.out.println(map.get("�̸�")) �������� console�� ����ϱ�
 * 
 * VO(DTO) �� �������� �ʰ� �ӽ÷� VO type�� �����͸� ����ϴ� ���
 * 
 * Map�� ����Ҷ� key ���� String ������ �����ϸ� ���� put(), get() �Ҷ� key���� ""�� ���� ���ڿ� �������� ����ؾ� �ϱ� ������
 * ���� ��Ÿ�� ���� ���� ������ �߻��� �� �ִ�.
 * �̷��� ������ �����ϱ� ���� key ���� ���� static ������ �����ΰ� Ȱ���ϴ� ������� ����Ѵ�
 * 
 * �������� ���� ����ߴ� ����̳� ������ VO�� DTO�� ����ϴ� ���̴�.
 *  
 * 
 */
public interface TodoService {
	
	/*
	 * Map ������ VO�� List type���� return�ϱ�
	 */
	public List<Map<String,Object>> selectAll();
	
	/* 
	 * Map�� value�� � ������ �����Ͷ� ������ �� �ֵ��� �ϰڴ�.
	 * Object�� ��� ��ü�� ���Ե� ��
	 * 
	 * Map�� ������
	 * 	Map<String,String> strmap
	 * 	strmap.put("�̸�","ȫ�浿")
	 * 	-- �����ʹ� ���ڿ� type�� ���尡��
	 * 
	 * Map<String,Integer> intMap
	 *  intMap.put("�̸�",100)
	 *  --�����ʹ� ������ type�� ���尡��
	 *  
	 * Map<String,Object> objMap
	 * 	objMap.put("�̸�","ȫ�浿");
	 * 	ObjMap.put("����",33)
	 * -- � type�� �����Ͷ� ���尡��
	 * 
	 */
	
	public Map<String, Object> findById(Long td_seq);
	public List<Map<String,Object>> findBySDate(String td_sdate);
	public List<Map<String,Object>> findByDoit(String td_doit);
	
	public Integer insert(Map<String,Object> tdVO);
	public Integer update(Map<String,Object> tdVO);
	public Integer deletd(Long td_seq);

}
