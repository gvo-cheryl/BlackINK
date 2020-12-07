<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

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
   .sub_title{
      padding-left: 30px;
   }
   article{width:900px; height: auto; position: relative; left: 25%;}
   .btn{
      padding:5px 20px;
      margin:5px 0;
      border:0;
      border-radius: 5px;
      font-weight: 700;
   }
   table {
      text-align: center;
      padding-left: 30px;
      font-size: 14px; 
   }
   th{
      padding-bottom: 10px;
      border-bottom: 2px solid darkgray;
   }
   #btnth{
      border:0;
   }
   td{
      margin: 0 auto;
      text-align: center;
   }
   #bottom{height: 100px;}
</style>
<body>
<%@ include file="./form/header.jsp" %>
<article>
<div id=join class="head_title">
  <h1>결제 내역</h1> 
  <hr>
</div>
<br/>
   <div class="sub_title">결제 내역 조회</div><br/>

      <jsp:useBean id="util" class="com.semi.tattoo.hispay.controller.Util" ></jsp:useBean>
      
      <table>
       <col width = "70px">
         <col width = "100px">
         <col width = "100px">
         <col width = "180px">
         <col width = "100px">
         <col width = "80px">
         <col width = "80px">
         <col width = "100px">
         <tr>
            <th>주문 번호</th>
            <th>결제 번호</th>
            <th>결제 방법</th>
            <th>결제 금액 / 타투 시술 금액</th>
            <th>주문 명</th>
            <th>결제일</th>
            <th>결제 여부</th>
            <th id="btnth"></th>
         </tr>
         
         <c:choose>
            <c:when test="${empty list }">
            <tr>
               <td colspan="8">------------작성된 일정이 존재하지 않습니다--------</td>
            </tr>
            </c:when>
            <c:otherwise>
               <c:forEach items="${list }" var ="dto">
               <tr>
                    <td>
                       ${dto.ti_no }
                    </td>
                    <td>
                       ${dto.hi_no }
                    </td>
                    <td>
                       ${dto.hi_method }
                    </td>
                    <td>
                       ${dto.hi_pay } / ${dto.ti_pay }
                    </td>
                    <td>
                       ${dto.ti_title }
                    </td>
                  <td>
                     <jsp:setProperty property="toDates" name="util" value="${dto.hi_date }"/>
                     <jsp:getProperty property="toDates" name="util"/>
                  </td>
                  <td>
                     <c:choose>
                        <c:when test="${dto.hi_state  eq 'Y'}">
                           <div>결제 완료</div>
                        </c:when>
                        <c:when test="${dto.hi_state eq 'N'}">
                           <div style="color:red;">결제 전</div>
                        </c:when>
                     </c:choose>
                  </td>
                  <td>
                  <c:choose>
                     <c:when test="${dto.hi_state  eq 'Y'}">
                           <div>
                              <input class="btn" type="button" value="결제 취소" onclick="" />
                           </div>
                        </c:when>
                     </c:choose>
                  </td>
               </tr>
               </c:forEach>
               </c:otherwise>
            </c:choose>
      </table>
</article>
<br/>
<br/>
<br/>
<div id="bottom"></div>
<%@ include file="./form/rightNavi.jsp" %>
<%@ include file="./form/leftNavi.jsp" %>
<%@ include file="./form/footer.jsp" %>
</body>
</html>