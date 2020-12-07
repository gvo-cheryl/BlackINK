<%@page import="com.semi.tattoo.qna.dto.QnaDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
   body{background: ghostwhite;}
   #main {
      position: relative;
      margin-left: 300px;
      margin-top: 30px;
      width: 1200px;
      height: 400px;
   }
   #main hr {
      position: relative;
      margin-top: 50px;
   }
</style>
<link type="text/css" rel="stylesheet" href="./css/insert.css">
<%
   String name = (String)(session.getAttribute("me_name"));
   String nic = (String)(session.getAttribute("me_nic"));
   QnaDto dto = (QnaDto)(request.getAttribute("dto"));
%>
<body>
<%@ include file="./form/header.jsp" %>
<article style="height: 800px;">
      <section id="main">
     <h3>질문 쓰기</h3>
          <div id="mainWrap">
         <form action="QnaController.do" method="post">
            <input type="hidden" value="<%=dto.getNo()%>" name="no">
            <input type="hidden" value=${me_no } name="no">
            <input type="hidden" value="replyres" name="command">
            <div id="topWrap">
               <input class="topTitle" type="text" value="RE: <%=dto.getTitle()%>" name="title" readonly="readonly">
            
            <c:choose>
               <c:when test="${not empty sessionScope.me_name }">
                     <input class="topName" type="text" value="<%=name%>" name="writer" readonly="readonly">
               </c:when>
               <c:when test="${not empty sessionScope.me_nic }">
                     <input class="topName" type="text" value="<%=nic %>" name="writer" readonly="readonly">
               </c:when>
               <c:otherwise>
                     <input class="topName" type="text" placeholder="닉네임" name="writer">
               </c:otherwise>
            </c:choose>
            </div>
            
            <hr>
            
            <div id="bottomWrap">
                 <textarea cols="130" rows="20" name="content" style="resize:none;"><%=dto.getContent() %></textarea>
            </div>
            <div id="buttonWrap">
               <input type="button" value="취소" style="float: right">
               <input type="submit" value="완료" style="float: right">
            </div>      
         </form>
         </div>
   </section>   
   </article>
   
<%@ include file="./form/rightNavi.jsp" %>      
<%@ include file="./form/leftNaviQna.jsp" %>   
<%@ include file="./form/footer.jsp" %>   
</body>
</html>