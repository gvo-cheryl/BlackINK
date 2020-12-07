<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.semi.tattoo.paging.Paging"%>
<%@page import="com.semi.tattoo.review.biz.ReviewBiz"%>
<%@page import="com.semi.tattoo.review.dto.ReviewDto"%>
<%@page import="java.util.List"%>
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
	
</style>
<body>
<%
	ReviewBiz biz = new ReviewBiz();
	
	List<ReviewDto> list = (List<ReviewDto>)(request.getAttribute("list"));
	int curPage = (Integer)(request.getAttribute("curPage")); // 현재 페이지
	int total = (Integer)(request.getAttribute("totalCount")); // 현재 페이지
	Paging paging = new Paging(total, curPage);
	String dir = System.getProperty("user.dir");
	System.out.println(dir + "이 바로 너가 원하던 디렉토리입니다.");
	String address = getServletContext().getRealPath("/");
	//C:\Workspace_semi\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\BlackINK\
	
%>
<%@ include file="./form/header.jsp" %>
<article>
	<section id="main">
		<h3>타투 후기</h3>
			<table>
				<tr>
<%

			SimpleDateFormat formatter = new SimpleDateFormat ("MM-dd HH:mm");
			int jump = 1;
			for (int i = 0; i < list.size(); i++){
				
				ReviewDto dto = list.get(i);
				String date = formatter.format (dto.getRegdate());

%>			
				<td>
					<div id="block">
						<a href="ReviewController.do?command=selectOne&no=<%=dto.getNo()%>"><img style="width:150px; height:150px;"src="/BlackINK/img/<%=dto.getFilename() %>"></a><br/>
						<a href="ReviewController.do?command=selectOne&no=<%=dto.getNo()%>"><%=dto.getTitle() %></a><br/>
						<%=dto.getWriter() %><br/>
						<%=date %> 조회<%=dto.getReadcount() %>
					</div>
				</td>						
<%
					if(jump%5==0){
%>
						</tr>
						<tr>
<% 
					} else {
						System.out.println(dto.getRegdate());
						System.out.println(jump + "번째!");
					}
				jump++;
			}
%>			
			
			<tr>
				<td>
					<input type="button" value="작성" onclick="location.href='ReviewController.do?command=insert'">
				</td>
			</tr>	
			</table>
<%		
		if (paging.getStartPage() > 1) {
%>
		   <a href="ReviewController.do?command=review&curPage=1">처음</a>"
<% 
		}
		if (curPage > 1) {
%>
		    <a href="ReviewController.do?command=review&curPage=<%=curPage-1%>">이전</a>
<%
		}
		for (int iCount = paging.getStartPage(); iCount <= paging.getEndPage(); iCount++) {
 %>	  
		<a href="ReviewController.do?command=review&curPage=<%=iCount %>"><%=iCount %></a>	      
<%
		}
		if (curPage < paging.getTotalPage()) {
%>		    
		    <a href="ReviewController.do?command=review&curPage=<%=curPage+1%>">다음</a>
<% 
		}
		if (paging.getEndPage() < paging.getTotalPage()) {
%>
		    <a href="ReviewController.do?command=review&curPage=<%=paging.getTotalPage() %>">끝</a>"
<% 
		}
%>		
			
	</section>
</article>
<style type="text/css">
#block {
	width: 200px;
	height: 250px;
	margin: 20px 0px 0px 20px;
}
</style>
<%@ include file="./form/leftNaviStory.jsp" %>
<%@ include file="./form/footer.jsp" %>
</body>
</html>