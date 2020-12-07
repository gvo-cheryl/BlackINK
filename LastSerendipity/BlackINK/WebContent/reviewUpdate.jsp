<%@page import="com.semi.tattoo.review.dto.ReviewDto"%>
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
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="summernote/js/summernote-lite.js"></script>
<script src="summernote/js/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="summernote/css/summernote-lite.css">
<script>
   <%-- form의 textarea에 summernote 적용 --%>
   $(document).ready(function() {
      $('#summernote').summernote({
         height: 700,
         fontNames : [ '맑은고딕', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', ],
         fontNamesIgnoreCheck : [ '맑은고딕' ],
         focus: true
      });
   });
</script>

<style type="text/css">
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
   String name = (String)(session.getAttribute("me_name"));
   String nic = (String)(session.getAttribute("me_nic"));
   ReviewDto dto = new ReviewDto();
   dto = (ReviewDto)(request.getAttribute("dto"));
   String writer = dto.getWriter();
   System.out.println(writer + name);
   
   if (name == null&&nic == null) {
      String result = "<script> alert ('로그인을 먼저 해주세요.'); location.href=\"login.do\"; </script>";
      response.getWriter().append(result);
   } else if(writer.equals(name)) {
      System.out.println("name과 writer가 같다.");
   } else if(writer.equals(nic)){
      System.out.println("nic과 writer가 같다");
   } else {   
   System.out.println("nic과 writer가 일치하지 않음");
   String result = "<script> alert ('작성자가 아닙니다.'); location.href=\"ReviewController.do?command=review&curPage=1\"; </script>";
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
               <form action="ReviewController.do?command=updateform" method="post">
      
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
                  <input type="button" value="취소" style="float: right">
                  <input type="submit" value="완료" style="float: right">
               </div>
      </form>
      </div>
   </section>
</article>   
<%@ include file="./form/rightNavi.jsp" %>
<%@ include file='./form/footer.jsp' %>   
</body>
</html>