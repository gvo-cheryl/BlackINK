<%@page import="com.semi.tattoo.qna.dto.QnaDto"%>
<%@page import="com.semi.tattoo.qna.biz.QnaBiz"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.FileRenamePolicy"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String title = "";
	String content = "";
	String img = "";
	
	String saveDirectory = pageContext.getServletContext().getRealPath("/img");
	//String saveDirectory = (request.getContextPath() + "/img").substring(1);
	//String saveDirectory = "C:\\imgSave";
	
	System.out.println("저장된 경로 :" + saveDirectory);
	
	QnaBiz biz = new QnaBiz();
	
	
	try {
		MultipartRequest multi = new MultipartRequest(request, saveDirectory ,10*1024*1024 ,"UTF-8",new DefaultFileRenamePolicy());
		
		Enumeration files = multi.getFileNames();
		
		while(files.hasMoreElements()){
			String name = (String)files.nextElement();
			File file = multi.getFile(name);
			
			System.out.println("파라미터 이름 : " + name + "<br>");
			System.out.println("실제 파일 이름: "  + multi.getOriginalFileName(name) + "<br>");
			System.out.println("저장된 파일 이름 : " + multi.getFilesystemName(name) + "<br>");
			System.out.println("파일 타입 : " + multi.getContentType(name) + "<br>");
			
			title = multi.getParameter("title");
			content = multi.getParameter("content");
			img = multi.getFilesystemName(name);
			
			QnaDto dto = new QnaDto(title, content, img);
			
			int res = biz.insert(dto);
			System.out.println("title값:" + title);
			System.out.println("content값 :" + content);
			System.out.println("img값 :" + img);
			
			if(file != null){
				System.out.println("크기" + file.length());
				System.out.println("<br>");
			}
		}
	} catch (Exception e) {
		e.getStackTrace();
		
	}finally {
%>
		<jsp:forward page="QnaController.do?command=qna&curPage=1"></jsp:forward>
<% 		
	}
	
%>

	
	
</body>
</html>