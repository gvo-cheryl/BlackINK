<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />

<style type="text/css">
	body {
		background-color: ghostwhite;
	}
	article {
		width:800px;
		height: 500px;
		position: relative;
		left: 25%;
	}
	table {
		margin-left: 30px;
		margin-right: 30px;
		text-align: center;
		background-color: ghostwhite;
	}
	.head_title {
		margin-top: 30px;
		margin-bottom: 30px;
	}
	.head_title > h1 {
		padding-right: 30px;
		text-align: right;
	}
	#sub_title {
		padding-left: 30px;
	}
	#img_area {
		align-items: center;
		width: 150px;
		height: 150px;
	}
	#title_area {
		text-align: center;
		width: 150px;
	}
	.space {
		height: 10px;
		background-color: ghostwhite;
	}
	.area {
		background-color: white;
		margin-top: 10px;
		margin-bottom: 10px;	
	}
</style>

</head>
<body>

	<%@ include file="./form/header.jsp"%>
<article>
		<div id=join class="head_title">
			<h1>내 도안</h1>
			<hr>
		</div>
		<br />
		<div id="sub_title">내가 만든 도안 조회</div>
		<br />

		<c:set var="i" value="0" />
		<c:set var="j" value="4" />
		<table id="searchList">
			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<th colspan="4" rowspan="3" align="center"ƒ>--- 검색결과가 없습니다 ---</th>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list }" var="dto">
						<c:if test="${i%j == 0}">
							<tr>
						</c:if>
						<td>
							<ul id="ajaxReset" class="area">
								<li id="img_area">
								<!-- 이미지 경로 다시 지정하기!!!!!  -->
									<img
										src="http://localhost:8787/Project_semi/img/${dto.ca_servername}"
										id="imageList" alt="사진 로드 실패">
								</li>
								<li class="space"></li>
								<li id="title_area">${dto.ca_filename }</li>
								<li class="space"></li>
								<li class="space"></li>
							</ul>
						</td>
						<c:if test="${i%j == j-1 }">
							</tr>
						</c:if>
						<c:set var="i" value="${i+1 }" />
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</article>
	<br />
	<br />
	<br />
	<%@ include file="./form/rightNavi.jsp" %>
	<%@ include file="./form/leftNavi.jsp"%>
	<%@ include file="./form/footer.jsp"%>

</body>
</html>