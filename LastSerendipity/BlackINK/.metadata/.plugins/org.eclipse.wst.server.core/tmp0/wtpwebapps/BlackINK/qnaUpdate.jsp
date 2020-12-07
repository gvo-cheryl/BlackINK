<%@page import="com.semi.tattoo.qna.dto.QnaDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<%
	QnaDto dto = new QnaDto();
	dto = (QnaDto)(request.getAttribute("dto"));
%>
<body>
<%@ include file='./form/header.jsp' %>	
<article>
	<section id="main">
		<h3>타투 후기</h3>
		<hr size="2" color="grey">
			<form action="QnaController.do?command=updateform" method="post">
				<input type="hidden" value="<%=dto.getNo()%>" name="no">
				<input type="text" value="<%=dto.getTitle()%>" name="title">
				<textarea id="summernote" name="content"></textarea>
				<input type="submit" value="완료">
				<input type="button" value="취소">
			</form>
	</section>
</article>	
<%@ include file="./form/leftNaviQna.jsp" %>	
<%@ include file="./form/footer.jsp" %>	
</body>
</html>