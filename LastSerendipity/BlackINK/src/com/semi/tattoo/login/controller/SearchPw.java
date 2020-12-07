package com.semi.tattoo.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.tattoo.login.biz.LoginBiz;

@WebServlet("/searchPw.do")
public class SearchPw extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String me_email = request.getParameter("me_email");
		String me_birth = request.getParameter("me_birth");
		String me_phone = request.getParameter("me_phone");
		System.out.println(me_email);
		System.out.println(me_birth);
		System.out.println(me_phone);
		
		LoginBiz biz = new LoginBiz();
		String searchPw =  biz.searchPw(me_email,me_birth,me_phone);
		
		System.out.println("searchPw:::" + searchPw);
		
		if(searchPw != null)
		{
			request.setAttribute("message","비밀번호는 "+ searchPw +" 입니다" );
			dispatch("searchPw.jsp", request, response);
		}
		else
		{
			request.setAttribute("message","존재하지않는 사용자입니다" );
			dispatch("searchPw.jsp", request, response);
		}
	}
		
		
	
	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request,response);
	
	}

}
