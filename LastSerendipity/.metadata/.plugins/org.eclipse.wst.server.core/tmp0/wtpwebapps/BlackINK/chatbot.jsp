<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

	* {
		margin: 0;
		padding: 0;
	}
	
	iframe {
		margin: 5px;
	}

</style>

</head>
<body>

	<iframe allow="microphone;" width="95%" height="500px;"
		src="https://console.dialogflow.com/api-client/demo/embedded/319c9415-fbfa-44f9-9367-fa642ef96813">
	</iframe>

</body>
</html>