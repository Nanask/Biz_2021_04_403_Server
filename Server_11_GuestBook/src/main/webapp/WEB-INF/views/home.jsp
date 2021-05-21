<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value ="${pageContext.request.contextPath}" var="rootPath" />   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/guest/static/css/home.css?ver2021-05-08" rel="stylesheet"/>
<style>
	/*
	gbList tr에 마우스가 올라가면
	*/
	table#gblist tr:hover {
		cousor : pointer;
		background-color: #ddd;
	}
</style>
<script>
document.addEventListener("DOMContentLoaded",function(){
	document.querySelector("table#gblist").addEventListener("click",function(ev){
		
		// 가장 안쪽(table의 td) tag (TD)의 이름을 가져와라
		let tag_name = ev.target.tagName;
		
		// 누른게 TD라면 TD를 감싸고 있는 TR tag를 찾아라
		// <tr data-seq="${GB.gb_seq}"> 값을 알고 싶다 라는 의미 
		// .dataset.seq 이 코드로 seq값을 찾을 수 있음
		if(tag_name == "TD") {
			let gb_seq = ev.target.closest("TR").dataset.seq
			document.location.href="${rootPath}/guest/view?gb_seq=" + gb_seq
		}
	}) /* table의 click*/
	/* 방명록 쓰기 button click 시작*/
	document.querySelector("button.btn_write").addEventListener("click",function(ev) {
		//체크
		//alert("방명록쓰기")
		document.location.href = "${rootPath}/guest/insert"
	})
	
	/* 방명록 쓰기 button click 종료*/
}) /*전체*/
</script>
<style>
	section#main {
		width:80%;
		margin:3px auto; /*가운데 정렬*/
		border : 1px solid green; /*간격 넓히기*/
		padding: 5px;
		
		/*background : linear-gradient( to right, #16BFFD, #CB3066); 그라데이션 처리코드*/
		background-color: rgba(0,255,0,0.3);
		/* rgba를 사용하는 대신 바탕색의 투명색을 지정
			rgba(0,255,0,0.3)
		*/
		/* opacity: 0.3; */
	}
	/* 
		form tag block tag type 이기 때문에
		button tag와 한 라인에 배치하기 위하여 display type을 inline-block으로 변환하고
		width를 제한하여 설정하였다.
	*/
	section#main form {
		display: inline-block;
		width : 30%;
		margin-left : 20px;
	}
	
	
	section#main input {
		background-color: while;
		padding: 5px;
		border-radius = 5px;
		border: 1px solid green;
		
		
	}

	section#main button {
		padding : 5px;
		outline: 0;
		border: 0;
		border-radius: 5px;
		background-color: ragb(0,0,255,1);
		opacity = 1;
		color: while;
		
	}
	section#main button:hover {
		box-shadow : 2px,2px,2px,rgba(0,0,0,0.3)
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include_nav.jsp" %>
	<section id="main">
		<form>
		<input name="text">
		</form>
		<button class="btn_write">방명록 쓰기</button>
	</section>
	<table id="gblist">
		<tr>
			<th>작성일</th>
			<th>작성시각</th>
			<th>작성자(email)</th>
		</tr>
		<c:forEach items="${GBLIST}" var="GB">
		<tr data-seq="${GB.gb_seq}">
			<td>${GB.gb_date}</td>
			<td>${GB.gb_time}</td>
			<td>
			<%-- --%>
			<%-- <a href="${rootPath}/guest/view?gb_seq=${GB.gb_seq}"> --%>
			${GB.gb_writer}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>