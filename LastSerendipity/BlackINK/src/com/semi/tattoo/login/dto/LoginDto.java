package com.semi.tattoo.login.dto;

public class LoginDto {
	private int me_no;
	private String me_email;
	private String me_pw;
	private String me_name;
	private String me_nic;
	private String me_birth;
	private String store_zipcode;
	private String store_addr;
	private String store_addr_dtl;
	private String me_phone;
	private String me_enabled;
	private String me_role;
	private String me_sns_type;
	private String me_sns_token;
	private String[] me_enabled_list;
	private String[] me_role_list;
	
	public LoginDto() {
		
	}
	
	public LoginDto(int me_no,String me_email,String me_pw,String me_name,String me_nic,String me_birth,String store_zipcode , String store_addr, String store_addr_dtl, String me_phone,String me_enabled,String me_role,String me_sns_type, String me_sns_token) {
		this.me_no=me_no;
		this.me_email=me_email;
		this.me_pw=me_pw;
		this.me_name=me_name;
		this.me_nic=me_nic;
		this.me_birth=me_birth;
		this.store_zipcode=store_zipcode;
		this.store_addr=store_addr;
		this.store_addr_dtl=store_addr_dtl;
		this.me_email=me_email;
		this.me_phone=me_phone;
		this.me_enabled=me_enabled;
		this.me_role=me_role;
		this.me_sns_type=me_sns_type;
		this.me_sns_token=me_sns_token;
		
	}
	
	public LoginDto(int me_no, String me_email, String me_pw, String me_name, String me_nic, String me_birth,
			String store_zipcode, String store_addr, String store_addr_dtl, String me_phone, 
			String me_sns_type, String me_sns_token, String[] me_enabled_list, String[] me_role_list) {
		super();
		this.me_no = me_no;
		this.me_email = me_email;
		this.me_pw = me_pw;
		this.me_name = me_name;
		this.me_nic = me_nic;
		this.me_birth = me_birth;
		this.store_zipcode = store_zipcode;
		this.store_addr = store_addr;
		this.store_addr_dtl = store_addr_dtl;
		this.me_phone = me_phone;
		this.me_sns_type = me_sns_type;
		this.me_sns_token = me_sns_token;
		this.me_enabled_list = me_enabled_list;
		this.me_role_list = me_role_list;
	}
	public LoginDto(String me_email, String me_pw) {
		this.me_email=me_email;
		this.me_pw=me_pw;
	}
	public String getStore_zipcode() {
		return store_zipcode;
	}
	public void setStore_zipcode(String store_zipcode) {
		this.store_zipcode = store_zipcode;
	}
	public String getStore_addr() {
		return store_addr;
	}
	public void setStore_addr(String store_addr) {
		this.store_addr = store_addr;
	}
	public String getStore_addr_dtl() {
		return store_addr_dtl;
	}
	public void setStore_addr_dtl(String store_addr_dtl) {
		this.store_addr_dtl = store_addr_dtl;
	}
	public int getMe_no() {
		return me_no;
	}
	public void setMe_no(int me_no) {
		this.me_no = me_no;
	}
	public String getMe_email() {
		return me_email;
	}
	public void setMe_email(String me_email) {
		this.me_email = me_email;
	}
	public String getMe_pw() {
		return me_pw;
	}
	public void setMe_pw(String me_pw) {
		this.me_pw = me_pw;
	}
	public String getMe_name() {
		return me_name;
	}
	public void setMe_name(String me_name) {
		this.me_name = me_name;
	}
	public String getMe_nic() {
		return me_nic;
	}
	public void setMe_nic(String me_nic) {
		this.me_nic = me_nic;
	}
	public String getMe_birth() {
		return me_birth;
	}
	public void setMe_birth(String me_birth) {
		this.me_birth = me_birth;
	}
	
	public String getMe_phone() {
		return me_phone;
	}
	public void setMe_phone(String me_phone) {
		this.me_phone = me_phone;
	}
	public String getMe_enabled() {
		return me_enabled;
	}
	public void setMe_enabled(String me_enabled) {
		this.me_enabled = me_enabled;
	}
	public String getMe_role() {
		return me_role;
	}
	public void setMe_role(String me_role) {
		this.me_role = me_role;
	}
	public String getMe_sns_type() {
		return me_sns_type;
	}
	public void setMe_sns_type(String me_sns_type) {
		this.me_sns_type = me_sns_type;
	}
	public String getMe_sns_token() {
		return me_sns_token;
	}
	public void setMe_sns_token(String me_sns_token) {
		this.me_sns_token = me_sns_token;
	}

	public String[] getMe_enabled_list() {
		return me_enabled_list;
	}

	public void setMe_enabled_list(String[] me_enabled_list) {
		this.me_enabled_list = me_enabled_list;
	}

	public String[] getMe_role_list() {
		return me_role_list;
	}

	public void setMe_role_list(String[] me_role_list) {
		this.me_role_list = me_role_list;
	}
	

}
