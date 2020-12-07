<%@page import="com.semi.tattoo.notice.dto.NoticeDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      height: 700px;
   }
   #main hr {
      position: relative;
      margin-top: 50px;
   }
   
</style>
<%
   String A = "A";
   String role = (String)(session.getAttribute("me_role"));
   String name = (String)(session.getAttribute("me_name"));
   String nic = (String)(session.getAttribute("me_nic"));
   NoticeDto dto = new NoticeDto();
   dto = (NoticeDto)(request.getAttribute("dto"));
   String writer = dto.getWriter();
   
   System.out.println("me_role: " + role);
   
   
   
   if (name == null&&nic == null) {
      String result = "<script> alert ('로그인을 먼저 해주세요.'); location.href=\"login.do\"; </script>";
      response.getWriter().append(result);
   } else if(writer.equals(name)) {
      System.out.println("name과 writer가 같다.");
   } else if(writer.equals(nic)){
      System.out.println("nic과 writer가 같다");
   } else if(A.equals(role)){
      System.out.println("작성자가 관리자이다.");
   } else {   
   System.out.println("nic과 writer가 일치하지 않음");
   String result = "<script> alert ('작성자가 아닙니다.'); location.href=\"NoticeController.do?command=notice&curPage=1\"; </script>";
   response.getWriter().append(result);
   }
   
%>
<body>
<link type="text/css" rel="stylesheet" href="./css/insert.css">

<%@ include file='./form/header.jsp' %>   
<article>
   <section id="main">
      <h3>공지사항 작성</h3>
      <hr size="2" color="grey">
       
      <div id="mainWrap">
      <form action="NoticeController.do?command=updateform" method="post">
               <input type="hidden" value="<%=dto.getNo()%>" name="no">
               <div id="topWrap">
                  <input class="topTitle" type="text" value="<%=dto.getTitle() %>" name="title" />
            
                  <input class="topName" type="text" value="<%=dto.getWriter() %>" name="writer" readonly="readonly">
                  
               </div>
               
               <hr>
               
               <div id="bottomWrap">
                    <textarea cols="130" rows="20" name="content"><%=dto.getContent() %></textarea>
                    
               </div>
               <div id="buttonWrap">
                  <input type="button" value="취소" style="float: right" onclick="location.href='NoticeController.do?command=notice&curPage=1'">
                  <input type="submit" value="완료" style="float: right">
               </div>
      </form>
      </div>

   </section>
   
   --------------------------------------
      
</article>   
<%@ include file="./form/rightNavi.jsp" %>
<%@ include file="./form/leftNaviStory.jsp" %>
<%@ include file='./form/footer.jsp' %>   
</body>
</html>