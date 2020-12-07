package com.semi.tattoo.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.semi.tattoo.login.biz.LoginBiz;
import com.semi.tattoo.login.biz.adminBiz;
import com.semi.tattoo.login.dto.LoginDto;
import com.semi.tattoo.utility.KakaoAPI;

@WebServlet("/mypage.do")
public class MypageUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String command = request.getParameter("command");
		System.out.println(command);
		
		adminBiz adminBiz = new adminBiz();

		if ("mypage".equals(command)) {

			LoginBiz biz = new LoginBiz();
			// HttpSession session = request.getSession();
			int me_no = Integer.parseInt(request.getParameter("me_no"));
			System.out.println("mypage me_no: " + me_no);
			LoginDto myinfo = biz.myInfo(me_no);
			// System.out.println(myinfo.getMe_no());

			if ("A".equals(myinfo.getMe_role())) {

				List<LoginDto> list = adminBiz.userList();

				request.setAttribute("list", list);
				dispatch("mypageAdmin.jsp", request, response);
			} else if ("U".equals(myinfo.getMe_role())) {
				System.out.println("phone: " + myinfo.getMe_phone());
				System.out.println("birth: " + myinfo.getMe_birth());

				
				if (myinfo.getMe_phone() == null || myinfo.getMe_birth() == null) {
					request.setAttribute("me_no", me_no);
					request.setAttribute("myinfo", myinfo);
					dispatch("mypageForm.jsp", request, response);
				} else {

					request.setAttribute("myinfo", myinfo);
					dispatch("mypage.jsp", request, response);
				}
				
			} else if ("T".equals(myinfo.getMe_role())) {
				
				if (myinfo.getMe_phone() == null || myinfo.getMe_birth() == null) {
					request.setAttribute("myinfo", myinfo);
					dispatch("mypageForm.jsp", request, response);
				} else {

					request.setAttribute("myinfo", myinfo);
					dispatch("mypage.jsp", request, response);
				}
				
			}

			

		} else if ("userUpdateForm".equals(command)) {
			int me_no = Integer.parseInt(request.getParameter("me_no"));

			LoginBiz biz = new LoginBiz();
			LoginDto myinfo = biz.myInfo(me_no);
			request.setAttribute("myinfo", myinfo);
			dispatch("mypageForm.jsp", request, response);

		} else if("updateRole".equals(command)) {	
			int me_no = Integer.parseInt(request.getParameter("me_no"));
			LoginDto dto = adminBiz.selectOne(me_no);
			request.setAttribute("dto", dto);
			dispatch("updateRole.jsp", request, response);
			
		} else if("updateRoleres".equals(command)) {
			int me_no = Integer.parseInt(request.getParameter("me_no"));
			String me_role = request.getParameter("me_role");
			System.out.println(me_no);
			System.out.println(me_role);
			
			LoginDto dto = new LoginDto();
			dto.setMe_no(me_no);
			dto.setMe_role(me_role);
			
			int res = adminBiz.updateRole(dto);
			PrintWriter writer = response.getWriter();
			
			if(res>0) {
				dispatch("mypage.do?command=mypage&me_no=1", request, response);
				
				//dispatch("mypage.do?command=mypage&me_no="+1, request, response);
				
			} else {
				LoginDto dto2 = adminBiz.selectOne(me_no);
				request.setAttribute("dto", dto2);
				dispatch("updateRole.jsp", request, response);
			}
						
			
		} else if("detailSearch".equals(command)) {
			String me_enabled = request.getParameter("me_enabled");
			JsonElement element = JsonParser.parseString(me_enabled);
			me_enabled = element.toString().replaceAll("\"", "").replace("[", "").replace("]", "");
			//System.out.println(me_enabled);
			String[] me_enabled_list = null;
			
			if(me_enabled.equals("")) {
				me_enabled = null;
				me_enabled_list = null;
				System.out.println("controller_enabled: " + me_enabled_list);
			} else {
				me_enabled_list = me_enabled.split(",");
//				for(String s: me_enabled_list) {
//					System.out.println(s);
//				}
			}
			
			
			String me_role = request.getParameter("me_role");
			JsonElement element2 = JsonParser.parseString(me_role);
			me_role = element2.toString().replaceAll("\"", "").replace("[", "").replace("]", "");
			//System.out.println(me_role);
			String[] me_role_list  = null;
			if(me_role.equals("")) {
				me_role=null;
				me_role_list=null;
				System.out.println("controller_role: " + me_role_list);
			} else {
				me_role_list = me_role.split(",");
//				for(String ss: me_role_list) {
//					System.out.println(ss);
//				}
			}
			
			
			
		
			LoginDto s_dto = new LoginDto();
			s_dto.setMe_enabled_list(me_enabled_list);
			s_dto.setMe_role_list(me_role_list);
			
			List<LoginDto> list = adminBiz.selectDetailSearch(s_dto);
			for(int i=1; i<=list.size(); i++) {
				System.out.println(i+ ": " +list.get(i-1).getMe_nic());
			}
			
			JsonArray resultArray = new JsonArray();
			
			for(LoginDto dto: list) {
				Gson gson = new Gson();
				String jsonString = gson.toJson(dto);
				resultArray.add(JsonParser.parseString(jsonString));
			}
			
			JsonObject result = new JsonObject();
			result.add("result", resultArray);
			response.getWriter().append(result+"");
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}
}
