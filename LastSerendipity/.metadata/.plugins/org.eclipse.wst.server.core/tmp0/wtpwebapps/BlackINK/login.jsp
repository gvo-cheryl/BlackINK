<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<base>


<style>
body{background: ghostwhite}
#total{position: relative; margin-top: 5%; height: 400px;}
.kakaoLogin {
	width: 260px;
}

.naverLogin {
	width: 260px;
	height: 40px;
}

#login {
	background-color: black;
	color: white;
	width: 250px;
	height: 40px;
	border-radius: 5px 5px 5px 5px;
	position: relative;
	top: 16px;
}

#searchForm {
	position: relative;
	top: 45px;
	left: 680px;
	font-size: 11pt;
}



.login th, .login td{padding-bottom: 1%;}
#bottom{position: relative; margin-top: 2%;}
#bottom div{margin-bottom: 1%;}
#bottom div a {
	text-decoration: none;
	color: black;
}
#simpleLogin{margin: 1%;}
#naver{width:260px; height:40px; cursor: pointer;}
</style>

</head>
<body>
	<%@ include file="./form/header.jsp"%>
<div id="total" align="center">
	<div align="center" id="simpleLogin"><h3>간편로그인</h3></div>
	<form action="loginProc.do" method="post">
		<table class=login>
			<tr>
				<td colspan="2" align="center">
					<div id="naver_id_login" style="display: none;"></div>
					<div onclick="document.getElementById('naver_id_login_anchor').click();">
						<img src="./img/naverLogin.PNG" alt="" id="naver">
					</div>
					 <script type="text/javascript">
					  	var naver_id_login = new naver_id_login("DirPUiWRqkBadpSSyuGE", "http://localhost:8787/BlackINK/naver_callback.jsp");
					  	var state = naver_id_login.getUniqState();
					 	
					  	naver_id_login.setButton("green", 3, 45);
					  	naver_id_login.setDomain("http://localhost:8787/BlackINK/");
					  	naver_id_login.setState(state);
					  	//naver_id_login.setPopup();
					  	naver_id_login.init_naver_id_login(); 
					  </script>
				 </td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a
					href="https://kauth.kakao.com/oauth/authorize?client_id=8dd6130d0174adb454a46327cd12adb2&redirect_uri=http://localhost:8787/BlackINK/kakaoOauth.do&response_type=code">
						<img class=kakaoLogin alt="kakao"
						src="resources/img/kakao_login.png">
				</a></td>
			</tr>
			<tr>
				<th>EMAIL:</th>
				<td><input type="text" name="me_email" style="height: 20px; width:180px;" /></td>
			</tr>

			<tr>
				<th>PW:</th>
				<td><input type="password" name="me_pw" style="height: 20px; width: 180px;" /></td>
			</tr>
		</table>

		<div>
			<input type="submit" id=login value="LOGIN" />
		</div>
		<div id="bottom">
			<div align="center"><a href="regist.jsp"><b>회원가입</b></a></div>
			<div align="center"><a href="searchEmail.jsp"><b>email찾기</b></a></div>
			<div align="center"><a href="searchPw.jsp"><b>비밀번호 찾기</b></a></div>
			<div onclick="location.href='NaverLoginCallback.do?command=join'">버튼</div>
		</div>

	</form>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
</div>
<%@ include file="./form/rightNavi.jsp" %>
	<%@ include file="./form/footer.jsp"%>
</body>
</html>