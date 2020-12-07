package com.semi.tattoo.tag.dto;

public class tagDto {
	
	private int im_no;
	private String ta_labeltag;
	private String ta_texttag;
	private String[] im_no_list;
	
	public tagDto() {
		
	}

	public tagDto(int im_no, String ta_labeltag, String ta_texttag) {
		super();
		this.im_no = im_no;
		this.ta_labeltag = ta_labeltag;
		this.ta_texttag = ta_texttag;
	}
	
	

	public tagDto(int im_no, String ta_labeltag, String ta_texttag, String[] im_no_list) {
		super();
		this.im_no = im_no;
		this.ta_labeltag = ta_labeltag;
		this.ta_texttag = ta_texttag;
		this.im_no_list = im_no_list;
	}

	public int getIm_no() {
		return im_no;
	}

	public void setIm_no(int im_no) {
		this.im_no = im_no;
	}

	public String getTa_labeltag() {
		return ta_labeltag;
	}

	public void setTa_labeltag(String ta_labeltag) {
		this.ta_labeltag = ta_labeltag;
	}

	public String getTa_texttag() {
		return ta_texttag;
	}

	public void setTa_texttag(String ta_texttag) {
		this.ta_texttag = ta_texttag;
	}

	public String[] getIm_no_list() {
		return im_no_list;
	}

	public void setIm_no_list(String[] im_no_list) {
		this.im_no_list = im_no_list;
	}
	
	
	

}
