package com.semi.tattoo.hispay.biz;

import java.util.List;

import com.semi.tattoo.hispay.dao.HispayDao;
import com.semi.tattoo.hispay.dto.HispayDto;

public class HispayBiz {

	private HispayDao dao = new HispayDao();
	
	public HispayDto selectOne(HispayDto dto) {

		return dao.selectOne(dto);

	}
	
	public List<HispayDto> select(int me_no){
		
		return dao.select(me_no);
		
	}

	// 입력
	public int insert(HispayDto dto) {

		return dao.insert(dto);

	}

	// 수정
	public int update(HispayDto dto) {

		return dao.update(dto);

	}
	
	public int updateBankInfo(HispayDto dto) {
		
		return dao.updateBankInfo(dto);
		
	}

	// 검색
	public HispayDto selectInfo(HispayDto dto) {
		
		HispayDto result = new HispayDto();
		result = dao.selectInfo(dto);
		
		return result;
		
	}

	public String selectState(int ti_no) {
		
		return dao.selectState(ti_no);
	}
}
