package com.semi.tattoo.image.dto;

import java.sql.Date;

public class imageDto {
	
	private int im_no;
	private int me_no;
	private String im_filename;
	private String im_servername;
	private String im_filepath;
	private Date im_regdate;
	private String me_nic;
	private String[] im_servername_list;
	private int[] me_no_list;
	private String ts_title;
	private int ts_no;
	private String[] im_no_list;
	
	public imageDto() {
		
	}

	public imageDto(int im_no, int me_no, String im_filename, String im_servername, String im_filepath,
			Date im_regdate) {
		super();
		this.im_no = im_no;
		this.me_no = me_no;
		this.im_filename = im_filename;
		this.im_servername = im_servername;
		this.im_filepath = im_filepath;
		this.im_regdate = im_regdate;
	}

	public imageDto(int im_no, int me_no, String im_filename, String im_servername, String im_filepath, Date im_regdate,
			String me_nic) {
		super();
		this.im_no = im_no;
		this.me_no = me_no;
		this.im_filename = im_filename;
		this.im_servername = im_servername;
		this.im_filepath = im_filepath;
		this.im_regdate = im_regdate;
		this.me_nic = me_nic;
	}

	public imageDto(int im_no, int me_no, String im_filename, String im_servername, String im_filepath, Date im_regdate,
			String me_nic, String[] im_servername_list, int[] me_no_list) {
		super();
		this.im_no = im_no;
		this.me_no = me_no;
		this.im_filename = im_filename;
		this.im_servername = im_servername;
		this.im_filepath = im_filepath;
		this.im_regdate = im_regdate;
		this.me_nic = me_nic;
		this.im_servername_list = im_servername_list;
		this.me_no_list = me_no_list;
	}
	
	

	public imageDto(int im_no, int me_no, String im_filename, String im_servername, String im_filepath, Date im_regdate,
			String me_nic, String[] im_servername_list, String ts_title, int ts_no) {
		super();
		this.im_no = im_no;
		this.me_no = me_no;
		this.im_filename = im_filename;
		this.im_servername = im_servername;
		this.im_filepath = im_filepath;
		this.im_regdate = im_regdate;
		this.me_nic = me_nic;
		this.im_servername_list = im_servername_list;
		this.ts_title = ts_title;
		this.ts_no = ts_no;
	}

	public imageDto(int im_no, int me_no, String im_filename, String im_servername, String im_filepath, Date im_regdate,
			String me_nic, String[] im_servername_list, int[] me_no_list, String ts_title, int ts_no,
			String[] im_no_list) {
		super();
		this.im_no = im_no;
		this.me_no = me_no;
		this.im_filename = im_filename;
		this.im_servername = im_servername;
		this.im_filepath = im_filepath;
		this.im_regdate = im_regdate;
		this.me_nic = me_nic;
		this.im_servername_list = im_servername_list;
		this.me_no_list = me_no_list;
		this.ts_title = ts_title;
		this.ts_no = ts_no;
		this.im_no_list = im_no_list;
	}

	public int getIm_no() {
		return im_no;
	}

	public void setIm_no(int im_no) {
		this.im_no = im_no;
	}

	public int getMe_no() {
		return me_no;
	}

	public void setMe_no(int me_no) {
		this.me_no = me_no;
	}

	public String getIm_filename() {
		return im_filename;
	}

	public void setIm_filename(String im_filename) {
		this.im_filename = im_filename;
	}

	public String getIm_servername() {
		return im_servername;
	}

	public void setIm_servername(String im_servername) {
		this.im_servername = im_servername;
	}

	public String getIm_filepath() {
		return im_filepath;
	}

	public void setIm_filepath(String im_filepath) {
		this.im_filepath = im_filepath;
	}

	public Date getIm_regdate() {
		return im_regdate;
	}

	public void setIm_regdate(Date im_regdate) {
		this.im_regdate = im_regdate;
	}

	public String getMe_nic() {
		return me_nic;
	}

	public void setMe_nic(String me_nic) {
		this.me_nic = me_nic;
	}

	public String[] getIm_servername_list() {
		return im_servername_list;
	}

	public void setIm_servername_list(String[] im_servername_list) {
		this.im_servername_list = im_servername_list;
	}

	public int[] getMe_no_list() {
		return me_no_list;
	}

	public void setMe_no_list(int[] me_no_list) {
		this.me_no_list = me_no_list;
	}

	public String getTs_title() {
		return ts_title;
	}

	public void setTs_title(String ts_title) {
		this.ts_title = ts_title;
	}

	public int getTs_no() {
		return ts_no;
	}

	public void setTs_no(int ts_no) {
		this.ts_no = ts_no;
	}

	public String[] getIm_no_list() {
		return im_no_list;
	}

	public void setIm_no_list(String[] im_no_list) {
		this.im_no_list = im_no_list;
	}
	
	
	
	
		

}
