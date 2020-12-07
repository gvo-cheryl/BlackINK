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
<body>
<%@ include file='./form/header.jsp' %>	
<%

	String name = (String)(session.getAttribute("me_name"));
	String role = (String)(session.getAttribute("me_role"));
	System.out.println(role + "이 당신의 역할!");
	String A = "A";

	if (role == null) {
		String result = "<script> alert ('로그인을 먼저 해주세요.'); location.href=\"login.do\"; </script>";
		response.getWriter().append(result);
	} else if(role.equals(A) ? false : true) {
		String result = "<script> alert ('관리자가 아닙니다.'); location.href=\"NoticeController.do?command=notice&curPage=1\"; </script>";
		response.getWriter().append(result);
	}

%>
<article>
	<section id="main">
		<h3>공지사항 작성</h3>
		<hr size="2" color="grey">
		
		<form action="NoticeController.do?command=insertform" method="post">
		<!-- multipart/form-data 형식으로 보낸 데이터는 문자열이든 사진이든 상관없이 Stream 방식으로 전송된다. -->
		<!-- request.getInputStream() 메서드가 반환한 ServletInputStream객체를 통해 데이터를 전달받을 수 있다. -->
		
			<table>
				<tr>
					<input type="text" placeholder="제목을 입력하세요." name="title" />
				</tr>
				<tr>
					<input type="text" readonly="readonly" value="<%=name %>" name="writer">
				</tr>
				<tr>
					<textarea cols="30" rows="30" name="content" ></textarea>
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
<%@ include file="./form/leftNaviStory.jsp" %>
<%@ include file='./form/footer.jsp' %>	
</body>
</html>