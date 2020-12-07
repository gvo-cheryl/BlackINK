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
<script type="text/javascript" src="js/uCalendar.js"></script>
<script type="text/javascript">
function listcaldetail(m,d){
   var hrefs = "uCalController.do?command=listcaldetail&ti_date=&month=" + m + "&day=" + d;
   location.href = hrefs;
}

function listcaldetail2(){
   var startDate = $("#startDate").val();
   var endDate = $("#endDate").val();
   
   location.href = "uCalController.do?command=listcaldetail2&startDate=" + startDate   + "&endDate=" + endDate;
}

</script>
<style type="text/css">
   
   .btn{
      padding:5px 20px;
      margin:5px 0;
      border:0;
      border-radius: 5px;
      font-weight: 700;
   }
   table{
      font-size:14px;
      padding-left:30px;
   }
   th{
      padding-bottom: 10px;
      border-bottom: 2px solid darkgray;
   }
   td{
      text-align: center;
      margin: 0 auto;
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
   #article{width:900px; height: auto; position: relative; left: 25%;}
   #bottom{height: 100px;}
</style>
<body>
<%@ include file="./form/header.jsp" %>
<article id="article">
<div id=join class="head_title">
  <h1>예약 내역</h1> 
  <hr>
</div>
<br/>
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
      
      <table>
       <col width = "100px">
         <col width = "170px">
         <col width = "100px">
         <col width = "115px">
         <col width = "95px">
         <col width = "200px">
         <tr>
            <th>타투이스트</th>
            <th>시술 일자</th>
            <th>시술 금액</th>
            <th>예약일자</th>
            <th>예약 진행 현황</th>
            <th>결제</th>
         </tr>
         
         <c:choose>
            <c:when test="${empty list }">
            <tr>
               <td colspan="6">------------작성된 일정이 존재하지 않습니다--------</td>
            </tr>
            </c:when>
            <c:otherwise>
               <c:forEach items="${list }" var ="dto">
               <tr>
                    <td>${dto.me_nic }</td>
                  <td>
                     <jsp:setProperty property="toDates" name="util" value="${dto.ti_date }${dto.ti_time }"/>
                     <jsp:getProperty property="toDates" name="util"/>
                  </td>
                  <td>${dto.ti_pay }원</td>
                  <td>${dto.ti_regdate }</td>
                  <td>
                     <c:choose>
                        <c:when test="${dto.ti_state  eq 'Y'}">
                           <div>예약 완료</div>
                        </c:when>
                        <c:when test="${dto.ti_state eq 'N'}">
                           <div style="color:red;">예약중</div>
                        </c:when>
                     </c:choose>
                  </td>
                  <td>
                     <c:choose>
                        <c:when test="${dto.ti_state eq 'Y'}">
                           <c:if test="${dto.hi_state eq 'Y'}">
                              <div class="space"><input class="btn" type="button" value="결제완료" style="color:black; cursor: not-allowed;" /></div>
                           </c:if>
                           <c:if test="${(dto.hi_state eq null) || (dto.hi_state = '') }">
                              <div class="space">
                              <form action="hispay" method="post">
                                 <select name="method">
                                    <option value="card">신용카드</option>
                                    <option value="trans">실시간 계좌이체</option>
                                    <option value="vbank">가상계좌</option>
                                    <option value="phone">휴대폰 소액결제</option>
                                  <option value="samsung">삼성페이</option>
                                    <option value="kpay">Kpay</option>
                                 </select>
                           <input type="hidden" value="${dto.ti_no }" name="ti_no" />
                           <input type="hidden" value="paid" name="command" />
                                 <input class="btn" type="submit" value="결제" />
                              </form>
                           </div>
                           </c:if>
                        </c:when>
                        <c:when test="${dto.ti_state eq 'N'}">
                           <div class="space"><input class="btn" type="button" value="결제불가" style="color:red; cursor: not-allowed;" /></div>
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