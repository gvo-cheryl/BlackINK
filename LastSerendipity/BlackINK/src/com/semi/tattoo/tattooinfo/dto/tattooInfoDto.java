package com.semi.tattoo.tattooinfo.dto;

import java.sql.Date;

public class tattooInfoDto {
	private int ti_no;
	private int me_no;
	private String ti_title;
	private String ti_content;
	private int ti_tno;
	private int ti_pay;
	private String ti_date;
	private String ti_time;
	private String ti_state;
	private Date ti_regdate;
	
	public tattooInfoDto() {
		super();
	}
	public tattooInfoDto(int ti_tno, String ti_date) {
		super();
		this.ti_tno = ti_tno;
		this.ti_date = ti_date;
	}
	public tattooInfoDto(int ti_no, int ti_pay, String ti_date,
			String ti_time, String ti_state) {
		super();
		this.ti_no = ti_no;
		this.ti_pay = ti_pay;
		this.ti_date = ti_date;
		this.ti_time = ti_time;
		this.ti_state = ti_state;
	}
	public tattooInfoDto(int me_no, String ti_title, String ti_content, int ti_tno, String ti_date,
			String ti_time) {
		super();
		this.me_no = me_no;
		this.ti_title = ti_title;
		this.ti_content = ti_content;
		this.ti_tno = ti_tno;
		this.ti_date = ti_date;
		this.ti_time = ti_time;
	}
	public tattooInfoDto(int ti_no, int me_no, String ti_title, String ti_content, int ti_tno, int ti_pay, String ti_date,
			String ti_time, String ti_state, Date ti_regdate) {
		super();
		this.ti_no = ti_no;
		this.me_no = me_no;
		this.ti_title = ti_title;
		this.ti_content = ti_content;
		this.ti_tno = ti_tno;
		this.ti_pay = ti_pay;
		this.ti_date = ti_date;
		this.ti_time = ti_time;
		this.ti_state = ti_state;
		this.ti_regdate = ti_regdate;
	}
	public int getTi_no() {
		return ti_no;
	}
	public void setTi_no(int ti_no) {
		this.ti_no = ti_no;
	}
	public int getMe_no() {
		return me_no;
	}
	public void setMe_no(int me_no) {
		this.me_no = me_no;
	}
	public String getTi_title() {
		return ti_title;
	}
	public void setTi_title(String ti_title) {
		this.ti_title = ti_title;
	}
	public String getTi_content() {
		return ti_content;
	}
	public void setTi_content(String ti_content) {
		this.ti_content = ti_content;
	}
	public int getTi_tno() {
		return ti_tno;
	}
	public void setTi_tno(int ti_tno) {
		this.ti_tno = ti_tno;
	}
	public int getTi_pay() {
		return ti_pay;
	}
	public void setTi_pay(int ti_pay) {
		this.ti_pay = ti_pay;
	}
	public String getTi_date() {
		return ti_date;
	}
	public void setTi_date(String ti_date) {
		this.ti_date = ti_date;
	}
	public String getTi_time() {
		return ti_time;
	}
	public void setTi_time(String ti_time) {
		this.ti_time = ti_time;
	}
	public String getTi_state() {
		return ti_state;
	}
	public void setTi_state(String ti_state) {
		this.ti_state = ti_state;
	}
	public Date getTi_regdate() {
		return ti_regdate;
	}
	public void setTi_regdate(Date ti_regdate) {
		this.ti_regdate = ti_regdate;
	}
	@Override
	public String toString() {
		return "tattooInfoDto [ti_no=" + ti_no + ", me_no=" + me_no + ", ti_title=" + ti_title + ", ti_content="
				+ ti_content + ", ti_tno=" + ti_tno + ", ti_pay=" + ti_pay + ", ti_date=" + ti_date + ", ti_time="
				+ ti_time + ", ti_state=" + ti_state + ", ti_regdate=" + ti_regdate + "]";
	}
	
}
