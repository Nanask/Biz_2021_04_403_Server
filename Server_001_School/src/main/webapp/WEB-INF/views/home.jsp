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
	<a href="${rootPath}/school/insert">학생정보등록</a>
	
	<h1>빛나라 대학교</h1>
	<h2>학번을 입력해주세요</h2>
	<%-- 문단나누는 것 div --%>
	<div>
	<form>
	<input name="st_num">
	<button>입력</button>
	</form>
	</div>
	
	<%@ include file="/WEB-INF/views/list.jsp" %>

</body>
</html>