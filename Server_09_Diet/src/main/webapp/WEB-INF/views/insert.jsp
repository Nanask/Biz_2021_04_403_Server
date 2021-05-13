<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
		box_sizing:border-box;
	
	}
	h1, form {
		width:80%;
		margin:10px auto;	
	}
	h1 {
		background-color: rgba(0,255,0,0,0.6);
		color:whit;
		padding: 1.2rem;
		text-align:center;
	
	}
	form {
		border:1px solid green;
		border-radius:20px;
		padding:10px;
	}
	
	label {
		display:inline-block;
		width:50%;
		text-align: right;
		padding:8px;
		margin:5px;
		
	}
	
	input {
		width:60%;
		padding:8px;
		margin:5px;
	}
	
	button {
		background-color: blue;
		color:white;
		padding:8px;
		width:10%;
		outline:0;
		border:0;
		border-radius: 10px;
		cursor:pointer;
	}
	/*
	버튼에 마우스를 올렸을때
	*/
	button:hover {
	/* x-offset y-offset blue spread color */
		box-shadow: 3px 3px 3px rgba(0,0,0,0.3);
	}

</style>
</head>
<body>
	<h1>식품섭취 내역 입력</h1>
	<form method="post">
	<p>
		<label>식품코드</label>
		<input name="my_pcode" value="${FOOD.fd_pcode}">
	<p>
		<label>식품이름</label>
		<input name="my_name" value="${FOOD.fd_name}">
	<p>
		<label>섭취일자</label>
		<input type="date" value="${TODAY}">
		<%-- datetime-local 은 시간도 입력가능! --%>
	<p>
		<label>섭취량</label>
		<input type="number","mf_eat" value="1">
	<p>
		<button>등록</button>
	</form>
		
	

</body>
</html>