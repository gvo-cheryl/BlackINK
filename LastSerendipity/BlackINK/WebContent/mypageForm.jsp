<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
      var me_birth = $("input:text[name=me_birth]").val();
      
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
      
      if(me_birth == null || me_birth == ""){
    	  me_birth
      }
      
      $("form#updateform").submit();
   }
</script>
<style type="text/css">
body{background: ghostwhite;}
article{width:900px; height: 500px; position: relative; left: 25%;}
input[type=button]{
  background-color: black;
  color: white;
  border-radius: 5px 5px 5px 5px;
  height: 30px;
  width: 50px;
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
.info td, .info th{height: 2%;}
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
.head_title {
   margin-top: 30px;
   margin-bottom: 30px;
}
.head_title > h1 {
   padding-right: 30px;
   text-align: right;
}
#button_th {
   padding-right: 100px;
   padding-top: 50px;
}
</style>
</head>
<body>
<%@ include file="./form/header.jsp" %>
<article>
<div id=join class="head_title">
   <h1>내정보 관리</h1>
   <hr>
</div>
<br />
<form id="updateform" action="update.do" method="post">
<input type="hidden" name="command" value="updateform"/>
<input type="hidden" name="me_no" value="${myinfo.me_no}"/>
<input type="hidden" name="me_phone"/>
<input type="hidden" name="me_email" value="${myinfo.me_email }"/>
<br/><br/>
   <table class=info>
      <tr>
         <th>이름</th>
            <td>${myinfo.me_name}</td>
      </tr>
      <tr>
		   <th>EMAIL</th>
		   <td>${myinfo.me_email}</td>
      </tr>
      <tr>
         <th>비밀번호</th>
            <td><input type="password" name="me_pw" value="${myinfo.me_pw }" style="height:25px; width:250px;"/></td>
      </tr>
      <tr>
         <th>비밀번호확인</th>
            <td><input type="password" name="me_pwck" value="${myinfo.me_pw }" style="height:25px; width:250px;"/></td>
      </tr>
      <tr>
         <th>휴대전화</th>
            <td>
               <c:set var="me_phone" value="${myinfo.me_phone }"/>
               <c:set var="p1" value="${fn:substring(me_phone,0,3 )}"/>
               <c:set var="p2" value="${fn:substring(me_phone,4,8 )}"/>
               <c:set var="p3" value="${fn:substring(me_phone,9,13) }"/>
                  <input type="text" name="me_phone1" value="${p1}" style="height:25px; width:50px;"/><span>  -</span>
                  <input type="text" name="me_phone2" value="${p2}" style="height:25px; width:50px;"/><span>  -</span>
                  <input type="text" name="me_phone3" value="${p3}" style="height:25px; width:50px;"/>
            </td>
      </tr>
      <tr>
         <th>생년월일</th>
            <c:choose>
               <c:when test = "${empty myinfo.me_birth }">
                  <td><input type="date" name="me_birth"/> </td>
               </c:when>
               <c:otherwise>
                  <td><input type="date" name="me_birth" value="${myinfo.me_birth}" readonly="readonly" /></td>
               </c:otherwise>
            </c:choose>
      </tr>
      <tr>
         <td colspan="2" align="right">
            <div id="button_th">
               <input type="button" value="수정" onclick="javascript:update();"/>
               <input type="button" value="취소" onclick="location.href='mypage.do?command=mypage&me_no=${myinfo.me_no}'"/>
               <input type="button" value="탈퇴" onclick="location.href='delete.do?me_no=${myinfo.me_no}'"/>
            </div>
         </td>
      </tr>
         
   </table>
</form>
</article>
<br/>
<%@ include file="./form/rightNavi.jsp" %>
<%@ include file="./form/leftNavi.jsp" %>
<%@ include file="./form/footer.jsp" %>

</body>
</html>