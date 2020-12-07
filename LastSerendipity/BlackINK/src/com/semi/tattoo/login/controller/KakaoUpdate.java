package com.semi.tattoo.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.tattoo.login.biz.LoginBiz;
import com.semi.tattoo.login.dto.LoginDto;

@WebServlet("/kakaoupdate.do")
public class KakaoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		LoginBiz biz = new LoginBiz();
		if(command.equals("kakaoupdateform")) {
			int me_no = Integer.parseInt(request.getParameter("me_no"));
			String me_phone = request.getParameter("me_phone");
			LoginDto dto = new LoginDto();
			dto.setMe_no(me_no);
			dto.setMe_phone(me_phone);
			
			int res = biz.kakaoUpdatePage(dto);
			if(res>0) {
				LoginDto myinfo = biz.myInfo(me_no);
				request.setAttribute("dto", dto);
				request.setAttribute("myinfo", myinfo);
				//jsResponse("수정완료","update.do",response);
				
				dispatch("kakaoUpdate01.jsp",request,response);
			}
		
		
		}
		
	}
	
	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException{
		PrintWriter out= response.getWriter();
		String res="<script>alert('"+msg+"'); location.href='"+url+"';</script>";
		out.print(res);
	}
	
	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request,response);
		
	}

}
