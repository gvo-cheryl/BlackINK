package com.semi.tattoo.tattooinfo.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.semi.tattoo.tattooinfo.biz.tattooInfoBiz;
import com.semi.tattoo.tattooinfo.dto.tattooInfoDto;




@WebServlet("/proCal.do")
public class profileCalendarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		tattooInfoBiz biz = new tattooInfoBiz();
		int ti_tno = Integer.parseInt(request.getParameter("ti_tno"));
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String ti_date = null;
		if(year.isEmpty()||month.isEmpty()) {
			ti_date = Util.getToday().substring(6);
		}else {
			ti_date = year+Util.isTwo(month);
		}
		System.out.println("ti_date:"+ti_date);
		tattooInfoDto dto = new tattooInfoDto(ti_tno,ti_date);
		List<Map<String,String>> list = biz.calendarViewList(dto);	
		JsonArray jsonArray = listToJson(list);
		//System.out.println("ME_NAME:" + list.get(0).get("ME_NAME"));
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(year), Integer.parseInt(month), 1);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		JsonObject json = new JsonObject();
		json.addProperty("dayOfWeek", dayOfWeek);
		json.addProperty("lastDay", lastDay);
		json.add("jsonArray", jsonArray);
		response.getWriter().write(json.toString());	
	}
	
	public static String mapToJson(Map<String,String> map) {
		JsonObject json = new JsonObject();
		Gson gson = new Gson();
		String jsonString = gson.toJson(map);
		
		return jsonString;
	}
	
	public static JsonArray listToJson(List<Map<String,String>> list) {
		JsonArray jsonArray = new JsonArray();
		for(Map<String,String> map : list) {
			jsonArray.add(JsonParser.parseString(mapToJson(map)));
		}
		
		return jsonArray;
	}
}

