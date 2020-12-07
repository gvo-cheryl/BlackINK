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

@WebServlet("/myhistory.do")
public class Myhistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		LoginBiz biz= new LoginBiz();
		//HttpSession session = request.getSession();
		int me_no = Integer.parseInt(request.getParameter("me_no"));
		
		LoginDto myhistory = biz.myhistory(me_no);
		System.out.println(myhistory.getMe_no());
		request.setAttribute("myhistory", myhistory);
		
		dispatch("myhistory.jsp", request, response);
	}
	
	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		RequestDispatcher dispatch= request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}

}
