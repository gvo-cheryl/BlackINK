package com.semi.tattoo.design.dto;

import java.util.Date;

public class DesignDto {

	private int ca_no;
	private int me_no;
	private String ca_filename;
	private String ca_servername;
	private String ca_filepath;
	private Date ca_regdate;
	
	public DesignDto() {

	}

	public DesignDto(int ca_no, int me_no, String ca_filename, String ca_servername, String ca_filepath,
			Date ca_regdate) {

		this.ca_no = ca_no;
		this.me_no = me_no;
		this.ca_filename = ca_filename;
		this.ca_servername = ca_servername;
		this.ca_filepath = ca_filepath;
		this.ca_regdate = ca_regdate;
	}

	public int getCa_no() {
		return ca_no;
	}

	public void setCa_no(int ca_no) {
		this.ca_no = ca_no;
	}

	public int getMe_no() {
		return me_no;
	}

	public void setMe_no(int me_no) {
		this.me_no = me_no;
	}

	public String getCa_filename() {
		return ca_filename;
	}

	public void setCa_filename(String ca_filename) {
		this.ca_filename = ca_filename;
	}

	public String getCa_servername() {
		return ca_servername;
	}

	public void setCa_servername(String ca_servername) {
		this.ca_servername = ca_servername;
	}

	public String getCa_filepath() {
		return ca_filepath;
	}

	public void setCa_filepath(String ca_filepath) {
		this.ca_filepath = ca_filepath;
	}

	public Date getCa_regdate() {
		return ca_regdate;
	}

	public void setCa_regdate(Date ca_regdate) {
		this.ca_regdate = ca_regdate;
	}

}
