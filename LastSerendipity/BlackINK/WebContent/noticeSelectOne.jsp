<%@page import="com.semi.tattoo.notice.dto.NoticeDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
body {
	background: ghostwhite;
}

#main {
	position: relative;
	margin-left: 300px;
	margin-top: 30px;
	width: 1200px;
	height: 400px;
}

#main hr {
	position: relative;
	margin-top: 50px;
}

#article {
	height: auto;
}

.head_title {
	margin-top: 30px;
	margin-bottom: 30px;
}

.head_title>h1 {
	padding-right: 30px;
	text-align: center;
}
</style>
<link type="text/css" rel="stylesheet" href="./css/select.css">
<%
	String name = (String)(session.getAttribute("me_name"));
	NoticeDto dto = new NoticeDto();
	dto = (NoticeDto)(request.getAttribute("dto"));
	String regdate = dto.getRegdate().substring(5,16);
	String role = (String)(session.getAttribute("me_role"));
	String A = "A";
%>
<body>

	<%@ include file="./form/header.jsp"%>
	<article id="article" style="height: 800px;">
		<section id="main">
			<div id=join class="head_title">
				<h1>공지사항</h1>
				<hr size="2" color="grey">
			</div>

			<div id="mainWrap">
				<div id="topWrap">
					<p><%=dto.getTitle() %></p>
					<p><%=dto.getWriter() %></p>
					<p><%=regdate %>&nbsp;&nbsp;조회&nbsp;<%=dto.getView() %>
					
<% 
					if(role.equals(A)){
%>					
					<input type="button" value="수정" 	onclick="location.href='NoticeController.do?command=update&no=<%=dto.getNo() %>'">
					<input type="button" value="삭제" 	onclick="location.href='NoticeController.do?command=delete&no=<%=dto.getNo() %>&writer=<%=dto.getWriter() %>&name=<%=name %>'">
<%
					}
%>					
					</p>
				</div>
				<hr>
				<div id="bottomWrap">
					<p><%=dto.getContent()%></p>
				</div>

			</div>
		</section>
	</article>
	<%@ include file="./form/rightNavi.jsp" %>
	<%@ include file="./form/leftNaviStory.jsp"%>
	<%@ include file="./form/footer.jsp"%>
</body>
</html>