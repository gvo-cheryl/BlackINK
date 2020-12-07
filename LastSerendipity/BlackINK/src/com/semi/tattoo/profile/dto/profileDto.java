package com.semi.tattoo.profile.dto;

public class profileDto {
	
	private int me_no;
	private String pr_shopname;
	private String pr_open;
	private String pr_close;
	private String pr_post;
	private String pr_adr_main;
	private String pr_adr_d1;
	private String pr_adr_d2;
	private String pr_content;
	private String me_nic;
	
	public profileDto() {
		
	}

	public profileDto(int me_no, String pr_shopname, String pr_open, String pr_close, String pr_post,
			String pr_adr_main, String pr_adr_d1, String pr_adr_d2, String pr_content) {
		super();
		this.me_no = me_no;
		this.pr_shopname = pr_shopname;
		this.pr_open = pr_open;
		this.pr_close = pr_close;
		this.pr_post = pr_post;
		this.pr_adr_main = pr_adr_main;
		this.pr_adr_d1 = pr_adr_d1;
		this.pr_adr_d2 = pr_adr_d2;
		this.pr_content = pr_content;
	}

	public profileDto(int me_no, String pr_shopname, String pr_open, String pr_close, String pr_post,
			String pr_adr_main, String pr_adr_d1, String pr_adr_d2, String pr_content, String me_nic) {
		super();
		this.me_no = me_no;
		this.pr_shopname = pr_shopname;
		this.pr_open = pr_open;
		this.pr_close = pr_close;
		this.pr_post = pr_post;
		this.pr_adr_main = pr_adr_main;
		this.pr_adr_d1 = pr_adr_d1;
		this.pr_adr_d2 = pr_adr_d2;
		this.pr_content = pr_content;
		this.me_nic = me_nic;
	}

	public int getMe_no() {
		return me_no;
	}

	public void setMe_no(int me_no) {
		this.me_no = me_no;
	}

	public String getPr_shopname() {
		return pr_shopname;
	}

	public void setPr_shopname(String pr_shopname) {
		this.pr_shopname = pr_shopname;
	}

	public String getPr_open() {
		return pr_open;
	}

	public void setPr_open(String pr_open) {
		this.pr_open = pr_open;
	}

	public String getPr_close() {
		return pr_close;
	}

	public void setPr_close(String pr_close) {
		this.pr_close = pr_close;
	}

	public String getPr_post() {
		return pr_post;
	}

	public void setPr_post(String pr_post) {
		this.pr_post = pr_post;
	}

	public String getPr_adr_main() {
		return pr_adr_main;
	}

	public void setPr_adr_main(String pr_adr_main) {
		this.pr_adr_main = pr_adr_main;
	}

	public String getPr_adr_d1() {
		return pr_adr_d1;
	}

	public void setPr_adr_d1(String pr_adr_d1) {
		this.pr_adr_d1 = pr_adr_d1;
	}

	public String getPr_adr_d2() {
		return pr_adr_d2;
	}

	public void setPr_adr_d2(String pr_adr_d2) {
		this.pr_adr_d2 = pr_adr_d2;
	}

	public String getPr_content() {
		return pr_content;
	}

	public void setPr_content(String pr_content) {
		this.pr_content = pr_content;
	}

	public String getMe_nic() {
		return me_nic;
	}

	public void setMe_nic(String me_nic) {
		this.me_nic = me_nic;
	}
	
	

}
