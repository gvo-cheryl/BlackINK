package com.semi.tattoo.login.biz;

import java.util.List;

import com.semi.tattoo.login.dao.adminDao;
import com.semi.tattoo.login.dto.LoginDto;

public class adminBiz {
	
	adminDao adminDao = new adminDao();
	
	public List<LoginDto> userList(){
		return adminDao.userList();
	}
	
	public LoginDto selectOne(int me_no) {
		return adminDao.selectOne(me_no);
	}
	
	public int updateRole(LoginDto dto) {
		return adminDao.updateRole(dto);
	}
	
	public List<LoginDto> selectDetailSearch(LoginDto dto){
		if(dto.getMe_role_list()==null) {
			String [] me_role_list= {"U", "T", "A"};
			dto.setMe_role_list(me_role_list);
			for(String s: me_role_list) {
				System.out.println("biz_role: " + s);
			}
		} else {
			for(String s: dto.getMe_role_list()) {
				System.out.println("biz_role: " + s);
			}
		}
		
		if(dto.getMe_enabled_list()==null) {
			String [] me_enabled_list = {"Y", "N"};
			dto.setMe_enabled_list(me_enabled_list);
			for(String s: me_enabled_list) {
				System.out.println("biz_enabled: " + s);
			}
		} else {
			for(String s: dto.getMe_enabled_list()) {
				System.out.println("biz_enabled: " + s);
			}
		}
		
		
		
		return adminDao.selectDetailSearch(dto);
	}

}
