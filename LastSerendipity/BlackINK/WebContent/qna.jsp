<%@page import="com.semi.tattoo.paging.Paging"%>
<%@page import="com.semi.tattoo.qna.dto.QnaDto"%>
<%@page import="java.util.List"%>
<%@page import="com.semi.tattoo.qna.biz.QnaBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("UTF-8");
%>
<%
   response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
body {
   background: ghostwhite;
}

#main {
   position: relative;
   margin-left: 300px;
   margin-top: 30px;
   width: 1200px;
   height: auto;
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
<body>
   <%
   QnaBiz biz = new QnaBiz();
   List<QnaDto> list = (List<QnaDto>) (request.getAttribute("list"));
   int curPage = (Integer) (request.getAttribute("curPage"));
   int total = (Integer) (request.getAttribute("totalCount"));
   Paging paging = new Paging(total, curPage);
   int me_no = Integer.parseInt(session.getAttribute("me_no").toString());
   %>
   <%@ include file="./form/header.jsp"%>
   <article>
      <section id="main">
         <div id=join class="head_title">
            <h1>Q&A</h1>
            <hr size="2" color="grey">
         </div>
         <table>
            <col width="120" />
            <col width="850" />
            <col width="100" />
            <col width="50" />
            <col width="40" />

            <tr height="50">
               <th>번호</th>
               <th style="text-align: left">제목</th>
               <th>글쓴이</th>
               <th>날짜</th>
               <th>조회</th>
            </tr>
            <c:choose>
               <c:when test="${empty list }">
                  <tr height="50">
                     <th colspan="4">---작성된 글이 없습니다.---</th>
                  </tr>
               </c:when>
               <c:otherwise>
                  <c:forEach items="${list }" var="dto">
                     <tr height="50">
                        <td style="text-align: center">${dto.no }</td>

                        <td>
                        	<c:choose>
                              <c:when test="${dto.delflag eq 'Y' }">
                                 <c:out value="-------삭제된 글 입니다.-----------"></c:out>
                              </c:when>
                              <c:otherwise>
                                 <c:if test="${dto.me eq me_no}">
                                 		<c:forEach begin="1" end="${dto.titletab }">
                                      		 &nbsp;
                                 		</c:forEach>
										<a href="QnaController.do?command=selectOne&no=${dto.no }">${dto.title }</a>
                              	 </c:if>
                              	 <c:if test="${dto.me != me_no}">
                              	 		<c:forEach begin="1" end="${dto.titletab }">
                                      		 &nbsp;
                                 		</c:forEach>
                              	 		${dto.category }
                              	 </c:if>
                              </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${dto.writer }</td>
                        <td><c:set var="regdate" value="${dto.regdate }" /> <c:set
                              var="subRegdate" value="${fn:substring(regdate,5,10) }" />
                           ${subRegdate }</td>
                        <td align="center">${dto.readcount }</td>
                     </tr>
                  </c:forEach>
               </c:otherwise>
            </c:choose>
            <tr height="50">
               <td colspan="5" align="right"><input type="button" value="작성"
                  onclick="location.href='QnaController.do?command=insert'">
               </td>
            </tr>

         </table>

         <!-- ----------------------------------------------- -->
         <div align="center">
            <%
               if (paging.getStartPage() > 1) {
            %>
            <a href="QnaController.do?command=qna&curPage=1">처음</a>"
            <%
               }
            if (curPage > 1) {
            %>
            <a href="QnaController.do?command=qna&curPage=<%=curPage - 1%>">이전</a>
            <%
               }
            for (int iCount = paging.getStartPage(); iCount <= paging.getEndPage(); iCount++) {
            %>
            <a href="QnaController.do?command=qna&curPage=<%=iCount%>"><%=iCount%></a>
            <%
               }
            if (curPage < paging.getTotalPage()) {
            %>
            <a href="QnaController.do?command=qna&curPage=<%=curPage + 1%>">다음</a>
            <%
               }
            if (paging.getEndPage() < paging.getTotalPage()) {
            %>
            <a
               href="QnaController.do?command=qna&curPage=<%=paging.getTotalPage()%>">끝</a>"
            <%
               }
            %>
         </div>
      </section>

   </article>
   <%@ include file="./form/rightNavi.jsp" %>
   <%@ include file="./form/leftNaviQna.jsp"%>
   <%@ include file="./form/footer.jsp"%>
</body>
</html>