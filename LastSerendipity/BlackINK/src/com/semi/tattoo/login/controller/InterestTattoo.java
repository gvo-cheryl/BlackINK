package com.semi.tattoo.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.tattoo.login.biz.LoginBiz;
import com.semi.tattoo.login.dto.LoginDto;

@WebServlet("/interesttattoo.do")
public class InterestTattoo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		LoginBiz biz= new LoginBiz();
		//HttpSession session = request.getSession();
		int me_no = Integer.parseInt(request.getParameter("me_no"));
		
		LoginDto interesttattoo = biz.interesttattoo(me_no);
		System.out.println(interesttattoo.getMe_no());
		request.setAttribute("interesttattoo", interesttattoo);
		
		dispatch("interesttattoo.jsp", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		RequestDispatcher dispatch= request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}

}
