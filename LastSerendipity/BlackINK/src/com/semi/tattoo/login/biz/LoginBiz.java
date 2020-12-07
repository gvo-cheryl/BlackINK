package com.semi.tattoo.login.biz;

import java.util.HashMap;
import java.util.List;

import com.semi.tattoo.login.dao.LoginDao;
import com.semi.tattoo.login.dto.LoginDto;

public class LoginBiz {
	private LoginDao dao= new LoginDao();
	
	public LoginDto loginCheck(String me_email,String me_pw) {
		return dao.loginCheck(me_email, me_pw);
	}
	public int insert(LoginDto dto) {
		return dao.insert(dto);
	}
	public LoginDto myInfo(int me_no) {
		return dao.myInfo(me_no);
	}
	public int update(LoginDto dto) {
		return dao.update(dto);
	}
	public int enabledUpdate(int me_no, String enabled) {
		return dao.enabledUpdate(me_no, enabled);
	}
	public String searchEmail(String me_birth,String me_phone) {
		return dao.searchEmail(me_birth,me_phone);
	}
	public String searchPw(String me_email,String me_birth,String me_phone) {
		return dao.searchPw(me_email,me_birth,me_phone);
	}
	public LoginDto myhistory(int me_no) {
		return dao.myhistory(me_no);
	}
	public LoginDto interesttattoo(int me_no) {
		return dao.interesttattoo(me_no);
	}
	public LoginDto paymentDetails(int me_no) {
		return dao.paymentDetails(me_no);
	}
	public int kakaoAuthInsert(HashMap<String, Object> kakaoInfo) {
		LoginDto dto = new LoginDto();
		dto.setMe_email(kakaoInfo.get("me_email").toString());
		dto.setMe_name(kakaoInfo.get("me_nic").toString());
		dto.setMe_role("U");
		dto.setMe_sns_type("KAKAO");
		dto.setMe_sns_token(kakaoInfo.get("me_sns_token").toString());
		
		return dao.kakaoAuthInsert(dto);
	}
	public int naverInsert(LoginDto dto) {
		
		return dao.naverInsert(dto);
	}
	
	public LoginDto naverCheck (String me_email,String me_sns_type) {
		return dao.naverCheck(me_email, me_sns_type);
	}
	
	public LoginDto kakaoCheck (String me_email,String me_sns_type) {
		return dao.kakaoCheck(me_email,me_sns_type);
	}
	public int kakaoupdate(LoginDto dto) {
		return dao.kakaoupdate(dto);
	}
	public int kakaoUpdatePage(LoginDto dto) {
		return dao.kakaoUpdatePage(dto);
	}
	
	
	public int naverInfo(HashMap<String, Object> naverInfo) {
		LoginDto dto = new LoginDto();
		dto.setMe_email(naverInfo.get("me_email").toString());
		dto.setMe_name(naverInfo.get("me_name").toString());
		dto.setMe_role("U");
		dto.setMe_sns_type("NAVER");
		dto.setMe_sns_token(naverInfo.get("me_sns_token").toString());
		
		return dao.naverAuthInsert(dto);
	}
	
	public int searchMeno(String me_email) {
		return dao.searchMeno(me_email);
	}
	
	public List<LoginDto> searchTiList(){
      return dao.searchTiList();
    }

}

