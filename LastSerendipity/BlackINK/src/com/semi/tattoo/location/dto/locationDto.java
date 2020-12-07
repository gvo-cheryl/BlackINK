package com.semi.tattoo.location.dto;

public class locationDto {

	private String pr_adr_main;
	private int me_no;
	private String me_nic;
	private String pr_shopname;
	
	public locationDto() {
		
	}

	public locationDto(String pr_adr_main, int me_no, String me_nic, String pr_shopname) {
		super();
		this.pr_adr_main = pr_adr_main;
		this.me_no = me_no;
		this.me_nic = me_nic;
		this.pr_shopname = pr_shopname;
	}

	public String getPr_adr_main() {
		return pr_adr_main;
	}

	public void setPr_adr_main(String pr_adr_main) {
		this.pr_adr_main = pr_adr_main;
	}

	public int getMe_no() {
		return me_no;
	}

	public void setMe_no(int me_no) {
		this.me_no = me_no;
	}

	public String getMe_nic() {
		return me_nic;
	}

	public void setMe_nic(String me_nic) {
		this.me_nic = me_nic;
	}

	public String getPr_shopname() {
		return pr_shopname;
	}

	public void setPr_shopname(String pr_shopname) {
		this.pr_shopname = pr_shopname;
	}
	
	
	
}
