package com.semi.tattoo.location.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.semi.tattoo.location.biz.locationBiz;
import com.semi.tattoo.location.dto.locationDto;


@WebServlet("/location.do")
public class locationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String keyword = request.getParameter("keyword");
		System.out.println(keyword);
		
		locationBiz biz = new locationBiz();
		List<locationDto> list =  biz.searchLocation(keyword);
		
//		int cnt =1;
//		for(locationDto dto: list) {
//			System.out.println(cnt+".con : " + dto.getMe_nic());
//			System.out.println(cnt+" : " + dto.getMe_no());
//			System.out.println(cnt+" : " + dto.getPr_adr_main());
//			System.out.println(cnt+" : " + dto.getPr_shopname());
//			cnt++;
//		}
		
		JsonArray resultArray = new JsonArray();
		
		for(locationDto dto : list) {
			Gson gson = new Gson();
			String jsonString = gson.toJson(dto);
			resultArray.add(JsonParser.parseString(jsonString));
		}
		
		System.out.println(resultArray);
		JsonObject result = new JsonObject();
		result.add("result", resultArray);
		
		response.getWriter().append(result+"");
		

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
