package com.semi.tattoo.tattooinfo.biz;

import java.util.List;
import java.util.Map;

import com.semi.tattoo.tattooinfo.dao.tattooInfoDao;
import com.semi.tattoo.tattooinfo.dto.tattooInfoDto;

public class tattooInfoBiz {
	private tattooInfoDao dao = new tattooInfoDao();
	
	public List<Map<String,String>> listCalBoard(int me_no,String ti_date){
		return dao.listCalBoard(me_no,ti_date);
	}
	public List<Map<String,String>> calendarViewList(tattooInfoDto dto){
		return dao.calendarViewList(dto);
	}
	
	public List<Map<String,String>> selectDetailList(String ti_tno, String ti_date2,String ti_date){
		return dao.selectDetailList(ti_tno, ti_date2, ti_date);
	}
	
	public Map<String,Object> selectOne(String ti_no) {
		return dao.selectOne(ti_no);
	}
	
	public int updateTattooInfo(tattooInfoDto dto) {
		return dao.updateTattooInfo(dto);
	}
	
	public int insertTattooInfo(tattooInfoDto dto) {
		return dao.insertTattooInfo(dto);
	}
	
	public List<Map<String,String>> selectMyList(int me_no){
		return dao.selectMyList(me_no);
	}
	
	public List<tattooInfoDto> selectTiList(int me_no){
		return dao.selectTiList(me_no);
	}
	
	public List<Map<String,String>> selectDetailMyList(String me_no, String ti_date2,String ti_date){
		return dao.selectDetailMyList(me_no, ti_date2, ti_date);
	}
}
