package com.semi.tattoo.tag.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.semi.tattoo.image.dto.imageDto;
import com.semi.tattoo.mybatis.SqlMapConfig;
import com.semi.tattoo.tag.dto.tagDto;

public class tagDao extends SqlMapConfig{
	
	String namespace = "com.semi.tattoo.tag.";
	
	public void insertTag(List<tagDto> tagList) {
		SqlSession session = null;
		Map<String, List> map = new HashMap<String, List>();
		map.put("list", tagList);
		
		for(tagDto dto: tagList) {
//			System.out.println("dto.im_no : " + dto.getIm_no());
//			System.out.println("dto.ta_label : " + dto.getTa_labeltag());
//			System.out.println("dto.ta_text : " + dto.getTa_texttag());
		}
		
		try {
			session = getSqlSessionFactory().openSession(false);
			session.insert(namespace+"insertTag", tagList);
			session.commit();
			System.out.println("tag insert 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	public int deleteTagList(String[] im_no_list) {
		SqlSession session = null;
		int res = 0;
		
		tagDto dto = new tagDto();
		dto.setIm_no_list(im_no_list);
		
		session = getSqlSessionFactory().openSession(true);
		res = session.delete(namespace+"deleteTagList", dto);
		System.out.println("tag삭제: "+ res);
		
		return res;
	}
	
	public List<tagDto> selectList(int im_no){
		SqlSession session = null;
		List<tagDto> list = new ArrayList<tagDto>();
		
		try {
			session = getSqlSessionFactory().openSession(true);
			list = session.selectList(namespace+"selectList", im_no);
			System.out.println("tagList 출력완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
