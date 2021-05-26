<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value ="${pageContext.request.contextPath }" var="rootPath" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>학번</th>
			<th>학생이름</th>
			<th>학생전화번호</th>
			<th>학년</th>
			<th>학과명</th>
		</tr>
		<c:forEach items="${SCHOOL}" var="SC" >
			<tr>
				<td>${SC.st_num}</td>
				<td>${SC.st_name}</td>
				<td>${SC.st_tel}</td>
				<td>${SC.st_grade}</td>
				<td>${SC.st_dname}</td>
			</tr>	
		</c:forEach>
	</table>		
</body>
</html>