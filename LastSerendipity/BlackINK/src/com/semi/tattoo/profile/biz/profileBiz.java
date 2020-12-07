package com.semi.tattoo.profile.biz;

import com.semi.tattoo.profile.dao.profileDao;
import com.semi.tattoo.profile.dto.profileDto;

public class profileBiz {
	
	profileDao dao = new profileDao();
	
	public profileDto selectOne(int me_no) {
		return dao.selectOne(me_no);
	}
	
	public void insertProfile(int me_no) {
		dao.insertProfile(me_no);
	}
	
	public int profileUpdate(profileDto dto) {
		return dao.profileUpdate(dto);
	}

	public int deleteProfile(int me_no) {
		return dao.deleteProfile(me_no);
	}
}
