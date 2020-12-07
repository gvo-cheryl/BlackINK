package com.semi.tattoo.design.biz;

import java.util.List;

import com.semi.tattoo.design.dao.DesignDao;
import com.semi.tattoo.design.dto.DesignDto;

public class DesignBiz {
	
	private DesignDao dao = new DesignDao();
	
	public int insert(DesignDto dto) {
		
		return dao.insert(dto);
		
	}
	
	public List<DesignDto> select(int me_no){
		
		return dao.select(me_no);
		
	}
	
	public int delete(int ca_no) {
		
		return dao.delete(ca_no);
		
	}
	
	public DesignDto selectOne(int ca_no){
		
		return dao.selectOne(ca_no);
		
	}

}
