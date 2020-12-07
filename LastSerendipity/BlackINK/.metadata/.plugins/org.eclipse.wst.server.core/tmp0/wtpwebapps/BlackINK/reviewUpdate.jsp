<%@page import="com.semi.tattoo.review.dto.ReviewDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
<%
	ReviewDto dto = new ReviewDto();
	dto = (ReviewDto)(request.getAttribute("dto"));
%>
<body>
<%@ include file='./form/header.jsp' %>	
<article>
	<section id="main">
		<h3>타투 후기</h3>
		<hr size="2" color="grey">
			<form action="ReviewController.do?command=updateform" method="post">
				<input type="hidden" value="<%=dto.getNo()%>" name="no">
				<input type="text" value="<%=dto.getTitle()%>" name="title">
				<textarea id="summernote" name="content"></textarea>
				<input type="submit" value="완료">
				<input type="button" value="취소">
			</form>
	</section>
</article>	
<%@ include file='./form/footer.jsp' %>	
</body>
</html>