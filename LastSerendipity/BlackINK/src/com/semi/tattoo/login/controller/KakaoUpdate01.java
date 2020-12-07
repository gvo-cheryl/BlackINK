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

/**
 * Servlet implementation class KakaoUpdate01
 */
@WebServlet("/kakaoupdatepage.do")
public class KakaoUpdate01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int me_no = Integer.parseInt(request.getParameter("me_no"));
		String me_phone = request.getParameter("me_phone");
		String me_birth = request.getParameter("me_birth");
		
		
		System.out.println(me_phone);
		System.out.println(me_birth);
		System.out.println(me_no);
		
		
		LoginDto dto = new LoginDto();
		dto.setMe_no(me_no);
		dto.setMe_phone(me_phone);
		dto.setMe_birth(me_birth);
		
		LoginBiz biz = new LoginBiz();
		int res = biz.kakaoupdate(dto);
		if(res>0) {
			
			LoginDto myinfo = biz.myInfo(me_no);
			
			request.setAttribute("dto", dto);
			request.setAttribute("myinfo", myinfo);
			//jsResponse("수정완료","kakaoUpdate.jsp",response);
			dispatch("kakaoUpdate.jsp",request,response);
		}
	}
	
	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request,response);
		
	}

}
