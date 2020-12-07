<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/main.css">
</head>
<body>
<%@ include file="./form/header.jsp" %>

<article id="mainArticle"> 

	<section id="imageSection">
		
		<div id="imageWrap">
			<div id="textList">
				<p id="mainText">#나만의 타투 도안</p>
				<p id="subText">드로잉 캔버스, 이미지 검색으로 원하는 타투 도안을<br/>찾아보세요.</p>
			</div>
			<ul id="imageList">
				<li>
					<a href="NoticeController.do?command=notice&curPage=1"><img src="/BlackINK/img/yuri1.png"></a>
				</li>
				<li>
					<a href="ReviewController.do?command=review&curPage=1"><img src="/BlackINK/img/yuri7.png"></a>
				</li>
				<li>
					<a href="m2_profile.jsp"><img src="/BlackINK/img/ziwha5.png"></a> 
				</li>
			</ul>
		</div>
	</section>
</article>

<%@ include file="./form/rightNavi.jsp" %>
<%@ include file="./form/footer.jsp" %>
</body>
</html>