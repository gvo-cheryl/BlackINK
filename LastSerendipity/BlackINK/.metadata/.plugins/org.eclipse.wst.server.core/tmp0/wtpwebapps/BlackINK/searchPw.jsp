<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function searchPw(){
		var me_email= $("input:text[name=me_email]").val();
		var me_birth= $("input[name=me_birth]").val();
		var me_phone1 = $("input:text[name=me_phone1]").val();
		var me_phone2 = $("input:text[name=me_phone2]").val();
		var me_phone3 = $("input:text[name=me_phone3]").val();
		var me_phone = me_phone1 + "-" + me_phone2 + "-" + me_phone3;
		
		$("input:hidden[name=me_phone]").val(me_phone);
			
		if(me_email == null || me_email == ""){
			alert("email을 입력해주세요");
			return false;
		}
		if(me_birth == null || me_birth == ""){
			alert("생년월일을 입력해주세요");
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
		
		$("form#searchPw").submit();
		
	}
</script>
<style type="text/css">
input[type=button]{
  background-color: black;
  color: white;
  border-radius: 5px 5px 5px 5px;
  height: 30px;
  width: 80px;
}


input{
  margin-top: 15px;
  margin-left: 10px;
  position: relative;
  top: -5px;
}
input[type=date]{
  height:25px;
  width:250px;
}
input[type=text]{
  height:25px;
  width:250px;
}
span{
  position: relative;
  top: -5px;
}
th{
  text-align: left;
  font-size: 10pt;
}

</style>
</head>
<body>
<%@ include file="./form/header.jsp" %>
<form id="searchPw" action="searchPw.do" method="post">
<input type="hidden" name="me_phone"/>
<table>
	<tr>
		<th>EMAIL</th>
			<td><input type="text" name="me_email"/></td>
	</tr>
	<tr>
		<th>생년월일</th>
			<td><input type="date" name="me_birth"/></td>
	</tr>
	<tr>
		<th>휴대전화</th>
			<td><input type="text" name="me_phone1" style="height:25px; width:50px;"/><span>  -</span>
			<input type="text" name="me_phone2" style="height:25px; width:50px;"/><span>  -</span>
			<input type="text" name="me_phone3" style="height:25px; width:50px;"/></td>
	</tr>
	<tr>
		<td colspan="3" align="center">
		<input type="button" value="찾기" onclick="javascript:searchPw();"/>
		<input type="button" value="취소" onclick="location.href=login.jsp"/></td>
	</tr>
	<tr height="30">
		<td colspan="2" align="center">
			<font color="red"><b>${message }</b></font>
		</td>
	</tr>
		
</table>
</form>
<br/>
<br/>

<%@ include file="./form/footer.jsp" %>

</body>
</html>