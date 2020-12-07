<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="./form/footer.jsp" %>

<h1>UPDATE ROLE</h1>
	<form action="mypage.do?command=updateRoleres" method="post">
		<input type="hidden" name="command" value="updateroleres"/>
		<input type="hidden" name="me_no" value="${dto.me_no }"/>
		<table border="1">
		<col width="100">
		<col width="200">
			<tr>
				<th>NO</th>
				<td>${dto.me_no }</td>
			</tr>
			<tr>
				<th>EMAIL</th>
				<td>${dto.me_email }</td>
			</tr>
			<tr>
				<th>ROLE</th>
				<td>
					<select name="me_role">
						<option value="U" <c:if test="${dto.me_role eq 'U' }">selected</c:if>>일반회원</option>
						<option value="T" <c:if test="${dto.me_role eq 'T' }">selected</c:if>>타투이스트</option>
						<option value="A" <c:if test="${dto.me_role eq 'A' }">selected</c:if>>관리자</option>						
					</select>					
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="button" value="취소" onclick="location.href='mypage.do?command=mypage&me_no=1'"/>
					<input type="submit" value="변경"/>
				</td>
			</tr>
		</table>
	
	</form>	
	
<%@ include file="./form/footer.jsp" %>
<%@ include file="./form/rightNavi.jsp" %>	

</body>
</html>