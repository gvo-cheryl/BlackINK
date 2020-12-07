package com.semi.tattoo.tattooinfo.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
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

import com.semi.tattoo.hispay.biz.HispayBiz;
import com.semi.tattoo.hispay.dto.PayInfoDto;
import com.semi.tattoo.tattooinfo.biz.tattooInfoBiz;

@WebServlet("/uCalController.do")
public class uCalendarController extends HttpServlet {
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
      tattooInfoBiz biz = new tattooInfoBiz();
      int me_no = (int)session.getAttribute("me_no");
      
      if(command.equals("selectMyList")) {
			

			List<Map<String,String>> list = biz.selectMyList(me_no);
			// request.setAttribute("list", list);
			Calendar cal = Calendar.getInstance();
			String ti_date = cal.get(Calendar.YEAR)+Util.isTwo((cal.get(Calendar.MONTH)+1)+"")+Util.isTwo(cal.get(Calendar.DATE)+"");
			System.out.println(ti_date);
			request.setAttribute("ti_date",ti_date);			
			//System.out.println(list.size());
			
			List<PayInfoDto> result = new ArrayList<PayInfoDto>();
			
			for(Map<String,String> map : list) {
				PayInfoDto info = new PayInfoDto();
				String[] ti_regdate = String.valueOf(map.get("TI_REGDATE")).split("-");
				
				info.setTi_content(map.get("TI_CONTENT"));
				info.setMe_no(Integer.parseInt(String.valueOf(map.get("ME_NO"))));
				info.setTi_date(map.get("TI_DATE"));
				info.setTi_no(Integer.parseInt(String.valueOf(map.get("TI_NO"))));
				info.setTi_pay(Integer.parseInt(String.valueOf(map.get("TI_PAY"))));
				info.setTi_regdate(ti_regdate[0]+"년 "+ti_regdate[1]+"월 "+ti_regdate[2].substring(0,2)+"일");
				System.out.println("getTi_regdate:" + info.getTi_regdate());
				info.setTi_state(map.get("TI_STATE"));
				info.setTi_time(map.get("TI_TIME"));
				info.setTi_title(map.get("TI_TITLE"));
				info.setTi_tno(Integer.parseInt(String.valueOf(map.get("TI_TNO"))));
				info.setMe_nic(map.get("ME_NIC"));
				
				HispayBiz pay = new HispayBiz();			
				String res = pay.selectState(Integer.parseInt(String.valueOf(map.get("TI_NO"))));
				info.setHi_state(res);
				
				result.add(info);
			}
			
			request.setAttribute("list", result);
			
			dispatch("listcalboard_u.jsp", request, response);			
		}else if(command.equals("listcaldetail")) {
			String ti_date = Util.getToday();
			String month = request.getParameter("month");
			String day = request.getParameter("day");
//			System.out.println(ti_date);

			String ti_date2 = Util.getOtherDay(Integer.parseInt(month), Integer.parseInt(day));
			
			System.out.println(ti_date+"~"+ti_date2);
			List<Map<String,String>> list = biz.selectDetailMyList(me_no+"",ti_date,ti_date2);
			List<PayInfoDto> result = new ArrayList<PayInfoDto>();
			
			for(Map<String,String> map : list) {
				PayInfoDto info = new PayInfoDto();
				String[] ti_regdate = String.valueOf(map.get("TI_REGDATE")).split("-");
				
				info.setTi_content(map.get("TI_CONTENT"));
				info.setMe_no(Integer.parseInt(String.valueOf(map.get("ME_NO"))));
				info.setTi_date(map.get("TI_DATE"));
				info.setTi_no(Integer.parseInt(String.valueOf(map.get("TI_NO"))));
				info.setTi_pay(Integer.parseInt(String.valueOf(map.get("TI_PAY"))));
				info.setTi_regdate(ti_regdate[0]+"년 "+ti_regdate[1]+"월 "+ti_regdate[2].substring(0,2)+"일");
				System.out.println("getTi_regdate:" + info.getTi_regdate());
				info.setTi_state(map.get("TI_STATE"));
				info.setTi_time(map.get("TI_TIME"));
				info.setTi_title(map.get("TI_TITLE"));
				info.setTi_tno(Integer.parseInt(String.valueOf(map.get("TI_TNO"))));
				info.setMe_nic(map.get("ME_NIC"));
				
				HispayBiz pay = new HispayBiz();			
				String res = pay.selectState(Integer.parseInt(String.valueOf(map.get("TI_NO"))));
				info.setHi_state(res);
				
				result.add(info);
			}
			request.setAttribute("list", result);
			//System.out.println(list.size());
			dispatch("listcalboard_u.jsp", request, response);
		}else if(command.equals("listcaldetail2")) {
    	  	String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			
			List<Map<String,String>> list = biz.selectDetailMyList(me_no+"", startDate, endDate);
			List<PayInfoDto> result = new ArrayList<PayInfoDto>();
			
			for(Map<String,String> map : list) {
				PayInfoDto info = new PayInfoDto();
				String[] ti_regdate = String.valueOf(map.get("TI_REGDATE")).split("-");
				
				info.setTi_content(map.get("TI_CONTENT"));
				info.setMe_no(Integer.parseInt(String.valueOf(map.get("ME_NO"))));
				info.setTi_date(map.get("TI_DATE"));
				info.setTi_no(Integer.parseInt(String.valueOf(map.get("TI_NO"))));
				info.setTi_pay(Integer.parseInt(String.valueOf(map.get("TI_PAY"))));
				info.setTi_regdate(ti_regdate[0]+"년 "+ti_regdate[1]+"월 "+ti_regdate[2].substring(0,2)+"일");
				System.out.println("getTi_regdate:" + info.getTi_regdate());
				info.setTi_state(map.get("TI_STATE"));
				info.setTi_time(map.get("TI_TIME"));
				info.setTi_title(map.get("TI_TITLE"));
				info.setTi_tno(Integer.parseInt(String.valueOf(map.get("TI_TNO"))));
				info.setMe_nic(map.get("ME_NIC"));
				
				HispayBiz pay = new HispayBiz();			
				String res = pay.selectState(Integer.parseInt(String.valueOf(map.get("TI_NO"))));
				info.setHi_state(res);
				
				result.add(info);
			}
			
			request.setAttribute("list", result);
			dispatch("listcalboard_u.jsp", request, response);
      }
      /*
      else if(command.equals("successPaid")) {
         List<tattooInfoDto> list = biz.selectMyList(me_no);
         request.setAttribute("list", list);
         Calendar cal = Calendar.getInstance();
         String ti_date = cal.get(Calendar.YEAR)+Util.isTwo((cal.get(Calendar.MONTH)+1)+"")+Util.isTwo(cal.get(Calendar.DATE)+"");
         System.out.println(ti_date);
         request.setAttribute("ti_date",ti_date);
         String paid = "Y";
         request.setAttribute("paid", paid);
         //System.out.println(list.size());
         dispatch("listcalboard_u.jsp", request, response);
      }
      */
   }
   private void dispatch(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      RequestDispatcher dispatch = request.getRequestDispatcher(path);
      dispatch.forward(request, response);
   }
}