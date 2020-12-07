package com.semi.tattoo.tattooshare.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.semi.tattoo.mybatis.SqlMapConfig;
import com.semi.tattoo.tag.dto.tagDto;
import com.semi.tattoo.tattooshare.dto.tattooshareDto;

public class tattooshareDao extends SqlMapConfig {

	String namespace = "com.semi.tattoo.tattooshare."; //selectTextsearchList

	public List<tattooshareDto> selectVisionList(List<tagDto> tagList) {
		List<tattooshareDto> list = new ArrayList<tattooshareDto>();

		SqlSession session = null;
		Map<String, List> map = new HashMap<String, List>();
		map.put("list", tagList);

		try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace + "selectVisionList", map);
			System.out.println("selectVisionList 실행");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public List<tattooshareDto> selectTextsearchList(String[] chkArr){
		SqlSession session = null;
		List<tattooshareDto> list = new ArrayList<tattooshareDto>();
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("list", chkArr);
		
		session = getSqlSessionFactory().openSession(false);
		list = session.selectList(namespace+"selectTextsearchList", map);
		System.out.println("text/chk으로 쿼리실행 완료");
		
		return list;
	}

	public List<tattooshareDto> tattooshareList() {
		List<tattooshareDto> tattooshareList = new ArrayList<tattooshareDto>();
		
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession();
			tattooshareList = session.selectList(namespace + "tattooshareList");
			System.out.println("tattooshareList 쿼리 실행 ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tattooshareList;
	}

	public void insertTsList(List<tattooshareDto> list) {
		SqlSession session = null;
		Map<String, List> map = new HashMap<String, List>();
		map.put("list", list);
		
		try {
			session = getSqlSessionFactory().openSession(false);
			session.insert(namespace + "insertTsList", map);
			session.commit();
			System.out.println("tattooshare insert 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int deleteTsList(String[] im_no_list) {
		SqlSession session = null;
		int res = 0;
		
		tattooshareDto dto = new tattooshareDto();
		dto.setIm_no_list(im_no_list);
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.delete(namespace+"deleteTsList", dto);
			System.out.println("tattooshare 삭제:" + res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public tattooshareDto selectOne(int im_no) {
		SqlSession session = null;
		tattooshareDto dto = new tattooshareDto();
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace+"selectOne", im_no);
			System.out.println("ts join img 쿼리 완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public int update(tattooshareDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace+"update", dto);
			System.out.println("ts update 완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}
}
































