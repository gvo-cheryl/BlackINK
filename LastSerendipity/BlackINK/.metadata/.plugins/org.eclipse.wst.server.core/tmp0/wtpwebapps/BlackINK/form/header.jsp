<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/header.css">

</head>
<body>

</body>
<header>

   <h1><a href="main.jsp">Black INK</a></h1>
   
   <div id="naviList">
      <ul id="mainMenu">
      
      
        <li><a href="tattooshareController.do?command=list">Sample</a>
	        	<ul class="subMenu">
	        		<li><a>Search</a></li>
	        		<li><a>Canvas</a></li>
	        	</ul> 
	         </li>
         
         
         <li><a href="location.jsp">Location</a></li>
         
         
         <li><a href="NoticeController.do?command=notice&curPage=1">Story</a>
	         	<ul class="subMenu">
	         		<li><a href="NoticeController.do?command=notice&curPage=1">notice</a></li>
	         		<li><a href="ReviewController.do?command=review&curPage=1">review</a></li>
	         	</ul>
	         </li>
         
         
          <li><a href="QnaController.do?command=qna&curPage=1">Q&A</a><li>
         
         
         <li>
            <c:if test="${empty sessionScope.me_no}">
               <a href="login.do">MyPage</a>
            </c:if>
            <c:if test="${not empty sessionScope.me_no}">
               <a href="mypage.do?command=mypage&me_no=${sessionScope.me_no}">${sessionScope.me_name}</a>
            </c:if>
            <c:if test="${not empty sessionScope.me_no}">
					<a href="mypage.do?command=mypage&me_no=${sessionScope.me_no}">${sessionScope.me_nic}</a>
			</c:if>
			 <ul class="subMenu">
	            	<li>tattooist</li>
	            	<li>user</li>
	            	<li>admin</li>
	             </ul>
         </li>
         
         
         <li>
            <c:if test="${empty sessionScope.me_no}">
               <a href="login.do">LOGIN</a>
            </c:if>
            <c:if test="${not empty sessionScope.me_no}">
               <a href="logout.do">LOGOUT</a>
            </c:if>
         </li>
         
         
      </ul>
      
   </div>
   <hr size="10" width="100%" color="black">

</header>


</html>