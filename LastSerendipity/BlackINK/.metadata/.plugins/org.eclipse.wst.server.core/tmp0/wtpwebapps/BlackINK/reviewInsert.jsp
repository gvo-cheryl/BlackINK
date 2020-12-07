<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="summernote/js/summernote-lite.js"></script>
<script src="summernote/js/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="summernote/css/summernote-lite.css">
<script>
	<%-- form의 textarea에 summernote 적용 --%>
	$(document).ready(function() {
		$('#summernote').summernote({
			height: 700,
			fontNames : [ '맑은고딕', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', ],
			fontNamesIgnoreCheck : [ '맑은고딕' ],
			focus: true
		});
	});
</script>
</head>
<style type="text/css">
	#main {
		position: relative;
		margin-left: 300px;
		margin-top: 30px;
		width: 1200px;
		height: 700px;
	}
	#main hr {
		position: relative;
		margin-top: 50px;
	}
	
</style>
<link type="text/css" rel="stylesheet" href="./css/insert.css">
<body>
<%@ include file="./form/header.jsp" %>
<%
	String name = (String)(session.getAttribute("me_name"));
	String nic = (String)(session.getAttribute("me_nic"));
	
%>

<article>
	<section id="main">
		<h3>공지사항 작성</h3>
		<hr size="2" color="grey">
		 
		<div id="mainWrap">
		<form name="RU" action="reviewUpload.jsp" method="post" enctype="multipart/form-data">
					<div id="topWrap">
						<input class="topTitle" type="text" placeholder="제목을 입력하세요." name="title" />
				
						<c:choose>
							<c:when test="${not empty sessionScope.me_name }">
									<input class="topName"  type="text" value="<%=name%>" name="writer" readonly="readonly">
							</c:when>
							<c:when test="${not empty sessionScope.me_nic }">
									<input class="topName" type="text" value="<%=nic %>" name="writer" readonly="readonly">
							</c:when>
							<c:otherwise>
									<input class="topName" type="text" placeholder="닉네임" name="writer">
							</c:otherwise>
						</c:choose>
					</div>
					
					<hr>
					
					<div id="bottomWrap">
				        <textarea cols="150" rows="40" name="content"></textarea>
				        
					</div>
					<div id="buttonWrap">
						<input type="file" name="upload">
						<input type="button" value="취소" style="float: right">
						<input type="submit" value="완료" style="float: right">
					</div>
		</form>
		</div>

	</section>
</article>	
<%@ include file='./form/leftNaviStory.jsp' %>	
<%@ include file='./form/footer.jsp' %>	
</body>
</html>