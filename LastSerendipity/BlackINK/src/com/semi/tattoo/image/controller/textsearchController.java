package com.semi.tattoo.image.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.semi.tattoo.tattooshare.biz.tattooshareBiz;
import com.semi.tattoo.tattooshare.dto.tattooshareDto;


@WebServlet("/textsearchController.do")
public class textsearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("textsearchController: "+command);
		
		if("textSearch".equals(command)) {
			String data = request.getParameter("data");
			
			JsonElement element = JsonParser.parseString(data);
			System.out.println(element.toString());
			String chk = element.toString().replaceAll("\"", "").replace("[", "").replace("]", "");
			System.out.println(chk);
			String[] checked = chk.split(",");
//			for(int i =0; i<checked.length; i++) {
//				System.out.println(checked[i]);
//			}
			
			tattooshareBiz biz = new tattooshareBiz();
			List<tattooshareDto> list = biz.selectTextsearchList(checked);
			
			JsonArray resultArray = new JsonArray();
			
			for(tattooshareDto ts_dto : list) {
				Gson gson = new Gson();
				String jsonString = gson.toJson(ts_dto);
				resultArray.add(JsonParser.parseString(jsonString));
			}
			
			System.out.println(resultArray);
			JsonObject result = new JsonObject();
			result.add("result", resultArray);
			
			response.getWriter().append(result+"");
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
