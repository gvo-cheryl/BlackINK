<%@page import="com.semi.tattoo.login.dto.LoginDto"%>
<%@page import="com.semi.tattoo.login.biz.LoginBiz"%>
<%@page import="java.util.Map"%>
<%@page import="com.semi.tattoo.tattooinfo.dto.tattooInfoDto"%>
<%@page import="java.util.List"%>
<%@page import="com.semi.tattoo.tattooinfo.dao.tattooInfoDao"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.semi.tattoo.tattooinfo.controller.Util"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	body{background: ghostwhite;}
	.head_title {
	   margin-top: 30px;
	   margin-bottom: 30px;
	}
	.head_title > h1 {
	   padding-right: 30px;
	   text-align: right;
	}
	#tableOption{
		padding-left: 100px;
	}
	#calendar{
		border-collapse:collapse;
		padding-left:30px;
	}
	#calendar th{
		width:90px;
		border:2px solid gray;
	}
	#calendar td{
		width:90px;
		height:90px;
		border:2px solid gray;
		text-align: left;
		vertical-align: top;
		position: relative;
	}
	#calendar td:nth-child(7n){
		border-right:none;
	}
	#calendar td:nth-child(7n+1){
		border-left:none;
	}
	.date{
		font-weight: 800;
		padding: 2px;
	}
	.date:hover{
		cursor: pointer;
	}
	a{
		text-decoration: none;
	}
	
	#clist > p{
		font-size:5px;
		margin:1px;
	}
	.m,.y,.dot{
		font-size: 30px;
		border: 0;
		font-weight: 800;
		color: skyblue;
	}
	.dot{
		color:gray;
	}
	caption{
		padding-bottom: 10px;
	}
	
	.cPreview{
		position : absolute;
		top:-30px;
		left:10px;
		background: skyblue;
		width:40px;
		height:40px;
		text-align: center;
		line-height: 40px;
		border-radius: 40px 40px 40px 1px;
	}
	.head_title {
      margin-top: 30px;
      margin-bottom: 30px;
   }
   .head_title > h1 {
      padding-right: 30px;
      text-align: right;
   }
	
	article{width:900px; height: auto; position: relative; left: 25%;}
</style>

</head>

<%
	Calendar cal = Calendar.getInstance();
	
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH)+1;
	int ti_tno = (int)session.getAttribute("me_no");
	String paramYear = request.getParameter("year");
	String paramMonth = request.getParameter("month");
	if(paramYear != null){
		year = Integer.parseInt(paramYear);
	}
	if(paramMonth != null){
		month = Integer.parseInt(paramMonth);
	}
	
	if(month > 12){
		month = 1;
		year++;
	}
	if(month < 1){
		month = 12;
		year--;
	}
	
	// 현재년도, 현재월, 해당월의 1일
	cal.set(year, month-1, 1);
	//1일의 요일
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	// 현재월의 마지막일
	int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	//달력에 일정 표현
	tattooInfoDao dao = new tattooInfoDao();
	//String yyyyMM = year + Util.isTwo(String.valueOf(month));
	//String yyyyMM = year + Util.isTwo(Integer.toString(month));
	String ti_date = year + Util.isTwo(month+"");
	tattooInfoDto dto = new tattooInfoDto(ti_tno,ti_date);
	List<Map<String,String>> clist = dao.calendarViewList(dto);
%>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$(function(){
		$("#calendar tr").children("th:first").css("border-left","none");
		$("#calendar tr").children("th:last").css("border-right","none");
	});
</script>

<body>
<%@ include file="./form/header.jsp" %>
<article>
<div id=join class="head_title">
  <h1>내 일정</h1> 
  <hr>
</div>
<br/>
<div id="tableOption">
	<table id = "calendar">
		<caption>
			<a style="color:black" href="calendar.jsp?year=<%=year-1 %>&month=<%=month %>">◁</a>
			<a style="color:black" href="calendar.jsp?year=<%=year %>&month=<%=month-1 %>">◀</a>
			
			<span class="y"><%=year %></span>
			<span class="dot">/</span>
			<span class="m"><%=month %></span>
			
			<a style="color:black" href="calendar.jsp?year=<%=year %>&month=<%=month+1 %>">▶</a>
			<a style="color:black" href="calendar.jsp?year=<%=year+1 %>&month=<%=month %>">▷</a>
		</caption>
		
		<tr>
			<th style="color:red">SUN</th><th>MON</th><th>TUE</th><th>WED</th>
			<th>THU</th><th>FRI</th><th style="color:blue">SAT</th>
		</tr>
		<tr>
<%
	for(int i = 0;i<dayOfWeek-1; i++){
		out.print("<td>&nbsp;</td>");
	}

for(int i = 1;i<=lastDay;i++){
%>
	<td class="date" onclick="location.href='tCalController.do?command=listcal&year=<%=year %>&month=<%=month %>&date=<%=i %>'">
		<div>
			<div style="color:<%=Util.fontColor(i, dayOfWeek) %>"><%=i %></div>
			<div id="clist">
				<%=Util.getCalView(i, clist) %>		
			</div>
		</div>
	</td>
<%
	if((dayOfWeek-1+i)%7 == 0){
		out.print("</tr><tr>");
	}
}

for(int i = 0;i<(7-(dayOfWeek-1+lastDay)%7)%7;i++){
	out.print("<td>&nbsp;</td>");
}
%>
		</tr>
		
	</table>
	</div>
</article>




<br/>
<br/>
<br/>

<%@ include file="./form/leftNavi_tattooist.jsp" %>
<%@ include file="./form/footer.jsp" %>
</body>
</html>