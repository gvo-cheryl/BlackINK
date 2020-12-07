<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
#join{
  background-color: #D8D8D8;
  width: 800px;
  height: 50px;
  position: relative;
  margin: auto;
  top: -9px;
  
 
}
h1{
  position: relative;
  right: 255px;
  top: 3px;
}
h2{
  text-align: center;
  font-size: 15px;
  position: relative;
  right: 350px;
  top: -3px;
  
}
hr{
  position: relative;
  top: 600px;
}
.info{
  position: relative;
  align: center;
  top: -10px;
  margin: auto;
}
#idche{
  background-color: black;
  color: white;
  border-radius: 5px 5px 5px 5px;
  height: 30px;
  width: 80px;
  position: relative;
  top: -4px;
}
#addrck{
  background-color: black;
  color: white;
  border-radius: 5px 5px 5px 5px;
  height: 30px;
  width: 80px;
  position: relative;
  top: -4px;
}
th{
  text-align: left;
  font-size: 10pt;
}
.add_line{
  position: relative;
  left: 1px;
  right: 1px;
}
input{
  margin-top: 15px;
  margin-left: 10px;
  position: relative;
  top: -5px;
}
input[type=radio]{
    width: 12px;
    height: 12px;
    
}
label{
  font-size: 10pt;
  position: relative;
  top: -5px;
}
span{
  position: relative;
  top: -5px;
}
input[type=tel]{
  margin-right: 8px;
}
input[type=date]{
  height:25px;
  width:250px;
}
input[type=submit]{
  background-color: black;
  color: white;
  border-radius: 5px 5px 5px 5px;
  height: 30px;
  width: 80px;
}
input[type=button]{
  background-color: black;
  color: white;
  border-radius: 5px 5px 5px 5px;
  height: 30px;
  width: 80px;
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	show_form();
});

function show_form(){
	var me_role = $("input:radio[name=me_role]:checked").val();
		
	if(me_role=="U"){
		$("tr#me_name_tr").show();
		$("tr#me_nic_tr").hide();
	}else if(me_role=="T"){
		$("tr#me_nic_tr").show();
		$("tr#me_name_tr").hide();
	}
}

function fn_signup_check()
{
	var me_role = $("input:radio[name=me_role]:checked").val();
	var me_name = $("input:text[name=me_name]").val();
	var me_nic = $("input:text[name=me_nic]").val();
	var me_email = $("input:text[name=me_email]").val();
	var me_pw = $("input:password[name=me_pw]").val();
	var me_pwck = $("input:password[name=me_pwck]").val();
	var me_phone1 = $("input:text[name=me_phone1]").val();
	var me_phone2 = $("input:text[name=me_phone2]").val();
	var me_phone3 = $("input:text[name=me_phone3]").val();
	var me_birth= $("input[name=me_birth]").val();
	var me_phone = me_phone1 + "-" + me_phone2 + "-" + me_phone3;
	
	$("input:hidden[name=me_phone]").val(me_phone);
	
	console.log("me_role:::", me_role);
	console.log("me_name:::", me_name);
	console.log("me_email:::", me_email);
	console.log("me_pw:::", me_pw);
	console.log("me_pwck:::", me_pwck);
	console.log("me_phone1:::", me_phone1);
	console.log("me_phone2:::", me_phone2);
	console.log("me_phone3:::", me_phone3);
	console.log("me_phone:::", me_phone);
	
	if(me_role == "U"){
		if(me_name == null || me_name == ""){
			alert("이름을 입력해주세요");
			$("input:text[name=me_name]").focus();
			return false;
		}
	} else if(me_role =="T"){
		if(me_nic == null || me_nic == ""){
			alert("닉네임을 입력해주세요");
			$("input:text[name=me_nic]").focus();
			return false;
		}
	}
	
	if(me_email == null || me_email == ""){
		alert("email주소를 입력해주세요");
		return false;
	}
	
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
	
	if(me_birth == null || me_birth == ""){
		alert("생년월일을 입력해주세요");
		return false;
	}

	var chk = document.getElementsByName("me_email")[0].title;
	console.log("chk: ",chk);
	if(chk != "y"){
		alert("EMAIL 중복체크를 해주세요");
		return false;
	}
	
	$("form#signupForm").submit();
}

function emailck(){
	var doc = document.getElementsByName("me_email")[0];
	if(doc.value == null || doc.value.trim() == ""){
		alert("email을 입력해주세요");
		frm.me_email.focus();
	}else{
		open("emailck.do?command=emailck&me_email="+doc.value,"email중복체크", "width=300px,height=100px");
	}
}


</script>
</head>
<body>
<%@ include file="./form/header.jsp" %>
<div id=join>
  <h1>회원가입</h1> 
</div>

<div><h2>기본정보</h2></div>
<br/>
<hr/>

<form id="signupForm" action="regist.do" method="post">
<input type="hidden" name="me_phone"/>
	

	
	<table class=info>
		<tr>
			<th>구   분</th>
			<td>
			<input type="radio" name="me_role" checked onclick="show_form();" value="U"/>
			<label for="normal">일반회원</label>
			<input type="radio" name="me_role" onclick="show_form();" value="T"/>
			<label for="tattoo">타투이스트회원</label></td>
		</tr>
		<tr id="me_name_tr" style="display: none">
			<th>이    름</th>
			<td><input type="text" name="me_name" style="height:25px; width:250px;"/></td>
		</tr>
		
	    <tr id="me_nic_tr" style="display: none">
		    <th>닉네임</th>
		    <td><input type="text" name="me_nic" style="height:25px; width:250px;" id="me_nic"/></td>
		</tr>
		<tr>
			<th>EMAIL</th>
			<td><input type="text" name="me_email" style="height:25px; width:250px;" title="n"/>
				<button type="button" id="idche" onclick="emailck();">중복확인</button>
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="me_pw" style="height:25px; width:250px; " /></td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td><input type="password" name="me_pwck" style="height:25px; width:250px;"/></td>
		</tr>
		<tr>
			<th>휴대전화</th>
			<td><input type="text" name="me_phone1" style="height:25px; width:50px;"/><span>  -</span>
			<input type="text" name="me_phone2" style="height:25px; width:50px;"/><span>  -</span>
			<input type="text" name="me_phone3" style="height:25px; width:50px;"/></td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><input type="date" name="me_birth" id="me_birth" size="50"/></td>
		</tr>
	
		<tr> 
			<td colspan="3" align="center">
				<input type="button" value="가입" onclick="javascript:fn_signup_check();"/>
				<input type="button" value="취소" onclick="main.jsp"/>
			</td>
		</tr>
	
	</table>
</form>
<br/>
<br/>
<br/>


<%@ include file="./form/footer.jsp" %>
</body>
</html>