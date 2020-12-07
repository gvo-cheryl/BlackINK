package com.semi.tattoo.livetalk.dto;

import java.sql.Date;

public class liveTalkDto {
	private int li_no;
	private int li_from_no;
	private int li_to_no;
	private String li_content;
	private Date li_regdate;
	
	public liveTalkDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public liveTalkDto(int li_no, int li_from_no, int li_to_no, String li_content, Date li_regdate) {
		super();
		this.li_no = li_no;
		this.li_from_no = li_from_no;
		this.li_to_no = li_to_no;
		this.li_content = li_content;
		this.li_regdate = li_regdate;
	}
	public int getLi_no() {
		return li_no;
	}
	public void setLi_no(int li_no) {
		this.li_no = li_no;
	}
	public int getLi_from_no() {
		return li_from_no;
	}
	public void setLi_from_no(int li_from_no) {
		this.li_from_no = li_from_no;
	}
	public int getLi_to_no() {
		return li_to_no;
	}
	public void setLi_to_no(int li_to_no) {
		this.li_to_no = li_to_no;
	}
	public String getLi_content() {
		return li_content;
	}
	public void setLi_content(String li_content) {
		this.li_content = li_content;
	}
	public Date getLi_regdate() {
		return li_regdate;
	}
	public void setLi_regdate(Date li_regdate) {
		this.li_regdate = li_regdate;
	}
}
