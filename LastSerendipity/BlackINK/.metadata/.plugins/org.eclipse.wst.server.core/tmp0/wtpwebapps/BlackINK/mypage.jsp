<%@page import="com.semi.tattoo.login.biz.LoginBiz"%>
<%@page import="com.semi.tattoo.location.biz.locationBiz"%>
<%@page import="com.semi.tattoo.login.dto.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYPAGE</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function update(){
		var me_pw = $("input:password[name=me_pw]").val();
		var me_pwck = $("input:password[name=me_pwck]").val();
		var me_phone1 = $("input:text[name=me_phone1]").val();
		var me_phone2 = $("input:text[name=me_phone2]").val();
		var me_phone3 = $("input:text[name=me_phone3]").val();
		var me_phone = me_phone1 + "-" + me_phone2 + "-" + me_phone3;
		
		$("input:hidden[name=me_phone]").val(me_phone);
		
		if(me_pw == null || me_pw == ""){
			alert("비밀번호를 입력해주세요");
			return false;
		}
		
		if(me_pwck == null || me_pwck == "" ){
			alert("비밀번호 다시 확인해주세요");
			return false;
		}
		
		if(me_pwck != me_pw){
			alert("비밀번호가 일치하지않습니다");
			return false;
		}
		if(me_phone1 == null || me_phone1 == ""){
			alert("휴대전화번호를 입력해주세요");
			return false;
		}
		
		if(me_phone2 == null || me_phone2 == ""){
			alert("휴대전화번호를 입력해주세요");
			return false;
		}
		
		if(me_phone3 == null || me_phone3 == ""){
			alert("휴대전화번호를 입력해주세요");
			return false;
		}
		
		$("form#updateform").submit();
	}
</script>
<style type="text/css">
article{width:800px; height: 500px; position: relative; left: 25%;}
#total{display: inline;}
input[type=button]{
  background-color: black;
  color: white;
  border-radius: 5px 5px 5px 5px;
  height: 30px;
  width: 50px;
}
#join{
  background-color: #D8D8D8;
  width: 800px;
  height: 50px;
  position: relative;
  margin: auto;
  top: -9px;
}
hr{
  position: relative;
  top: 600px;
}
th{
  text-align: left;
  font-size: 10pt;
}
.info{
  position: relative;
  align: center;
  top: -10px;
  margin: auto;
}
#join h1{
  position: relative;
  top: 3px;
}
h2{
  text-align: center;
  font-size: 15px;
  position: relative;
  right: 350px;
  top: -3px;
  
}
input{
  margin-top: 15px;
  margin-left: 10px;
  position: relative;
  top: -5px;
}
span{
  position: relative;
  top: -5px;
}

</style>
</head>
<body>
<%@ include file="./form/header.jsp" %>
<article>
<div id=join>
  <h1>내정보 관리</h1> 
</div>
<br/>
<hr/>
<form id="updateform" action="update.do" method="post">
<input type="hidden" name="command" value="updateform"/>
<input type="hidden" name="me_no" value="${myinfo.me_no}"/>
<input type="hidden" name="me_phone"/>
	<table class=info>
		<tr>
		<c:choose>
			<c:when test="${myinfo.me_role eq 'U'}">
				<th>이름</th>
					<td>${myinfo.me_name}</td>
			</c:when>
			<c:otherwise>
				<th>닉네임</th>
					<td>${myinfo.me_nic}</td>
			</c:otherwise>
		</c:choose>
		</tr>
		<tr>
			<th>EMAIL</th>
				<td>${myinfo.me_email}</td>
		</tr>	
		<tr>
			<th>휴대전화</th>
				<td>${myinfo.me_phone }</td>
		</tr>
		<tr>
			<th>생년월일</th>
				<td>${myinfo.me_birth}</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="수정" onclick="location.href='mypage.do?command=userUpdateForm&me_no=${myinfo.me_no}'"/>
			</td>
		</tr>
			
	</table>
</form>
</article>




<br/>
<br/>
<br/>

<% int me_no = Integer.parseInt(request.getParameter("me_no"));
	System.out.println(me_no); 
	LoginBiz biz = new LoginBiz();
	LoginDto myinfo = biz.myInfo(me_no);

	if(myinfo.getMe_role().equals("U")){
%>
	
	<%@ include file="./form/leftNavi.jsp" %>
	
<% } else if(myinfo.getMe_role().equals("T")){%>

	<%@ include file="./form/leftNavi_tattooist.jsp" %>

<% } %>
<%@ include file="./form/footer.jsp" %>

</body>
</html>























