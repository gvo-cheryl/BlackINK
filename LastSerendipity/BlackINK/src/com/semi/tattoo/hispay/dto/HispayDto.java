package com.semi.tattoo.hispay.dto;

import java.util.Date;

public class HispayDto {

	private int ti_no;
	private int me_no;
	private String hi_no;
	private String hi_method;
	private int ti_pay;
	private int hi_pay;
	private String ti_title;
	private String hi_email;
	private Date hi_date;
	private String hi_state;
	private String hi_bname;
	private String hi_bnum;
	private String hi_bdate;
	
	public HispayDto() {

	}

	public HispayDto(int ti_no, int me_no, String hi_no, String hi_method, int ti_pay, int hi_pay, String ti_title,
			String hi_email, Date hi_date, String hi_state, String hi_bname, String hi_bnum,
			String hi_bdate) {

		this.ti_no = ti_no;
		this.me_no = me_no;
		this.hi_no = hi_no;
		this.hi_method = hi_method;
		this.ti_pay = ti_pay;
		this.hi_pay = hi_pay;
		this.ti_title = ti_title;
		this.hi_email = hi_email;
		this.hi_date = hi_date;
		this.hi_state = hi_state;
		this.hi_bname = hi_bname;
		this.hi_bnum = hi_bnum;
		this.hi_bdate = hi_bdate;
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

	public String getHi_no() {
		return hi_no;
	}

	public void setHi_no(String hi_no) {
		this.hi_no = hi_no;
	}

	public String getHi_method() {
		return hi_method;
	}

	public void setHi_method(String hi_method) {
		this.hi_method = hi_method;
	}

	public int getTi_pay() {
		return ti_pay;
	}

	public void setTi_pay(int ti_pay) {
		this.ti_pay = ti_pay;
	}

	public int getHi_pay() {
		return hi_pay;
	}

	public void setHi_pay(int hi_pay) {
		this.hi_pay = hi_pay;
	}

	public String getTi_title() {
		return ti_title;
	}

	public void setTi_title(String ti_title) {
		this.ti_title = ti_title;
	}

	public String getHi_email() {
		return hi_email;
	}

	public void setHi_email(String hi_email) {
		this.hi_email = hi_email;
	}

	public Date getHi_date() {
		return hi_date;
	}

	public void setHi_date(Date hi_date) {
		this.hi_date = hi_date;
	}

	public String getHi_state() {
		return hi_state;
	}

	public void setHi_state(String hi_state) {
		this.hi_state = hi_state;
	}

	public String getHi_bname() {
		return hi_bname;
	}

	public void setHi_bname(String hi_bname) {
		this.hi_bname = hi_bname;
	}

	public String getHi_bnum() {
		return hi_bnum;
	}

	public void setHi_bnum(String hi_bnum) {
		this.hi_bnum = hi_bnum;
	}

	public String getHi_bdate() {
		return hi_bdate;
	}

	public void setHi_bdate(String hi_bdate) {
		this.hi_bdate = hi_bdate;
	}

}
