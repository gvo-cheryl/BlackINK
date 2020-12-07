<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	body {
	   background-color: ghostwhite;
	}
	.head_title {
	   margin-top: 30px;
	   margin-bottom: 30px;
	}
	.head_title > h1 {
	   padding-right: 30px;
	   text-align: right;
	}
	form {
	   padding-left: 30px;
	}
	#tattooist, #apDate, #apTime, #plane,#sizeWidth,#sizeHeight, .color>div{
		display: inline-block;
		border-radius:1px;
		padding:4px;
		margin:1px;
		width: 100px;
		text-align: right;
		background: #dcdcdc;
	}
	.content > div{
		display: inline-block;
		width:347px;
		border-radius:1px;
		background: #dcdcdc;
	}
	.btn{
		padding:5px 20px;
		margin:5px 0;
		border:0;
		border-radius: 5px;
		font-weight: 700;
	}
	article{width:900px; height: auto; position: relative; left: 25%;}
	.head_title {
      margin-top: 30px;
      margin-bottom: 30px;
   }
   .head_title > h1 {
      padding-right: 30px;
      text-align: right;
   }
</style>

<%
	if(session.getAttribute("me_no") == null){
			%>
			<script type="text/javascript">
				alert("로그인 후 다시 진행해주세요!");
				location.href="login.do";
			</script>	
			<%
	}
%>

</head>
<body>
<%@ include file="./form/header.jsp" %>
<article>
<div id=join class="head_title">
  <h1>예약하기</h1> 
  <hr>
</div>

	<form id="apForm" action="appointment.do" method="post">
		<input type="hidden" name="command" value="insertAppointmentRes">
		<div class="">
			<div class="artist">
				<div id="tattooist">타투이스트 : </div>
				<select name="ti_tno">
					<c:forEach items="${list }" var="dto">
						<option value="${dto.me_no }">${dto.me_nic }</option>
					</c:forEach>
				</select>
			</div>
			<div class="date">
				<div id="apDate">예약일 : </div>
				<input type="date" name="ti_date" required="required"  autocomplete="off">
				<br>
				<div id="apTime">시간 : </div>
				<input type="time" name="ti_time" required="required"  autocomplete="off">
			</div>
			<div class="placement">
				<div id="plane">부위 : </div>
				<input type="text" name="placement" required="required"  autocomplete="off">
			</div>
			<br/>
			<div class="size">
				<div>Size</div>
				<span id="sizeWidth">가로 : </span><input type="text" name="width" autocomplete="off"><br>
				<span id="sizeHeight">세로 : </span><input type="text" name="height" autocomplete="off">
			</div>
			<br/>
			<div class="color">
				<div>Color : </div>
				<input type="radio" name="color" value="Color" checked>Color
				<input type="radio" name="color" value="No Color">No Color
			</div>
			<br/>
			<div class="content">
				<div>상세 설명</div><br/>
				<textarea rows="5" cols="50" name="ti_content" autocomplete="off" style="resize:none;"></textarea>
			</div>
			<br/>
			<div class="submit">
				<input class="btn" type="submit" value="예약하기">
				<input class="btn" type="button" value="뒤로가기" onclick="history.back();">
			</div>
		</div>
	</form>
	</article>




<br/>
<br/>
<br/>

<%@ include file="./form/footer.jsp" %>
</body>
</html>