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
import com.semi.tattoo.login.biz.adminBiz;
import com.semi.tattoo.login.dto.LoginDto;
import com.semi.tattoo.profile.biz.profileBiz;


@WebServlet("/regist.do")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       LoginBiz biz = new LoginBiz();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//1. �����޹ޱ�
		String me_role= request.getParameter("me_role");
		String me_name= request.getParameter("me_name");
		String me_email= request.getParameter("me_email");
		String me_nic= request.getParameter("me_nic");
		String me_pw= request.getParameter("me_pw");
		String me_phone= request.getParameter("me_phone");
		String me_birth= request.getParameter("me_birth");
		
		LoginDto dto = new LoginDto();
		
		dto.setMe_role(me_role);
		dto.setMe_name(me_name);
		dto.setMe_email(me_email);
		dto.setMe_nic(me_nic);
		dto.setMe_pw(me_pw);
		dto.setMe_phone(me_phone);
		dto.setMe_birth(me_birth);
		
		
		//2.db����
		int res= biz.insert(dto);
		int me_no = biz.searchMeno(me_email);
		profileBiz pr_biz = new profileBiz();
		System.out.println(me_no);
		
		if(res>0) {
			pr_biz.insertProfile(me_no);
			jsResponse("가입되셨습니다. 로그인해주세요","login.jsp",response);
		}else {
			jsResponse("가입실패","regist.jsp",response);
		}
	
		
	}

	public void jsResponse(String msg, String url,HttpServletResponse response) throws IOException {
		PrintWriter out= response.getWriter();
		String res= "<script>alert('"+msg+"');location.href='"+url+"';</script>";
		
		out.print(res);
		
	}


	

}
