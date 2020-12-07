package com.semi.tattoo.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.tattoo.login.biz.LoginBiz;
import com.semi.tattoo.login.dto.LoginDto;
import com.semi.tattoo.profile.biz.profileBiz;


@WebServlet("/delete.do")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		int me_no = Integer.parseInt(request.getParameter("me_no"));
		//System.out.println("delete.do me_no: "+me_no);
		
		LoginDto delete = new LoginDto();
		delete.setMe_no(me_no);
		System.out.println("delete.getMe_no: "+delete.getMe_no());
		LoginBiz biz= new LoginBiz();
		
		profileBiz pr_biz = new profileBiz();
		String me_role = biz.myInfo(me_no).getMe_role();
		System.out.println(me_role);
		
		
		if(me_role.equals("U")) {
			//일발회원 member 삭제
			int res = biz.enabledUpdate(me_no, "N");
			session.invalidate();
			
			if(res>0) {
				jsResponse("탈퇴되셨습니다","login.jsp", response);
			}
		} else if(me_role.equals("T")) {
			//타투이스트 프로필 삭제
			int pr_res = pr_biz.deleteProfile(me_no);
			
			if(pr_res>0) {
				//타투이스트 member 삭제
				int res = biz.enabledUpdate(me_no, "N");
				session.invalidate();
				
				if(res>0) {
					jsResponse("탈퇴되셨습니다","login.jsp", response);
				}
			}
		}
		
	}
	
	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException{
		PrintWriter out= response.getWriter();
		String res="<script>alert('"+msg+"'); location.href='"+url+"';</script>";
		out.print(res);
	}

}
