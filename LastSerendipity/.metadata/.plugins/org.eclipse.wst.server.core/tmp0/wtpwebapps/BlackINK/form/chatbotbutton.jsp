<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

#chatbotStartButton {

		margin: 0;
		padding: 0;
		width: 50px;
		height: 50px;
		border-radius: 20px 20px 20px 20px;
		background-image: url(img/chatbotbutton.png);
		background-size: 100%, 100%;
		background-repeat: no-repeat;
		border: none;
		
	}
	
#chatbot_button {

	margin: 0;
	padding: 0;
	width: 50px;
	height: 50px;
	position: fixed;
	right: 100px;
	top: 700px;
	
}
	
</style>

<script type="text/javascript">

	function chatbotStart(){
		
		var url = "chatbot.jsp";
		var title = "Black INK FAQ chatbot";
		var prop = "top=300px,left=800px,width=365px,height=820px,resizable=no,fullscreen=no,location=no";
		
		window.open(url, title, prop);
		
	}

</script>

</head>
<body>

	<div id="chatbot_button">
		<button id="chatbotStartButton" onclick="chatbotStart();" name="chatbotStartButton"></button>
	</div>

</body>
</html>