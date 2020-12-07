package com.semi.tattoo.hispay.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.semi.tattoo.hispay.biz.HispayBiz;
import com.semi.tattoo.hispay.dto.HispayDto;
import com.semi.tattoo.tattooinfo.controller.Util;
import com.semi.tattoo.tattooinfo.dto.tattooInfoDto;

@WebServlet("/hispay")
public class HispayController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HispayController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}
	
	private void dispatch(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {

		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);

	}
	
	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {

		String result = " <script> alert('" + msg + "'); location.href='" + url + "'; </script> ";
		response.getWriter().append(result);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
    	System.out.println("["+command+"]");
    	
    	HttpSession session = request.getSession();
		String me_email = session.getAttribute("me_email").toString();
    	int me_no = Integer.parseInt(session.getAttribute("me_no").toString());

    	HispayBiz biz = new HispayBiz();
    	
    	if("save".equals(command)) {
    			
    		String data = request.getParameter("sendData");
    		System.out.println(data);
    		
    		JsonElement element = JsonParser.parseString(data);
    		System.out.println(element);
    		
    		JsonObject jsonData = element.getAsJsonObject();
    		System.out.println(jsonData);
    		
    		String hi_method = jsonData.get("pay_method").getAsString();
    		String ti_no = jsonData.get("merchant_uid").getAsString();
    		int hi_pay = jsonData.get("real_amount").getAsInt();
    		String imp_uid = jsonData.get("imp_uid").getAsString();
    		
    		HispayDto insertInfo = new HispayDto();
    		insertInfo.setTi_no(Integer.parseInt(ti_no));
    		insertInfo.setHi_method(hi_method);
    		insertInfo.setHi_pay(hi_pay);
    		insertInfo.setHi_email(me_email);
    		insertInfo.setHi_no(imp_uid);
    		
    		int res = biz.insert(insertInfo);
    		
	    		if(res > 0) {
	    			
	    			HispayDto selectInfo = new HispayDto();
	    			selectInfo.setTi_no(Integer.parseInt(ti_no));
	    			selectInfo.setHi_no(imp_uid);
	    			
	    			HispayDto selectRes = biz.selectOne(selectInfo);
	    			
	    			// 제이슨 타입으로 만들어서 리턴해주기.
	    			Gson gson = new Gson();
	    			String jsonString = gson.toJson(selectRes);
	    			System.out.println(jsonString);
	    			
	    			JsonArray resultArray = new JsonArray();
	    			resultArray.add(JsonParser.parseString(jsonString));
	    			
	    			response.getWriter().append(resultArray+"");
	    		
	    		} else {
	    			
	    			jsResponse("결제 정보 저장에 실패하였습니다.", "main.jsp", response);
	    			
	    		}
    
    	} else if ("paid".equals(command)) {		// 결제 방식 선택 후, 결제 버튼 누르면
    		
    		/*
    		String data = request.getParameter("data");
    		JsonElement element = JsonParser.parseString(data);
    		JsonObject jsonData = element.getAsJsonObject();
    		
    		String hi_method = jsonData.get("hi_method").getAsString();
    		int ti_no = jsonData.get("ti_no").getAsInt();
    		*/
    		
    		String hi_method = request.getParameter("method");
    		int ti_no = Integer.parseInt(request.getParameter("ti_no"));
    		// System.out.println(hi_method);
    		// System.out.println(ti_no);
    		
    		HispayDto searchInfo = new HispayDto();
    		searchInfo.setMe_no(me_no);
    		searchInfo.setTi_no(ti_no);

    		HispayDto resultInfo = biz.selectInfo(searchInfo);
    		resultInfo.setHi_method(hi_method);
    		resultInfo.setHi_email(me_email);
    		
    		// 테이블 연결전에 임시로 사용할것
    		// HispayDto resultInfo = new HispayDto();
    		// resultInfo.setHi_method(hi_method);
    		// resultInfo.setHi_email(me_email);
    		// resultInfo.setTi_no(ti_no);
    		// resultInfo.setMe_no(me_no);
    		// resultInfo.setTi_pay(1000);
    		// resultInfo.setTi_title("시술 명");
    		// resultInfo.setHi_tel("010-3333-4444");
    		
    		System.out.println(resultInfo.getTi_pay());
    		
    		request.setAttribute("dto", resultInfo);
    		dispatch(request, response, "payres.jsp");
    		
    	} else if ("updateInfo".equals(command)) {
    		
    		int ti_no = Integer.parseInt(request.getParameter("ti_no"));
    		String hi_no = request.getParameter("hi_no");
    		
    		HispayDto updateInfo = new HispayDto();
    		updateInfo.setHi_no(hi_no);
    		updateInfo.setTi_no(ti_no);
    		updateInfo.setMe_no(me_no);
    		
    		int res = biz.update(updateInfo);
    		
    		if(res>0) {
    			
    			System.out.println("검증 후 저장 성공");
    			
    		}
    		
    	} else if ("updateBankInfo".equals(command)) {
    		
    		int ti_no = Integer.parseInt(request.getParameter("ti_no"));
    		String hi_bname = request.getParameter("hi_bname");
    		String hi_bnum = request.getParameter("hi_bnum");
    		String hi_bdate = request.getParameter("hi_bdate");
    		
    		HispayDto saveBankInfo = new HispayDto();
    		saveBankInfo.setMe_no(me_no);
    		saveBankInfo.setTi_no(ti_no);
    		saveBankInfo.setHi_bname(hi_bname);
    		saveBankInfo.setHi_bnum(hi_bnum);
    		saveBankInfo.setHi_bdate(hi_bdate);
    		
    		int res = biz.updateBankInfo(saveBankInfo);
    		
    		if(res>0) {
    			
    			System.out.println("가상계좌 정보 저장 성공");
    			
    		}
    		
    	} else if ("checkPay".equals(command)) {
    		
    		List<HispayDto> list = biz.select(me_no);
			request.setAttribute("list", list);
			
			Calendar cal = Calendar.getInstance();
			String ti_date = cal.get(Calendar.YEAR)+Util.isTwo((cal.get(Calendar.MONTH)+1)+"")+Util.isTwo(cal.get(Calendar.DATE)+"");
			System.out.println(ti_date);
			request.setAttribute("ti_date",ti_date);			
			//System.out.println(list.size());
			
			dispatch(request, response, "checkPay.jsp");
    		
    	}
	
	}

}
