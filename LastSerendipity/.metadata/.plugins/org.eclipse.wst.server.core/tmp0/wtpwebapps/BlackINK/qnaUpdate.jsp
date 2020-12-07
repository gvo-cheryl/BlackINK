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
body {
	background: ghostwhite;
}

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

.head_title {
	margin-top: 30px;
	margin-bottom: 30px;
}

.head_title>h1 {
	padding-right: 30px;
	text-align: center;
}
</style>
<%
String name = (String) (session.getAttribute("me_name"));
String nic = (String) (session.getAttribute("me_nic"));
QnaDto dto = new QnaDto();
dto = (QnaDto) (request.getAttribute("dto"));
String writer = dto.getWriter();
System.out.println(writer + name);

if (session.getAttribute("me_no") == null) {
%>
<script type="text/javascript">
	alert("세션 빔. 로그인 후 다시 진행해주세요!");
	location.href = "login.do";
</script>
<%
	}

if (name == null && nic == null) {
	String result = "<script> alert ('로그인을 먼저 해주세요.'); location.href=\"login.do\"; </script>";
	response.getWriter().append(result);
} else if (writer.equals(name)) {
	System.out.println("name과 writer가 같다.");
} else if (writer.equals(nic)) {
	System.out.println("nic과 writer가 같다");
} else {
	System.out.println("nic과 writer가 일치하지 않음");
	String result = "<script> alert ('작성자가 아닙니다.'); location.href=\"QnaController.do?command=qna&curPage=1\"; </script>";
	response.getWriter().append(result);
}
%>
<body>
	<link type="text/css" rel="stylesheet" href="./css/insert.css">
	<%@ include file='./form/header.jsp'%>
	<article>
		<section id="main">
			<div id=join class="head_title">
				<h1>Q&A 수정</h1>
				<hr size="2" color="grey">
			</div>

			<div id="mainWrap">
				<form action="QnaController.do?command=updateform" method="post">
					<input type="hidden" value="<%=dto.getNo()%>" name="no">
					<div id="topWrap">
						<select name="category">
							<option value="개인정보/로그인">개인정보/로그인</option>
							<option value="도안상담">도안상담</option>
							<option value="타투이스트">타투이스트</option>
							<option value="에약/예약취소">예약/예약취소</option>
							<option value="결제/결제취소">결제/결제취소</option>
							<option value="기타">기타</option>
						</select> <input class="topTitle" type="text" value="<%=dto.getTitle()%>"
							name="title" /> <input class="topName" type="text"
							value="<%=dto.getWriter()%>" name="writer" readonly="readonly">

					</div>

					<hr>

					<div id="bottomWrap">
						<textarea cols="130" rows="20" name="content"
							style="resize: none;"><%=dto.getContent()%></textarea>

					</div>
					<div id="buttonWrap">
						<input type="button" value="취소" style="float: right"
							onclick="location.href='QnaController.do?command=qna&curPage=1'">
						<input type="submit" value="완료" style="float: right">
					</div>
				</form>
			</div>

		</section>

	</article>
	<%@ include file="./form/rightNavi.jsp"%>
	<%@ include file="./form/leftNaviQna.jsp"%>
	<%@ include file="./form/footer.jsp"%>
</body>
</html>