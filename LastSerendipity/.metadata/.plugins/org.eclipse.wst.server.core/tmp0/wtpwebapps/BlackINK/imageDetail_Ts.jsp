<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{background: ghostwhite;}
#img{width:500px; height:500px;}
.field{width: 1000px; position: relative; left: 40%; top:30px;}
.first, form {width: 200px; display: inline-table; margin: 0px; padding: 0px; margin-bottom: 0px; padding-bottom: 0;}
.last{position: relative; left: 15%; margin: 10px; padding: 10px;}
p{margin: 10px;,height:23.5px;}
.textform{width:240px;}
#bottom{height:200px;}
.button{width:60px; height:30px; position: relative;}


</style>
</head>
<body>
<%@ include file="./form/header.jsp"%>

<div class="field">
	<div>
		<img src="/BlackINK/img/${dto.im_servername }" id="img" alt="">
	</div>
	
	<div class="first">
				<div class="text">
					<p>타투이스트 </p>
					<p>Title </p>
					<p>Content</p>
					<p style="margin-bottom: 15%;">Keyword</p>
					<p>Text tag</p>
					<p>등록일</p>
				</div>
	</div>
	
	<form action="tattooshareController.do" method="post">
	<div class="first">
		<p><a href="profileController.do?command=goProfile&me_no=${dto.me_no }"><b>${dto.ts_writer }</b></a></p>
		<p>${dto.ts_title }</p>
		<p>${dto.ts_content }</p>
		<p style="width:300px;">
			<c:forEach items="${list }" var="tag" varStatus="i">
				<span>${tag.ta_labeltag },</span>
				<c:if test="${i.last }">
				<span>${tag.ta_labeltag }</span>
				</c:if>
			</c:forEach>
		</p>
		<p>${list[0].ta_texttag }</p>
		<p>${dto.ts_regdate }</p>
	</div>
	
	
	</form>
	
</div>

<div id="bottom"></div>
<%@ include file="./form/rightNavi.jsp" %>
<%@ include file="./form/footer.jsp"%>


</body>
</html>