<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/livetalk.css">

</head>
<body>

<div class="livetalk">
	<div class="livetalk_header">1:1 상담</div>
	<div class="livetalk_body">
		<div id="livetalk_list">
		</div>
	</div>
	<div class="livetalk_footer">
		<div class="">
			<button>+</button>
			<textarea rows="1" cols="60" id="li_content" placeholder="메시지를 입력해주세요"></textarea>
			<button>전송</button>
		</div>
	</div>
</div>

</body>
</html>