package com.semi.tattoo.location.biz;

import java.util.List;

import com.semi.tattoo.location.dao.locationDao;
import com.semi.tattoo.location.dto.locationDto;

public class locationBiz {
	
	locationDao dao = new locationDao();
	
	public List<locationDto> searchLocation(String keyword) {
		keyword = keyword.toUpperCase();
		
		return dao.searchLocation(keyword);
	}

}
