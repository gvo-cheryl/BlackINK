package com.semi.tattoo.tattooinfo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.tattoo.login.biz.LoginBiz;
import com.semi.tattoo.login.dto.LoginDto;
import com.semi.tattoo.tattooinfo.biz.tattooInfoBiz;
import com.semi.tattoo.tattooinfo.dto.tattooInfoDto;

@WebServlet("/appointment.do")
public class appointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		String command = request.getParameter("command");
		System.out.println("["+command+"]");
		LoginBiz lBiz = new LoginBiz();
		tattooInfoBiz tiBiz = new tattooInfoBiz();
		
		if(command.equals("insertAppointment")) {
			List<LoginDto> list = new ArrayList<LoginDto>();
			list = lBiz.searchTiList();
			request.setAttribute("list", list);
			dispatch("appointment.jsp", request, response);
		}else if(command.equals("insertAppointmentRes")) {
			int me_no = (int)session.getAttribute("me_no");
			int ti_tno = Integer.parseInt(request.getParameter("ti_tno"));
			String ti_date = request.getParameter("ti_date");
			String ti_time = request.getParameter("ti_time");
			String placement = request.getParameter("placement");
			String width = request.getParameter("width");
			String height = request.getParameter("height");
			String color = request.getParameter("color");
			String ti_content = request.getParameter("ti_content");
			
			if(!color.isEmpty()) {
				ti_content = "색 : " + color + "\n" + ti_content;
			}	
			if(!height.isEmpty()) {
				ti_content = "세로 : " + height + "\n" + ti_content;
			}
			if(!width.isEmpty()) {
				ti_content = "가로 : " + width + "\n" + ti_content;
			}
			ti_date = ti_date.replace("-", "");
			ti_time = ti_time.replace(":", "")+"00";
			System.out.println(ti_date);
			System.out.println(ti_time);
			tattooInfoDto tiDto = new tattooInfoDto(me_no,placement,ti_content,ti_tno,ti_date,ti_time);
			int res = tiBiz.insertTattooInfo(tiDto);
			
			if(res > 0) {
				dispatch("main.jsp", request, response);
			}
		}
	}
	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}
	
	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String result = "<script> alert('" + msg + "'); location.href='" + url +  "'; </script>";
		response.getWriter().append(result);
	}
}
