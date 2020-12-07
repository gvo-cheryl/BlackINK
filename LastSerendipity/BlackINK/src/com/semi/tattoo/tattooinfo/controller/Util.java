package com.semi.tattoo.tattooinfo.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.semi.tattoo.login.biz.LoginBiz;
import com.semi.tattoo.login.dto.LoginDto;
import com.semi.tattoo.tattooinfo.dto.tattooInfoDto;


public class Util {
	
	private String toDates;
	
	public String getToDates() {
		return toDates;
	}
	
	public void setToDates(String mdate) {
		// mdate의 형식을 yyyy-MM-dd hh:mm:00로 변환
		if(!mdate.isEmpty()) {
			System.out.println("mdate"+mdate);
			String m = mdate.substring(0,4)+"-"
					+ mdate.substring(4,6)+"-"
					+ mdate.substring(6,8)+" "
					+ mdate.substring(8,10)+":"
					+ mdate.substring(10,12)+":"
					+ mdate.substring(12);
			
			// SimpleDateFormat : date형식과 String형식이 서로 변환할 수 있는 클래스
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분");
			// Timestamp : DB에서 nanosecond단위까지 시간을 받아올수있는 클래스
			Timestamp tm = Timestamp.valueOf(m);
			toDates = sdf.format(tm);
		}
	}
	
	public static String getToday() {
		Calendar cal = Calendar.getInstance();
		String today = cal.get(Calendar.YEAR) + isTwo(cal.get(Calendar.MONTH)+1+"")
						+ isTwo(cal.get(Calendar.DAY_OF_MONTH)+"");
		System.out.println(today);
		return today;
	}
	
	public static String getOtherDay(int m,int d) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, m);
		cal.add(Calendar.DATE, d);
		String otherday = cal.get(Calendar.YEAR) + isTwo(cal.get(Calendar.MONTH)+1+"")
						+ isTwo(cal.get(Calendar.DAY_OF_MONTH)+"");
		System.out.println(otherday);
		return otherday;
	}
	
	public static String isTwo(String msg) {		
		return (msg.length() < 2)?"0"+msg:msg;
	}
	
	public static String fontColor(int date, int dayOfWeek) {
		String color = "";
		
		if((dayOfWeek-1+date)%7 == 0) {
			color="blue";
		}else if((dayOfWeek-1+date)%7 == 1) {
			color="red";
		}else {
			color="black";
		}
		
		return color;
	}
	
	public static String getCalView(int i, List<Map<String,String>> clist) {
        String res = "";

        String day = isTwo(i+"");
        //System.out.println(clist.size());
        for(Map<String,String> map :  clist) {
           
            if(map.get("TI_DATE").substring(6,8).equals(day)) {
            	String me_name = map.get("ME_NAME");
            	if(me_name == null) {
            		me_name = " ";
            	}else {
            		me_name += "님 ";
            	}
                res += "<p>" +
                		map.get("TI_TIME").substring(0, 2) + "시 " + me_name + "</p>";
            }
        }
		
		return res;
	}

	
	public static String getMname(int me_no) {
		LoginBiz biz = new LoginBiz();
		LoginDto lDto = new LoginDto();
		lDto = biz.myInfo(me_no);
		String me_name = lDto.getMe_name();
		System.out.println("me_name" + me_name);
		if(me_name.equals("") || me_name == null) {
			me_name = " ";
		}
		return me_name;
	}
//	
//	private static String getState(String ti_state) {
//		if(ti_state.equals("Y")) {
//			return "예약완료";
//		}else if(ti_state.equals("N")){
//			return "예약중";
//		}
//		return null;
//	}
	
}
