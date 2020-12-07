<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<%
	String emailnotused = request.getParameter("emailnotused");
%>
<head>
<meta charset="UTF-8">
<title>EMAIL중복확인</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	onload=function(){
		var emailnotused = $("input:hidden[name=emailnotused]").val();
		
		if(emailnotused == "true"){
			opener.document.getElementsByName("me_email")[0].title="y";
		}else{
			opener.document.getElementsByName("me_email")[0].title="n";
		}
		
		
	}
	function EmailCk(bool){
		self.close();
	}
</script>
<style type="text/css">
button{
  background-color: black;
  color: white;
  border-radius: 5px 5px 5px 5px;
  height: 30px;
  width: 80px;
}
</style>
</head>
<body>

<div>
	<input type="hidden" name="emailnotused" value="<%=emailnotused%>"/>
	<%=emailnotused.equals("true")? "사용가능한 email입니다":"사용중인 email입니다" %>
	<br/>
	<button onclick="EmailCk('<%=emailnotused %>');">확인</button>
</div>
	
	
		
	

</body>
</html>