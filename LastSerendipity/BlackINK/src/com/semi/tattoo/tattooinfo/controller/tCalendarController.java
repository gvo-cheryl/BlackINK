package com.semi.tattoo.tattooinfo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.tattoo.tattooinfo.biz.tattooInfoBiz;
import com.semi.tattoo.tattooinfo.dto.tattooInfoDto;

@WebServlet("/tCalController.do")
public class tCalendarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		int me_no = (int)session.getAttribute("me_no");
		String command = request.getParameter("command");
		System.out.println("["+command+"]");

		tattooInfoBiz biz = new tattooInfoBiz();
		if(command.equals("listcal")) {
			String ti_date = null;
			if(request.getParameter("today")!=null) {
				ti_date = request.getParameter("today");
			}else {
				String year = request.getParameter("year");
				String month = request.getParameter("month");
				String date = request.getParameter("date");
				month = Util.isTwo(month);
				date = Util.isTwo(date);
				ti_date = year + month + date;
			}
			
			System.out.println(ti_date);
			List<Map<String,String>> list = biz.listCalBoard(me_no,ti_date);
			request.setAttribute("list", list);
			request.setAttribute("ti_date",ti_date);
			//System.out.println(list.size());
			dispatch("listcalboard_t.jsp", request, response);
		}else if(command.equals("listcaldetail")) {
			String ti_date = Util.getToday();
			String month = request.getParameter("month");
			String day = request.getParameter("day");
//			System.out.println(ti_date);

			String ti_date2 = Util.getOtherDay(Integer.parseInt(month), Integer.parseInt(day));
			
			System.out.println(ti_date+"~"+ti_date2);
			List<Map<String,String>> list = biz.selectDetailList(me_no+"",ti_date,ti_date2);
			
			request.setAttribute("list", list);
			//System.out.println(list.size());
			dispatch("listcalboard_t.jsp", request, response);
		}else if(command.equals("listcaldetail2")) {
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			
			List<Map<String,String>> list = biz.selectDetailList(me_no+"", startDate, endDate);
			request.setAttribute("list", list);
			dispatch("listcalboard_t.jsp", request, response);
		}else if(command.equals("listcals")) {
			String ti_date = Util.getToday();
			List<Map<String,String>> list = biz.selectDetailList(me_no+"","00000000","99999999");
			request.setAttribute("list", list);
			request.setAttribute("ti_date",ti_date);
			//System.out.println(list.size());
			dispatch("listcalboard_t.jsp", request, response);
		}
	}

	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}

}
