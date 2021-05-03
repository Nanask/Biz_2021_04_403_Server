<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>ISBN 도서명 : ${Book.br_isbn} </h5>
	<h5>도서명 : ${Book.br_title}</h5>
	<h5>회원코드 : ${Book.br_bcode}</h5>
	<h5>회원명 : ${Book.br_bname}</h5>
	<h5>회원연락처 : ${Book.br_tel}</h5>
	<h5>대여일 : ${Book.br_sdate}</h5>
	<h5>반납일 : ${Book.br_edate}</h5>
	<h5>대여료 : ${Book.br_price}</h5>
	
	
</body>
</html>