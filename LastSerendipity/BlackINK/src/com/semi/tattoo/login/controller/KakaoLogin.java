package com.semi.tattoo.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.tattoo.login.biz.LoginBiz;
import com.semi.tattoo.login.dao.LoginDao;
import com.semi.tattoo.login.dto.LoginDto;
import com.semi.tattoo.utility.KakaoAPI;

@WebServlet("/kakaoOauth.do")
public class KakaoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		LoginBiz biz = new LoginBiz();
		
		String authorize_code = request.getParameter("code");
		String accsess_token = null;
		KakaoAPI kakaoApi = new KakaoAPI();
		HashMap<String, Object> kakaoInfo = new HashMap<String, Object>();
		
		accsess_token = kakaoApi.getKakaoAccessToken(authorize_code);
		kakaoInfo = kakaoApi.getKakaoInfo(accsess_token);
		
		kakaoInfo.put("me_sns_token", accsess_token);
		
		System.out.println(kakaoInfo);
		
		String me_email = kakaoInfo.get("me_email").toString();
		
		
		
		
		System.out.println(me_email);
		LoginDao dao= new LoginDao();
		LoginDto dto = dao.emailCheck(me_email);
		System.out.println(dto);
		HttpSession session = request.getSession();
		String me_sns_type = "KAKAO";
		System.out.println(me_sns_type);
		
		
		if(dto == null || dto.getMe_email() == null) { 
			//dto가 null이거나 email이 null이면
			//카카오가입
			int res = biz.kakaoAuthInsert(kakaoInfo);
			dispatch("main.jsp",request,response);
				
			
		}else {
			
			LoginDto kakaoCheck = biz.kakaoCheck(me_email,me_sns_type);
			
			System.out.println("me_no" + kakaoCheck.getMe_no());
			System.out.println("email" + kakaoCheck.getMe_email());
			
			
			
			if(me_sns_type.equals("KAKAO")) {
				//카카오로그인으로 가입한 사람인지 체크
				session.setAttribute("me_no", kakaoCheck.getMe_no());
				session.setAttribute("me_name", kakaoCheck.getMe_name());
				session.setAttribute("me_email", kakaoCheck.getMe_email());
				session.setAttribute("me_role", kakaoCheck.getMe_role());
				session.setAttribute("me_sns_type",kakaoCheck.getMe_sns_type());
				session.setAttribute("me_sns_token",kakaoCheck.getMe_sns_token());
				
				session.setMaxInactiveInterval(-1);
				
				dispatch("mypage.do?command=mypage&me_no="+session.getAttribute("me_no"),request,response);
				
			}else {
				
				jsResponse("카카오로그인이 아닙니다","login.jsp", response);
			}
			
			
		
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
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