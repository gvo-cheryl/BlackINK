<%@page import="com.semi.tattoo.qna.dto.QnaDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
String role = "";
String name = "";
QnaDto dto = null;
String regdate = "";

if (session.getAttribute("me_no") == null) {
%>
<script type="text/javascript">
	alert("로그인을 먼저 해주세요.");
	location.href = "login.do";
</script>
<%
	} else {
	role = request.getAttribute("role").toString();
	name = (String) (session.getAttribute("me_name"));
	dto = (QnaDto) (request.getAttribute("dto"));
	// System.out.println(request.getContextPath() + "/img/line.png");
	regdate = dto.getRegdate().substring(5, 16);
	int me_no = Integer.parseInt(session.getAttribute("me_no").toString());
}
%>
<body>

	<%@ include file="./form/header.jsp"%>
	
	<article style="height: 800px;">
		<section id="main">
			<div id=join class="head_title">
				<h1>Q&A 작성</h1>
				<hr size="2" color="grey">
			</div>
			<div id="mainWrap">
				<div id="topWrap">

					<p>${dto.title }</p>
					<p>${dto.writer }</p>
					<p><%=regdate%>&nbsp;&nbsp;조회&nbsp;${dto.readcount}

						<%
							if (role.equals("A")) {
						%>
						<input type="button" value="답글"
							onclick="location.href='QnaController.do?command=reply&parentno=${dto.no }&me_no=${dto.me }'">
						<%
							}
						%>
						
						<c:if test="${dto.writer ne '관리자' }">
							<c:if test="${dto.me eq me_no}">
								<input type="button" value="수정"
								onclick="location.href='QnaController.do?command=update&no=${dto.no }&writerno=${dto.me }'">
								<input type="button" value="삭제"
								onclick="location.href='QnaController.do?command=delete&no=${dto.no }&writerno=${dto.me }'">
								<input type="button" value="목록" onclick="location.href='QnaController.do?command=qna&curPage=1'">
							</c:if>
						</c:if>
						<c:if test="${dto.me eq me_no}">
							<c:if test="${dto.writer eq '관리자' }">
								<input type="button" value="수정" disabled>
								<input type="button" value="삭제" disabled>
								<input type="button" value="목록" onclick="location.href='QnaController.do?command=qna&curPage=1'">
							</c:if>
						</c:if>
						<c:if test="${dto.me ne me_no}">
							<input type="button" value="수정" disabled>
							<input type="button" value="삭제" disabled>
							<input type="button" value="목록" onclick="location.href='QnaController.do?command=qna&curPage=1'">
						</c:if>
						<c:if test="${role eq 'A'}">
							<input type="button" value="수정" disabled>
							<input type="button" value="삭제"
							onclick="location.href='QnaController.do?command=deleteA&no=${dto.no }&writerno=${dto.me }'">
							<input type="button" value="목록" onclick="location.href='QnaController.do?command=qna&curPage=1'">
						</c:if>
					</p>
				</div>
				<hr>
				<div id="bottomWrap">
					<c:if test="${dto.img ne null }">
						<img style="width: 400px; height: 350px;"
							src="/BlackINK/img/${dto.img }">
						<p>${dto.content }</p>
					</c:if>
					<c:if test="${dto.img eq null }">
						<p>${dto.content }</p>
					</c:if>
				</div>

			</div>
		</section>

	</article>
	
	<%@ include file="./form/rightNavi.jsp"%>
	<%@ include file="./form/leftNaviQna.jsp"%>
	<%@ include file="./form/footer.jsp"%>
</body>
</html>