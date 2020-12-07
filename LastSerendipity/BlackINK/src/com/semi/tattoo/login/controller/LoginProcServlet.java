package com.semi.tattoo.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.tattoo.login.biz.LoginBiz;
import com.semi.tattoo.login.dto.LoginDto;


@WebServlet("/loginProc.do")
public class LoginProcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		LoginBiz biz= new LoginBiz();
		HttpSession session = request.getSession();
		
		
		String me_email = request.getParameter("me_email");
		String me_pw = request.getParameter("me_pw");
		
		
		System.out.println(me_email);
		System.out.println(me_pw);
		//2. 
		LoginDto dto= biz.loginCheck(me_email,me_pw);
		System.out.println(me_email);
		System.out.println(me_pw);
	
		if(dto ==null || dto.getMe_email()==null || dto.getMe_pw()==null || dto.getMe_enabled().equals("N"))	{
			jsResponse("login실패-ID/비밀번호 확인해주세요","login.jsp", response);
			
		} else if(dto != null || dto.getMe_no() > 0 ) {
			//3.
			session.setAttribute("me_no", dto.getMe_no());
			session.setAttribute("me_name", dto.getMe_name());
			session.setAttribute("me_email", dto.getMe_email());
			session.setAttribute("me_phone", dto.getMe_phone());
			session.setAttribute("me_birth", dto.getMe_birth());
			session.setAttribute("me_sns_token",dto.getMe_sns_token());
			session.setAttribute("me_nic", dto.getMe_nic());
			session.setAttribute("me_role", dto.getMe_role());
			
			session.setMaxInactiveInterval(-1);
			//4. 
			dispatch("main.jsp",request,response);
			
		}
	}
}