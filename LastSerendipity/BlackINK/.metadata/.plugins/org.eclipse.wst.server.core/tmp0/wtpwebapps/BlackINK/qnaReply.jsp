<%@page import="com.semi.tattoo.qna.dto.QnaDto"%>
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
<%
	String name = (String)(session.getAttribute("me_name"));
	String nic = (String)(session.getAttribute("me_nic"));
	QnaDto dto = (QnaDto)(request.getAttribute("dto"));
%>
<body>
<%@ include file="./form/header.jsp" %>
	<article>
		<section id="main">
			<h3>공지사항</h3>			
			<hr size="2" color="grey">
			<form action="QnaController.do" method="post">
				<table>
					<input type="hidden" value="<%=dto.getNo()%>" name="no">
					<input type="hidden" value="replyres" name="command">
					<tr>
						<input type="text" value="RE: <%=dto.getTitle()%>" name="title">
					</tr>
					<c:choose>
					<c:when test="${not empty sessionScope.me_name }">
						<tr>
							<input type="text" value="<%=name%>" name="writer" readonly="readonly">
						</tr>
					</c:when>
					<c:when test="${not empty sessionScope.me_nic }">
							<input type="text" value="<%=nic %>" name="writer" readonly="readonly">
					</c:when>
					<c:otherwise>
						<tr>
							<input type="text" placeholder="닉네임" name="writer">
						</tr>
					</c:otherwise>
				</c:choose>
					<tr>
						<textarea cols="30" row="30" style="resize:none" name="content"><%=dto.getContent() %>
	--------------------------------
	</textarea>
					</tr>
					<tr>
						<td>
							<input type="submit" value="완료">
							<input type="button" value="취소">
						</td>
					</tr>				
				</table>
			</form>
			
		</section>
	</article>	
<%@ include file="./form/leftNaviQna.jsp" %>	
<%@ include file="./form/footer.jsp" %>	
</body>
</html>