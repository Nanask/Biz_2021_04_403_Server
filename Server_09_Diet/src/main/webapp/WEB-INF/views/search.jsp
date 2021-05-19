<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식품정보 검색</title>
<style>

		/*
		tag에 padding을 설정하면 실제 width보다 더 커지는 현상이 발생한다
		
		이러한 현상은 UI 화면을 눈에 거슬리게 하는 결과가 된다.
		
		padding 주었을때
		좌, 우의 padding을 밖으로 보내지 않고 내부로 흡수하는 옵션 
		
		이 설정을 style의 맨 상단에 설정하면 padding으로 인한 Layout의 흐트러짐을 막을 수 있다.
		*/

		*{
			box-sizing : border-box;
		
		}
/* h1,form,table tag에 공통된 style 지정 */
	h1,form,table {
		width:80%;
		margin:0px auto;
	}
	
	h1 {
		background-color: rgba(0,255,0,0.7);
		padding:1rem;
		text-align:center;
		color:white;
		
	
	}

	form {
		border : 1px solid green;
		padding-left : 10px;
		margin top : 5px;
	}
	
	table {
		border:1px solid green;
		margin-top:5px;
		border-collapse: collapse;
	}
	
	td, th {
		border:1px solid green;
		padding:5px;
	}
	
	td {
		color : blue;
	}

	
	tr:nth-child(odd) {
		background-color: #ccc; /* #000 ~ #fff gray level */
	}
	
		
	tr:hover {
		/* rgb(0,0,0) : 블랙 */
		/* rgb(100,100,100) */
		/* rgb(255,255,255) : 화이트 */
		background-color: #aaa; 
		cursor:pointer;
	}
	
	/*
	인풋의 width는 박스의 길이를 늘려주는 것
	인풋 박스의 border-radius는 테두리를 곡선으로 만들어라
	*/
	input {
		border:1px solid green;
		padding:8px;
		width:60%;
		border-radius : 10px;
	}
	
	
	a {
		text-decoration: none;
		
		/* 
			style의 상속
			나(a tag)를 감싸고 있는(td) tag의 color가 변경되면 나도 따라 바뀔거야
		*/
		color: inherit;
	}
	
	tr:nth-child(even) {
		background-color: #eee;
	}
	
	/*
		table의 어떤 row에 마우스가 올리면 바탕색을 #aaa로
		마우스 커서 모양을 손모양으로
	*/
	

</style>
</head>
<body>
	<h1>무엇을 먹을까</h1>
	<%-- form의 method를 POST로 지정하면 Controller의 doPost() 함수가 받아서 처리한다.
	보여지는 search.jsp 파일을 요청한 요청 주소는 /food/search이다
	
		form에 action을 임의로 지정하지 않으면
	action="/form/search"가 자동으로 지정된다
	
	 --%>
	<form method ="post">
	<p>
	<label>식품명</label>
	<%-- input placeholder : 입력박스의 안내메세지 --%>
	<input name="f_name" placeholder="식품명을 입력한 후 Enter....">
	</p>
	</form>
	<div>
		<%--
			c taglib에는 if else가 없어서 choose를 사용한다.
			<c:choose>
				<c:when> : if에 해당하는 부분
				</c:when>
				<c:otherwise> : else에 해당하는 부분
				</c:otherwise>
			</c:choose>	
		
		 --%>
		<c:choose>
			<c:when test="${not empty FOODS}">
				<table>
					<tr>
						<th>식품코드</th>
						<th>식품명</th>
						<th>출시연도</th>
						<th>제공량</th>
						<th>총내용량</th>
						<th>에너지</th>
						<th>단백질</th>
						<th>지방</th>
						<th>탄수화물</th>
						<th>총당류</th>
					</tr>
					<%-- Controller에서 전달받은 FOODS(List type) Attribute를
						for반복문으로 반복하면서 item을 getter하여 FOOD(DTO type)에 담아라
					  --%>
					<c:forEach items ="${FOODS}" var="FOOD">
					<tr>
					<%-- forEach가 만든 FOOD(DTO)에서 각 변수값을 getter하여 화면에 보여라  --%>
						<td>${FOOD.fd_code}</td>
						
						<td>
						<%-- /food/insert?fd_code / fd코드를 get방식으로 보낸다.  --%>
						<a href="${rootPath}/food/insert?fd_code=${FOOD.fd_code}">
							${FOOD.fd_name}</a></td>
						<td>${FOOD.fd_year}</td>
						<td>${FOOD.fd_one}</td>
						<td>${FOOD.fd_capa}</td>
						<td>${FOOD.fd_cal}</td>
						<td>${FOOD.fd_protein}</td>
						<td>${FOOD.fd_fat}</td>
						<td>${FOOD.fd_carbo}</td>
						<td>${FOOD.fd_sugar}</td>
					</tr>
					</c:forEach>
				</table>
			</c:when>
		</c:choose>
	</div>

</body>
</html>