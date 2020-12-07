package com.semi.tattoo.tattooshare.dto;

import java.sql.Date;

public class tattooshareDto {

	private int ts_no;
	private int me_no;
	private String ts_writer;
	private String ts_title;
	private String ts_content;
	private Date ts_regdate;
	private int ts_readcount;
	private int ts_groupno;
	private int ts_step;
	private int im_no;
	private int ts_titletab;
	private String ts_delflag;
	private String im_servername;
	private String im_filepath;
	private String[] im_no_list;
	
	public tattooshareDto() {
		
	}
	
	public tattooshareDto(int im_no) {
		this.im_no = im_no;
	}
	
	public tattooshareDto(String ts_writer, String ts_title, String im_servername, String im_filepath) {
		this.ts_writer = ts_writer;
		this.ts_title = ts_title;
		this.im_servername = im_servername;
		this.im_filepath= im_filepath;
	}

	public tattooshareDto(int ts_no, int me_no, String ts_writer, String ts_title, String ts_content, Date ts_regdate,
		int ts_readcount, int ts_groupno, int ts_step, int im_no, int ts_titletab, String ts_delflag) {
		super();
		this.ts_no = ts_no;
		this.me_no = me_no;
		this.ts_writer = ts_writer;
		this.ts_title = ts_title;
		this.ts_content = ts_content;
		this.ts_regdate = ts_regdate;
		this.ts_readcount = ts_readcount;
		this.ts_groupno = ts_groupno;
		this.ts_step = ts_step;
		this.im_no = im_no;
		this.ts_titletab = ts_titletab;
		this.ts_delflag = ts_delflag;
	}

	public tattooshareDto(int ts_no, int me_no, String ts_writer, String ts_title, String ts_content, Date ts_regdate,
			int ts_readcount, int ts_groupno, int ts_step, int im_no, int ts_titletab, String ts_delflag,
			String im_servername, String im_filepath) {
		super();
		this.ts_no = ts_no;
		this.me_no = me_no;
		this.ts_writer = ts_writer;
		this.ts_title = ts_title;
		this.ts_content = ts_content;
		this.ts_regdate = ts_regdate;
		this.ts_readcount = ts_readcount;
		this.ts_groupno = ts_groupno;
		this.ts_step = ts_step;
		this.im_no = im_no;
		this.ts_titletab = ts_titletab;
		this.ts_delflag = ts_delflag;
		this.im_servername = im_servername;
		this.im_filepath = im_filepath;
	}

	
	
	public tattooshareDto(int ts_no, int me_no, String ts_writer, String ts_title, String ts_content, Date ts_regdate,
			int ts_readcount, int ts_groupno, int ts_step, int im_no, int ts_titletab, String ts_delflag,
			String im_servername, String im_filepath, String[] im_no_list) {
		super();
		this.ts_no = ts_no;
		this.me_no = me_no;
		this.ts_writer = ts_writer;
		this.ts_title = ts_title;
		this.ts_content = ts_content;
		this.ts_regdate = ts_regdate;
		this.ts_readcount = ts_readcount;
		this.ts_groupno = ts_groupno;
		this.ts_step = ts_step;
		this.im_no = im_no;
		this.ts_titletab = ts_titletab;
		this.ts_delflag = ts_delflag;
		this.im_servername = im_servername;
		this.im_filepath = im_filepath;
		this.im_no_list = im_no_list;
	}

	public int getTs_no() {
		return ts_no;
	}

	public void setTs_no(int ts_no) {
		this.ts_no = ts_no;
	}

	public int getMe_no() {
		return me_no;
	}

	public void setMe_no(int me_no) {
		this.me_no = me_no;
	}

	public String getTs_writer() {
		return ts_writer;
	}

	public void setTs_writer(String ts_writer) {
		this.ts_writer = ts_writer;
	}

	public String getTs_title() {
		return ts_title;
	}

	public void setTs_title(String ts_title) {
		this.ts_title = ts_title;
	}

	public String getTs_content() {
		return ts_content;
	}

	public void setTs_content(String ts_content) {
		this.ts_content = ts_content;
	}

	public Date getTs_regdate() {
		return ts_regdate;
	}

	public void setTs_regdate(Date ts_regdate) {
		this.ts_regdate = ts_regdate;
	}

	public int getTs_readcount() {
		return ts_readcount;
	}

	public void setTs_readcount(int ts_readcount) {
		this.ts_readcount = ts_readcount;
	}

	public int getTs_groupno() {
		return ts_groupno;
	}

	public void setTs_groupno(int ts_groupno) {
		this.ts_groupno = ts_groupno;
	}

	public int getTs_step() {
		return ts_step;
	}

	public void setTs_step(int ts_step) {
		this.ts_step = ts_step;
	}

	public int getIm_no() {
		return im_no;
	}

	public void setIm_no(int im_no) {
		this.im_no = im_no;
	}

	public int getTs_titletab() {
		return ts_titletab;
	}

	public void setTs_titletab(int ts_titletab) {
		this.ts_titletab = ts_titletab;
	}

	public String getTs_delflag() {
		return ts_delflag;
	}

	public void setTs_delflag(String ts_delflag) {
		this.ts_delflag = ts_delflag;
	}

	public String getIm_filepath() {
		return im_filepath;
	}

	public void setIm_filepath(String im_filepath) {
		this.im_filepath = im_filepath;
	}

	public String getIm_servername() {
		return im_servername;
	}

	public void setIm_filename(String im_servername) {
		this.im_servername = im_servername;
	}

	public String[] getIm_no_list() {
		return im_no_list;
	}

	public void setIm_no_list(String[] im_no_list) {
		this.im_no_list = im_no_list;
	}

	public void setIm_servername(String im_servername) {
		this.im_servername = im_servername;
	}
	
	
	
}
