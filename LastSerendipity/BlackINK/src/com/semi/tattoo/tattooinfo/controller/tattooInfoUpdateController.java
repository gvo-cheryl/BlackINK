package com.semi.tattoo.tattooinfo.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.JsonObject;
import com.semi.tattoo.tattooinfo.biz.tattooInfoBiz;
import com.semi.tattoo.tattooinfo.dto.tattooInfoDto;

@WebServlet("/tiUpdate.do")
public class tattooInfoUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/x-json; charset=UTF-8");
		response.setContentType("text/html; chatset=UTF-8");
		
		tattooInfoBiz biz = new tattooInfoBiz();
		String command = request.getParameter("command");
		
		if(command.equals("tattooInfoUpdate")) {
			String ti_no = request.getParameter("ti_no");
			
			Map<String,Object> dto = biz.selectOne(ti_no);
			System.out.println(dto.toString());
			JsonObject json = new JsonObject();
			json.addProperty("ti_no", dto.get("TI_NO").toString());
			json.addProperty("me_no", dto.get("ME_NO").toString());
			json.addProperty("me_name", String.valueOf(dto.get("ME_NAME")));
			System.out.println( dto.get("ME_NAME").toString());
			json.addProperty("ti_date", dto.get("TI_DATE").toString());
			json.addProperty("ti_time", dto.get("TI_TIME").toString());
			json.addProperty("ti_pay", dto.get("TI_PAY").toString());
			json.addProperty("ti_regdate", dto.get("TI_REGDATE").toString());
			json.addProperty("ti_state", dto.get("TI_STATE").toString());
			//System.out.println(dto.getTi_regdate().toString());
			response.getWriter().write(json+"");
		}else if(command.equals("updateRes")) {
			String ti_no = request.getParameter("ti_no");
			String ti_date = request.getParameter("ti_date");
			String ti_time = request.getParameter("ti_time_hour") + request.getParameter("ti_time_minute") + "00";
			String ti_pay = request.getParameter("ti_pay");
			String ti_state = request.getParameter("ti_state");
//			System.out.println(ti_no);
//			System.out.println(ti_date);
//			System.out.println(ti_time);
//			System.out.println(ti_pay);
//			System.out.println(ti_state);
			tattooInfoDto dto = new tattooInfoDto(Integer.parseInt(ti_no),Integer.parseInt(ti_pay),ti_date,ti_time,ti_state);
			int res = biz.updateTattooInfo(dto);
			response.getWriter().write(res+"");
		}else {
			System.out.println("command : " + command);
			dispatch("main.jsp",request,response);
		}
	}
	
	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}
}
