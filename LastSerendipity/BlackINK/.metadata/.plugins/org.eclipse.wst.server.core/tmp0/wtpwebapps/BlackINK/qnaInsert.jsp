<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="UTF-8">
<head>
<meta charset="UTF-8" />
<title>QNA 글쓰기</title>
</head>

<% 
String name = (String)(session.getAttribute("me_name"));
String nic = (String)(session.getAttribute("me_nic"));
%>
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

<article>
	<section id="main">
     <h3>게시판 이미지 업로드 폼</h3>
		    <div id="mainWrap">
		    <form action="qnaUpload.jsp" method="post" enctype="multipart/form-data">
				<div id="topWrap">
					<input class="topTitle" type="text" placeholder="제목을 입력하세요." name="title" />
				
				
				<c:choose>
					<c:when test="${not empty sessionScope.me_name }">
							<input class="topName" type="text" value="<%=name%>" name="writer" readonly="readonly">
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
					<input type="file" name="upload"><br/>
					<input type="button" value="취소" style="float: right">
					<input type="submit" value="완료" style="float: right">
				</div>		
			</form>
			</div>
	</section>		
</article>			
<%@ include file="./form/leftNaviQna.jsp" %>	
<%@ include file="./form/footer.jsp" %>	
<style type="text/css">
	footer {
		 position: absolute;
    bottom: 0;
      background-color : ghostwhite;
       width: 100%;
      height: 80px;
      text-align: center;
      line-height: 30px;
	}
</style>
</body>
</html>