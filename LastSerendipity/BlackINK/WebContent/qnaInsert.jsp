<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="UTF-8">
<head>
<meta charset="UTF-8" />
<title>QNA 글쓰기</title>
</head>

<%
   int me = 0;
   String name = "";
   String nic = "";
   if (session.getAttribute("me_no") == null) {
%>
         <script type="text/javascript">
            alert("로그인을 먼저 해주세요.");
            location.href="login.do";
         </script>      
<%
   }else{

      me = (Integer)(session.getAttribute("me_no"));
      name = (String) (session.getAttribute("me_name"));
      nic = (String) (session.getAttribute("me_nic"));
   }
   System.out.println("zz"+me);
%>
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

.head_title {
   margin-top: 30px;
   margin-bottom: 30px;
}

.head_title>h1 {
   padding-right: 30px;
   text-align: center;
}
</style>
<link type="text/css" rel="stylesheet" href="./css/insert.css">

<body>
   <%@ include file="./form/header.jsp"%>

   <article>
      <section id="main">
         <div id=join class="head_title">
            <h1>Q&A 작성</h1>
            <hr size="2" color="grey">
         </div>
         <div id="mainWrap">
            <form action="qnaUpload.jsp" method="post"   enctype="multipart/form-data">
               <input type="hidden" value="<%=me%>" name="me">
               <div id="topWrap">
               	  <select name="category">
               	  		<option value="개인정보/로그인">개인정보/로그인</option>
               	  		<option value="도안상담">도안상담</option>
               	  		<option value="타투이스트">타투이스트</option>
               	  		<option value="에약/예약취소">예약/예약취소</option>
               	  		<option value="결제/결제취소">결제/결제취소</option>
               	  		<option value="기타">기타</option>
               	  </select>
                  <input class="topTitle" type="text" placeholder="제목을 입력하세요."
                     name="title" />
                  <c:choose>
                     <c:when test="${not empty sessionScope.me_name }">
                        <input class="topName" type="text" value="<%=name%>"
                           name="writer" readonly="readonly">
                     </c:when>
                     <c:when test="${not empty sessionScope.me_nic }">
                        <input class="topName" type="text" value="<%=nic%>"
                           name="writer" readonly="readonly">
                     </c:when>
                     <c:otherwise>
                        <input class="topName" type="text" placeholder="닉네임"
                           name="writer">
                     </c:otherwise>
                  </c:choose>
               </div>

               <hr>

               <div id="bottomWrap">
                  <textarea cols="130" rows="20" name="content"
                     style="resize: none;"></textarea>
               </div>
               <div id="buttonWrap">
                  <input type="file" name="upload"><br /> <input
                     type="button" value="취소" style="float: right" onclick="location.href='QnaController.do?command=qna&curPage=1'"> <input
                     type="submit" value="완료" style="float: right">
               </div>
            </form>
         </div>
      </section>
   </article>
   <%@ include file="./form/rightNavi.jsp" %>
   <%@ include file="./form/leftNaviQna.jsp"%>
   <%@ include file="./form/footer.jsp"%>

</body>
</html>