<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<style type="text/css">
	 body{background: ghostwhite;}
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
	.head_title {
      margin-top: 30px;
      margin-bottom: 30px;
   }
   .head_title > h1 {
      padding-right: 30px;
      text-align: center;
   }
</style>
<link type="text/css" rel="stylesheet" href="./css/select.css">
<%
	String name = "";
		name = (String)(session.getAttribute("me_name"));
	if (name == null) {
		name = (String)(session.getAttribute("me_nic"));
	}
	ReviewDto dto = new ReviewDto();
	dto = (ReviewDto)(request.getAttribute("dto"));
	Date dtoRegdate = dto.getRegdate();

	SimpleDateFormat transFormat = new SimpleDateFormat("MM-dd HH:mm");

	String regdate = transFormat.format(dtoRegdate);
	
	



	
%>
<body>
<%@ include file="./form/header.jsp" %>
	<article style="height: 800px;">
		<section id="main">
		<div id=join class="head_title">
				<h1>타투후기</h1>
				<hr size="2" color="grey">
			</div>
		
		<div id="mainWrap">	
			<div id="topWrap">
				<p><%=dto.getTitle() %></p>
				<p><%=dto.getWriter() %></p>
				<p><%=regdate %>&nbsp;&nbsp;조회&nbsp;<%=dto.getReadcount() %>
					<input type="button" value="수정" onclick="location.href='ReviewController.do?command=update&no=<%=dto.getNo() %>'">
					<input type="button" value="삭제" onclick="location.href='ReviewController.do?command=delete&no=<%=dto.getNo() %>&writer=<%=dto.getWriter() %>&name=<%=name %>'">
				</p>
			</div>
			<hr>
			<div id="bottomWrap">
				<img style="width:400px; height:350px;" src="/BlackINK/img/<%=dto.getFilename() %>" >
				<p><br><%=dto.getContent() %></p>
			</div>
			
		</div>	
	</section>
	</article>	
	<%@ include file="./form/rightNavi.jsp" %>
<%@ include file="./form/leftNaviStory.jsp" %>	
<%@ include file="./form/footer.jsp" %>	
</body>
</html>