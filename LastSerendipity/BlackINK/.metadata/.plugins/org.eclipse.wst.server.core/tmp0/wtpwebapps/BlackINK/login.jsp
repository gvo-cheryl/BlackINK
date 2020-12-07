<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script><base>


<style>
.kakaoLogin{
	width:260px;
}
.naverLogin{
  width: 260px;
  height: 40px;
}

#login{
  background-color: black;
  color: white;
  width: 250px;
  height: 40px;
  border-radius: 5px 5px 5px 5px;
  position: relative;
  top: 16px;
}
#etc1{
  position:relative;
  top: 35px;
  font-size: 11pt;

  
}
#searchForm{
	position: relative;
  	top: 45px;
  	left: 680px;
  	font-size:11pt;
  
}
a{
    text-decoration: none;
    color: black;
}
</style>

</head>
<body>
<%@ include file="./form/header.jsp" %>

<form action="loginProc.do" method="post">
<table class=login>

<tr>
  <th>간편 로그인</th>
</tr>

<tr>
<td colspan="2" align="center"><a href="https://kauth.kakao.com/oauth/authorize?client_id=8dd6130d0174adb454a46327cd12adb2&redirect_uri=http://localhost:8787/BlackINK/kakaoOauth.do&response_type=code">
 <img class=kakaoLogin alt="kakao" src="resources/img/kakao_login.png"></a></td>
</tr>

</tr>
<tr>
</tr>
<tr>
</tr>
<tr>
</tr>

<tr>
  <th>EMAIL: </th>
  <td><input type="text" name="me_email" style="height:20px;"/></td>
</tr>

<tr>
  <th>PW: </th>
  <td><input type="password" name="me_pw" style="height:20px;"/></td>
</tr>

</table>

<div align=center>
    <input type="submit"id=login value="LOGIN"/>
    
</div>

<div align=center id=etc1>
    <a href="regist.jsp"><h4>회원가입</h4></a>
</div>

<table id="searchForm">
	<th><a href="searchEmail.jsp">email찾기</a></th>
	<th>/</th>
	<th><a href="searchPw.jsp">비밀번호 찾기</a></th>
</table>

</form>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>

<%@ include file="./form/footer.jsp" %>
</body>
</html>