<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 마이페이지</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="./js/adminAjax.js"></script>
<script type="text/javascript">

	function updateRole(me_no){
		//var me_role = $("#myrole option:selected").val();
		location.href="mypage.do?command=updateRole&me_no="+me_no;

	}
	
	function allchk1(bool){
		$("input[name=chk1]").each(function(){
			$(this).prop("checked", bool);
		});	
	}
	function allchk2(bool){
		$("input[name=chk2]").each(function(){
			$(this).prop("checked", bool);
		});	
	}
	
	$(function(){
		$("input[name=chk1]").click(function(){
			if($("input[name=chk1]").length == $("input[name=chk1]:checked").length){
				$("input[name=all_first]").prop("checked", true);
			} else {
				$("input[name=all_first]").prop("checked", false);
			}
		});	
		
		$("input[name=chk2]").click(function(){
			if($("input[name=chk2]").length == $("input[name=chk2]:checked").length){
				$("input[name=all_second]").prop("checked", true);
			} else {
				$("input[name=all_second]").prop("checked", false);
			}
		});	
	});



</script>
<style type="text/css">
body{background: ghostwhite;}
#body{width: 500px;}
#join{
  width: 800px;
  height: 50px;
  position: relative;
  margin: auto;
  top: -9px;
  text-align: center;
}
hr{
  position: relative;
  top: 600px;
}
#filter{position: relative; left: 38%; top:20px;}
fieldset{width:400px; padding:5px; display: inline-table;}
#in_1{position:relative; display: inline-table; margin: 0; padding: 0; }  
#in_2{position:relative;  display: inline-table; margin: 0; padding: 0; top:5px;}  
p > a{margin-top: 10px;}
label{margin-bottom: 10px;}
#List{position: relative; margin: 100px; left:5%;}
#middle > p{margin:10px; padding:10px;}
.info{
  position: relative;
  align: center;
  top: -10px;
  margin: auto;
}
td{text-align: center;}

</style>
</head>
<body>
<%@ include file="./form/header.jsp" %>
<div id=join>
  <h1>전체 회원 정보 조회</h1> 
</div>
<br/>
<hr/>

<div id="filter">
	<form id="Form" method="post" enctype="multipart/form-data">
		<div id="middle">			
			<fieldset>
				<div id="in_1">
					<label for="reply"><b>활동여부</b></label>
						<input type="hidden" id="me_enabled" value="me_enabled"/>
						<input type="checkbox" name="all_first" value="all" onclick="allchk1(this.checked)"/>전체조회 
						<input type="checkbox" name="chk1" value="Y" />활동회원
						<input type="checkbox" name="chk1" value="N" />탈퇴회원 <br>
					<label for="reply"><b>회원구분</b></label>
						<input type="hidden" id="me_role" value="me_role"/>
						<input type="checkbox" name="all_second" value="all" onclick="allchk2(this.checked)"//>전체조회 
						<input type="checkbox" name="chk2" value="U" />일반회원 
						<input type="checkbox" name="chk2" value="T" />타투이스트
						<input type="checkbox" name="chk2" value="A" />관리자 
				</div>
				<div id="in_2">
					<input type="button" value="조회" style="width:50px; height:40px;" id="submit"/>
				</div>
			</fieldset>
		</div>
	</form>
</div>

<table class="info" border="1" id="List">
	<col width="100px">
	<col width="100px">
	<col width="300px">
	<col width="100px">
	<col width="200px">
	<col width="200px">
	<col width="100px">
	<col width="100px">
	<col width="100px">
	<tr>
		<th>no</th>
		<th>회원번호</th>
		<th>이메일(ID)</th>
		<th>이름</th>
		<th>닉네임</th>
		<th>연락처</th>
		<th>활동구분</th>
		<th>SNS연동</th>
		<th colspan="2">회원구분</th>
	</tr>
	<c:choose>
		<c:when test="${empty list }">
			<th colspan="8" align="center">------ 조회 결과가 없습니다. ------</th>
		</c:when>
		<c:otherwise>
			<c:forEach items="${list }" var="dto" varStatus="status">
				<tr class="list">
					<td>${fn:length(list) - ((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage + status.index) }
						</td>
					<td>${dto.me_no }</td>
					<td>${dto.me_email }</td>
					<td>${dto.me_name }</td>
					<td>${dto.me_nic }</td>
					<td>${dto.me_phone }</td>
					<td>
						<c:choose>
							<c:when test="${dto.me_enabled eq 'Y' }">
								활동회원
							</c:when>
							<c:otherwise>
								탈퇴회원
							</c:otherwise>
						</c:choose>
					</td>
					<td>${dto.me_sns_type }</td>
					<td>
						<c:choose>
							<c:when test="${dto.me_role eq 'U'}">
								일반회원
							</c:when>
							<c:when test="${dto.me_role eq 'T'}">
								타투이스트
							</c:when>
							<c:otherwise>
								관리자
							</c:otherwise>
						</c:choose>
	
						<%-- <select name="myrole" id="myrole">
							<option value="U" <c:if test="${dto.me_role eq 'U' }">selected</c:if>>일반회원</option>
							<option value="T" <c:if test="${dto.me_role eq 'T' }">selected</c:if>>타투이스트</option>
							<option value="A" <c:if test="${dto.me_role eq 'A' }">selected</c:if>>관리자</option>						
						</select>	 --%>
					</td>
					<td><input type="button" value="변경" onclick="updateRole(${dto.me_no});" id="update"></td>
				
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>




<%@ include file="./form/rightNavi.jsp" %>
<%@ include file="./form/footer.jsp" %>
<%@ include file="./form/rightNavi.jsp" %>
</body>
</html>




































