package com.semi.tattoo.login.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.json.JSONParser;

import com.google.api.client.json.webtoken.JsonWebSignature.Header;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.semi.tattoo.location.dao.locationDao;
import com.semi.tattoo.login.biz.LoginBiz;
import com.semi.tattoo.login.dao.LoginDao;
import com.semi.tattoo.login.dto.LoginDto;
import com.semi.tattoo.utility.KakaoAPI;

@WebServlet("/NaverLoginCallback.do")
public class NaverLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println(command);
		
		if("join".equals(command)) {
			
			int r = (int)(Math.random()*1000000);
			
			String me_email ="BlackINK" + "@" +r;
			String me_nic = request.getParameter("nickname");
			String me_sns_token = request.getParameter("token");
			String me_sns_type = "NAVER";
			//System.out.println("join me_nic : " + me_nic);
			//System.out.println("me_email" + me_email);
			//System.out.println("me_sns_token" + me_sns_token);
			
			HttpSession session = request.getSession();
			LoginDao dao = new LoginDao();
			LoginBiz biz = new LoginBiz();
			LoginDto dto = dao.naverJoinCheck(me_sns_token);
			//System.out.println(dto.getMe_email());
			
			if(dto == null || dto.getMe_email()==null) {
				
				//System.out.println(me_email);
				//System.out.println(me_nic);
				
				LoginDto dto_insert = new LoginDto();
				dto_insert.setMe_email(me_email);
				dto_insert.setMe_name(me_nic);
				dto_insert.setMe_role("U");
				dto_insert.setMe_enabled("Y");
				dto_insert.setMe_sns_token(me_sns_token);
				dto_insert.setMe_sns_type(me_sns_type);
				
				// 네이버로 가입 
				int res = dao.naverInsert(dto_insert);
				dispatch("main.jsp",request,response);
			
			} else {
				
				if(dto.getMe_enabled().equals("N")) {
					biz.enabledUpdate(dto.getMe_no(), "Y");
					
				}
				System.out.println("naverEmailCheck email: "+dto.getMe_email());
				System.out.println("naverEmailCheck meno: "+dto.getMe_no());
				System.out.println("naverJoinCheck name: " + dto.getMe_name());
				
//				LoginDto naverCheck = dao.naverCheck("me_email", me_sns_token);
//				System.out.println(naverCheck.getMe_no());
//				System.out.println(naverCheck.getMe_name());
				
				
				if(me_sns_type == "NAVER") {
				
				session.setAttribute("me_no", dto.getMe_no());
				session.setAttribute("me_name", dto.getMe_name());
				session.setAttribute("me_email", dto.getMe_email());
				session.setAttribute("me_role", dto.getMe_role());
				session.setAttribute("me_sns_type",dto.getMe_sns_type());
				session.setAttribute("me_sns_token",dto.getMe_sns_token());
				
				System.out.println(session.getAttribute("me_role"));
				session.setMaxInactiveInterval(-1);
				
				dispatch("mypage.do?command=mypage&me_no="+session.getAttribute("me_no"),request,response);
				
				} else {
					jsResponse("네이버로그인이 아닙니다","login.jsp", response);

				}
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
