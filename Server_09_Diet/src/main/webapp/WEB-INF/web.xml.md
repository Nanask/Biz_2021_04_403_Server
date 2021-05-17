# web.xml

* Java EE(Enterprise Edition) ������Ʈ���� Servlet, Controller���� �����ϴ� ���� ���� ����
* @WebServlet() Annotation�� ��������� ������ Servlet, Controller ���� ������ web.xml���Ͽ� �����߾���.
* WebServlet() Annotation�� ����ϱ� ������ ���� web.xml�� ������� �ʾƵ� ������Ʈ�� �����ϴµ� ������ ����
* �ٸ� ������(/, root Path)�� �����ϴ� ��θ� Catch�ϴ� Controller�� �������� �ƹ��� ������ ����.
* �׷��� ���� ������Ʈ�� HomeController���� ������(/, root Path)�� ���� �ڵ鸵 �ϰ� �ֱ� ������ �������(�̹���, CSS, HTML ��)�� ��û�� �� �� ���� �Ǿ� ���ȴ�.
* �̹���, CSS ������ JSP���� link �Ϸ��� Controller�� ���� �ڵ鸵 ���� ���ϵ��� ����� ��� �Ѵ�. 
* Controller�� ���� �ڵ鸵 ���� �ʰ� CSS���� link �ϱ� ���ؼ� Web.xml�� default mapping�� ������ �־�� �Ѵ�.

## web.xml�� ����� Controller ����
<servlet>
	<servlet-name>home</servlet-name>
	<servlet-class>com.callor.diet.HomeController</servlet-class>
</servlet>

<servlet-mapping>
	<servlet-name>home</servlet-name>
	<url-pattern>/*</url-pattern>
</servlet-mapping>

* ������(/) �� req�� ���� com.callor.diet.HomeController�� ó���ض� ��� ��