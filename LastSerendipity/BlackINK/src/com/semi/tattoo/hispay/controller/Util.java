package com.semi.tattoo.hispay.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Util {
	
	private String toDates;
	
	public String getToDates() {
		return toDates;
	}
	
	public void setToDates(String mdate) {
		 
        SimpleDateFormat recvSimpleFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
 
        // 여기에 원하는 포맷을 넣어주면 된다
        SimpleDateFormat tranSimpleFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

			try {
				Date data = recvSimpleFormat.parse(mdate);
				this.toDates = tranSimpleFormat.format(data);
			} catch (ParseException e) {
				e.printStackTrace();
			}

	}
	
}