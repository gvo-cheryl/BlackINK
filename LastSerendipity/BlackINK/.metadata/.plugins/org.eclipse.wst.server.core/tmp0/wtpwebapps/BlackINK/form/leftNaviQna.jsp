<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
aside {
		position: absolute;
		top: 200px;
		left: 50px;
		width: 250px;
		height: 300px;
	}

#navi p {
	font-size: 25pt;
	font-weight: bold;
}

#navi ul li{
	font-size: 18pt;
	margin-top: 10px;
}
#navi ul li a:hover li{
	color:red;
}

</style>
</head>
<body>

<aside> 
		<div id="navi">
			<p>Q&A</p>
			<br/>
			<ul> 
				<li><a href="QnaController.do?command=qna&curPage=1">-공지사항</a></li> 
			</ul> 
		</div>
</aside>



</body>
</html>