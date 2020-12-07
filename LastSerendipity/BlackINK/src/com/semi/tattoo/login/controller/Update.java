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

@WebServlet("/update.do")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String command = request.getParameter("command");
		LoginBiz biz = new LoginBiz();
		if(command.equals("updateform")) {
			int me_no = Integer.parseInt(request.getParameter("me_no"));
			String me_pw = request.getParameter("me_pw");
			String me_phone = request.getParameter("me_phone");
			String me_birth = request.getParameter("me_birth");
			String me_email = request.getParameter("me_email");
			System.out.println("update me_birth: "+me_birth);
			LoginDto dto = new LoginDto();
			dto.setMe_no(me_no);
			dto.setMe_pw(me_pw);
			dto.setMe_phone(me_phone);
			dto.setMe_birth(me_birth);
			dto.setMe_email(me_email);
			
			int res = biz.update(dto);
			if(res>0) {
				LoginDto myinfo = biz.myInfo(me_no);
				request.setAttribute("myinfo", myinfo);
				jsResponse("수정완료","mypage.jsp",response);
				dispatch("mypage.jsp", request,response);
			}
		}
	
	}
	
	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request,response);
		
	}
	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException{
		PrintWriter out= response.getWriter();
		String res="<script>alert('"+msg+"'); location.href='"+url+"';</script>";
		out.print(res);
	}

}
