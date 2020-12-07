<%@page import="com.semi.tattoo.notice.dto.NoticeDto"%>
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
<link type="text/css" rel="stylesheet" href="./css/select.css">
<%
	NoticeDto dto = new NoticeDto();
	dto = (NoticeDto)(request.getAttribute("dto"));
	String regdate = dto.getRegdate().substring(5,16);
%>
<body>

<%@ include file="./form/header.jsp" %>
<article>
	<section id="main">
		<h3>공지사항</h3>
		
		<hr size="2" color="grey">
		<div id="mainWrap">	
			<div id="topWrap">
				<p><%=dto.getTitle() %></p>
				<p><%=dto.getWriter() %></p>
				<p><%=regdate %>&nbsp;&nbsp;조회&nbsp;<%=dto.getView() %>
					<input type="button" value="수정" onclick="location.href='NoticeController.do?command=update&no=<%=dto.getNo() %>'">
					<input type="button" value="삭제" onclick="location.href='NoticeController.do?command=delete&no=<%=dto.getNo() %>'">
				</p>
				<!-- <input class="borderless" type="text" value="<%=dto.getTitle() %>" readonly="readonly"><br/> -->
				<!-- <input class="borderless" type="text" value="<%=dto.getWriter() %>" readonly="readonly"> <%=dto.getView() %> <br/> -->
			</div>
			<hr>
			<div id="bottomWrap">
				<p><%=dto.getContent() %></p>
			</div>
			
		</div>	
	</section>
</article>	
<%@ include file="./form/leftNaviStory.jsp" %>
<%@ include file="./form/footer.jsp" %>	
</body>
</html>