package com.semi.tattoo.tattooinfo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.semi.tattoo.mybatis.SqlMapConfig;
import com.semi.tattoo.tattooinfo.dto.tattooInfoDto;

public class tattooInfoDao extends SqlMapConfig{
	private String namespace = "timapper.";
	
	public List<Map<String,String>> listCalBoard(int me_no, String ti_date){
		Map<String,String> map = new HashMap<String, String>();
		map.put("me_no", me_no+"");
		map.put("ti_date", ti_date);
		SqlSession session = null;
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		session = getSqlSessionFactory().openSession();
		list = session.selectList(namespace+"listCalBoard", map);
		for(Map<String,String> map1 : list) {
			System.out.println(String.valueOf(map1.get("TI_TNO")));
		}
		session.close();
		return list;
	}
	
	public List<Map<String,String>> calendarViewList(tattooInfoDto dto){
		SqlSession session = null;
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		session = getSqlSessionFactory().openSession();
		list = session.selectList(namespace+"calendarViewList", dto);
		session.close();
		return list;
	}
	
	public List<Map<String,String>> selectDetailList(String ti_tno, String ti_date2,String ti_date){
		Map<String, String> map = new HashMap<String, String>();
		map.put("ti_tno", ti_tno);
		map.put("ti_date2", ti_date2);
		map.put("ti_date", ti_date);
		SqlSession session = null;
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		session = getSqlSessionFactory().openSession();
		list = session.selectList(namespace+"selectDetailList", map);
		session.close();
		return list;
	}
	
	public Map<String,Object> selectOne(String ti_no) {
		Map<String,Object> map = new HashMap<String, Object>();
		SqlSession session = null;
		session = getSqlSessionFactory().openSession();
		map = session.selectOne(namespace+"selectOne", ti_no);
		//System.out.println("ti_regdate"+dto.getTi_date());
		session.close();
		return map;
	}
	
	public int updateTattooInfo(tattooInfoDto dto) {
		int res = 0;
		SqlSession session = null;
		session = getSqlSessionFactory().openSession();
		res = session.update(namespace+"updateTattooInfo", dto);
		if(res>0) {
			session.commit();
		}
		session.close();
		return res;
	}
	
	public int insertTattooInfo(tattooInfoDto dto) {
		int res = 0;
		SqlSession session = null;
		session = getSqlSessionFactory().openSession();
		res = session.update(namespace+"insertTattooInfo", dto);
		if(res>0) {
			session.commit();
		}
		session.close();
		return res;
	}
	
	public List<Map<String,String>> selectMyList(int me_no){
		SqlSession session = null;
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		session = getSqlSessionFactory().openSession();
		list = session.selectList(namespace+"selectMyList", me_no);
		session.close();
		return list;
	}
	
	public List<tattooInfoDto> selectTiList(int me_no){
		SqlSession session = null;
		List<tattooInfoDto> list = new ArrayList<tattooInfoDto>();
		session = getSqlSessionFactory().openSession();
		list = session.selectList(namespace+"selectTiList", me_no);
		session.close();
		return list;
	}
	
	public List<Map<String,String>> selectDetailMyList(String me_no, String ti_date2,String ti_date){
		Map<String, String> map = new HashMap<String, String>();
		map.put("me_no", me_no);
		map.put("ti_date2", ti_date2);
		map.put("ti_date", ti_date);
		System.out.println("ti_date2:"+ti_date2);
		System.out.println("ti_date:"+ti_date);
		SqlSession session = null;
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		session = getSqlSessionFactory().openSession();
		list = session.selectList(namespace+"selectDetailMyList", map);
		session.close();
		return list;
	}
}
