<%@page import="com.semi.tattoo.tattooinfo.controller.Util"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
    <% response.setContentType("text/html; UTF-8"); %>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  

<script type="text/javascript" src="js/tCalendar.js"></script>
<script type="text/javascript">
	function listcaldetail(m,d){
		var hrefs = "tCalController.do?command=listcaldetail&ti_date=" + "&month=" + m + "&day=" + d;
		location.href = hrefs;
	}

	function listcaldetail2(){
		var startDate = $("#startDate").val();
		var endDate = $("#endDate").val();
		location.href = "tCalController.do?command=listcaldetail2&startDate=" + startDate	+ "&endDate=" + endDate;
	}
</script>
<style type="text/css">
	#updateInfoTable{
		border-radius: 2px;
		border:0;
		background : snow;
		position: absolute;
		height:250px;
		top:20%;
		left:20%;
		display:none;
	}
	#updateInfoTable th{
		width:120px;
		text-align: right;
	}
	#updateInfoTable td{
		padding: 3px;
		padding-left: 10px;
	}
	#updateInfoTable input {
		border:0;
		border-radius: 5px;
	}
	#updateInfoTable input[type=text] {
		width:100px;
	}
	#updateInfoTable input[type=button]{
		padding:5px 20px;
		margin:5px 0;
		border:0;
		border-radius: 5px;
		font-weight: 700;
	}

	.btn{
		padding:5px 20px;
		margin:5px 0;
		border:0;
		border-radius: 5px;
		font-weight: 700;
	}
	#listTable{
		font-size:14px;
		padding-left: 30px;
	}
	#listTable th{
		padding-bottom: 10px;
		border-bottom: 2px solid darkgray;
	}
	
	#listTable td{
		margin: 0 auto;
		text-align: center;
	}
	#listTable #btnth{
		border:0;
	}
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
	.sub_title {
	   padding-left: 30px;
	}
	article{width:900px; height: auto; position: relative; left: 25%;}
</style>
<body>
<%@ include file="./form/header.jsp" %>
<article>
<div id=join class="head_title">
  <h1>예약 내역</h1> 
</div>
<br/>
<hr/>
   
   <div class="sub_title">예약 내역 조회</div><br/>
   <div class="sub_title">
   <input class="btn" type="button" value="오늘" onclick="listcaldetail(0,0);"/>
   <input class="btn" type="button" value="1주일" onclick="listcaldetail(0,7);"/>
   <input class="btn" type="button" value="1개월" onclick="listcaldetail(1,0);"/>
   <input class="btn" type="button" value="3개월" onclick="listcaldetail(3,0);"/>
   <input type="text" id="startDate" autocomplete="off" /> ~
   <input type="text" id="endDate" autocomplete="off" />
   <input class="btn" type="button" value="조회" onclick="listcaldetail2();"/>
   </div><br/><br/><br/><br/>

      <jsp:useBean id="util" class="com.semi.tattoo.tattooinfo.controller.Util" ></jsp:useBean>
      
      <table id="listTable">
         <col width = "100px">
         <col width = "170px">
         <col width = "100px">
         <col width = "105px">
         <col width = "95px">
         <col width = "150px">
         <tr>
            <th>고객명</th>
            <th>시술 일자</th>
            <th>시술 금액</th>
            <th>예약일자</th>
            <th>예약 진행 현황</th>
            <th id="btnth"></th>
         </tr>
         
         <c:choose>
            <c:when test="${empty list }">
            <tr>
               
            </tr>
            </c:when>
            <c:otherwise>
               <c:forEach items="${list }" var ="dto">
               <tr>
                  <td>${dto.ME_NAME }</td>
                  <td>
                     <jsp:setProperty property="toDates" name="util" value="${dto.TI_DATE }${dto.TI_TIME }"/>
                     <jsp:getProperty property="toDates" name="util"/>
                  </td>
                  <td>${dto.TI_PAY }원</td>
                  <td>
                     <fmt:formatDate value="${dto.TI_REGDATE }" pattern ="yyyy년MM월dd일"/>
                  </td>
                  <td>
                  	<c:choose>
                  		<c:when test="${dto.TI_STATE  eq 'Y'}">
                  			<div>예약 완료</div>
                  		</c:when>
                  		<c:when test="${dto.TI_STATE eq 'N'}">
                  			<div style="color:red;">예약중</div>
                  		</c:when>
                  	</c:choose>
                  </td>
                  <td>
						<input class="btn" type="button" value="내용 변경" onclick="updateInfo(${dto.TI_NO});"/>               
                  </td>
               </tr>
               </c:forEach>
               </c:otherwise>
            </c:choose>
      </table>
      
      <table id="updateInfoTable">
      		<tr>
      			<th>고객명 : </th>
      			<td id="me_name">
      			</td>
      		</tr>
            <tr>
            	<th>시술 일자 : </th>
            	<td id="ti_date">
            		<input name='ti_date' type='text' autocomplete="off" value=''/>
            	</td>
            </tr>
            <tr>
            	<th>시술 시간 : </th>
            	<td id="ti_time">
            	    <input name='ti_time_hour' type='text' value=''/>시
            		<input name='ti_time_minute' type='text' value=''/>분
            	</td>
            </tr>
            <tr>
            	<th>시술 금액 : </th>
            	<td id="ti_pay">
            		<input name='ti_pay' type='text' value=''/>원
            	</td>
            </tr>
            <tr>
            	<th>예약일자 : </th>
            	<td id="ti_regdate">
            	</td>
            </tr>
            <tr>
            	<th>예약 진행 현황 : </th>
            	<td id="ti_state">
            		<input name='ti_state' type='radio' value='N'/>예약중
            		<input name='ti_state' type='radio' value='Y'/>예약완료
            	</td>
            </tr>
            <tr>
            <th></th>
            	<td id="updateBtn"><input type="button" value="저장" onclick="updateRes();"/>
            	<input type="button" value="취소" onclick="clearWindow();"/></td>
            </tr>
      </table>
</article>
<br/>
<br/>
<br/>
<%@ include file="./form/rightNavi.jsp" %>
<%@ include file="./form/leftNavi_tattooist.jsp" %>
<%@ include file="./form/footer.jsp" %>
</body>
</html>