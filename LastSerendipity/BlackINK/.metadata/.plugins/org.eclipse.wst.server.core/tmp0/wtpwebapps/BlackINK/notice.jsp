<%@page import="com.semi.tattoo.paging.Paging"%>
<%@page import="com.semi.tattoo.notice.dao.NoticeDao"%>
<%@page import="com.semi.tattoo.notice.dto.NoticeDto"%>
<%@page import="java.util.List"%>
<%@page import="com.semi.tattoo.notice.biz.NoticeBiz"%>
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
	
	#table td{
		margin-top: 40px;
	}
	
	
</style>
<body>
<%
	NoticeBiz biz = new NoticeBiz();
	List<NoticeDto> list = (List<NoticeDto>)(request.getAttribute("list"));
	int curPage = (Integer)(request.getAttribute("curPage")); 
	int total = (Integer)(request.getAttribute("totalCount")); 
	Paging paging = new Paging(total, curPage);
	

%>	
<%@ include file="./form/header.jsp" %>
<article>
	<section id="main">
		<h3>공지사항</h3>
		
		<hr size="2" color="grey">
		<table>
			<col width="120" />
			<col width="850" />
			<col width="100" />
			<col width="50" />
			<col width="40" />
			<tr height="50">
				<th>번호</th>
				<th style="text-align:left">제목</th>
				<th>글쓴이</th>
				<th>날짜</th>
				<th>조회</th>
			</tr>
<%
			for (NoticeDto dto : list){
				String date = dto.getRegdate().substring(5,10);
%>				
			<tr id="table" height="50">
				<td style="text-align:center"><%=dto.getNo() %></td>
				<td><a href="NoticeController.do?command=selectOne&no=<%=dto.getNo() %>"><%=dto.getTitle() %></a></td>
				<td style="text-align:center"><%=dto.getWriter() %></td>
				<td style="text-align:center"><%=date %></td>
				<td style="text-align:center"><%=dto.getView() %></td>
			</tr>	
<%
			}
%>			
			<tr id="button" height="50">
				<td colspan="5">
					<input type="button" value="글작성" onclick="location.href='NoticeController.do?command=insert'">
				</td>
			</tr>
		
		</table>	
		
		<!-- ----------------------------------------------- -->
<%

		if (paging.getStartPage() > 1) {
%>
		   <a href="NoticeController.do?command=notice&curPage=1">처음</a>"
<% 
		}
		if (curPage > 1) {
%>
		    <a href="NoticeController.do?command=notice&curPage=<%=curPage-1%>">이전</a>
<%
		}
		for (int iCount = paging.getStartPage(); iCount <= paging.getEndPage(); iCount++) {
 %>	  
		<a href="NoticeController.do?command=notice&curPage=<%=iCount %>"><%=iCount %></a>	      
<%
		}
		if (curPage < paging.getTotalPage()) {
%>		    
		    <a href="NoticeController.do?command=notice&curPage=<%=curPage+1%>">다음</a>
<% 
		}
		if (paging.getEndPage() < paging.getTotalPage()) {
%>
		    <a href="NoticeController.do?command=notice&curPage=<%=paging.getTotalPage() %>">끝</a>"
<% 
		}
%>		

	</section>
	
</article>
<%@ include file="./form/leftNaviStory.jsp" %>
<%@ include file="./form/footer.jsp" %>
</body>
</html>