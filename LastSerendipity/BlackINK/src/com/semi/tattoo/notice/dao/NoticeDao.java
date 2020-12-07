package com.semi.tattoo.notice.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.semi.tattoo.mybatis.SqlMapConfig;
import com.semi.tattoo.notice.dto.NoticeDto;

public class NoticeDao extends SqlMapConfig{

	private String namespace = "com.semi.tattoo.notice";	
	
	public List<NoticeDto> selectList(){
		
		List<NoticeDto> list = new ArrayList<NoticeDto>(); // list 생성
		
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);	// 상솓받은 메소드 호출, session열음.
			list = session.selectList(namespace + ".selectList");
		} catch (Exception e) {
			System.out.println("dao - selectList 에러!");
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}
	
		public List<NoticeDto> selectPage(int startCount, int endCount){
		
		List<NoticeDto> list = new ArrayList<NoticeDto>(); // list 생성
		Map map = new HashMap();
		map.put("startCount", startCount);
		map.put("endCount", endCount);
		
		
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);	// 상솓받은 메소드 호출, session열음.
			list = session.selectList(namespace + ".selectPage", map);
		} catch (Exception e) {
			System.out.println("dao - selectPage 에러!");
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}
	
	public NoticeDto selectOne(int no) {
		
		NoticeDto dto = new NoticeDto();
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace + ".selectOne", no);
		} catch (Exception e) {
			System.out.println("dao - selectone의 결과값 : " + dto);
			System.out.println("dao - selectOne 에러!");
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public int insert(NoticeDto dto) {
		
		int res = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.insert(namespace + ".insert", dto);
			
			
		} catch (Exception e) {
			System.out.println("insert 에러!");
			e.printStackTrace();
		} finally {
			session.close();
			System.out.println("DAO에서 나온 res값 : " + res);
		}
		
		return res;
	}
	
	public int update(NoticeDto dto) {
		
		int res = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace + ".update", dto);
			
			
		} catch (Exception e) {
			System.out.println("update 에러!");
			e.printStackTrace();
		} finally {
			session.close();
			System.out.println("DAO에서 나온 res값 : " + res);
		}
		
		return res;
	}
	
	public int delete(int no) {
		
		int res = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.delete(namespace + ".delete", no);
			
			
		} catch (Exception e) {
			System.out.println("delete 에러!");
			e.printStackTrace();
		} finally {
			session.close();
			System.out.println("DAO에서 나온 res값 : " + res);
		}
		
		return res;
	}
	
	public int getCount() {
		int res = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.selectOne(namespace + ".getCount");
			
			
		} catch (Exception e) {
			System.out.println("select-COUNT 에러!");
			e.printStackTrace();
		} finally {
			session.close();
			System.out.println("DAO에서 나온 res값 : " + res);
		}
		
		return res;
	}
	public int viewCount(int no) {
		int res = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace + ".viewCount", no);
			
			
		} catch (Exception e) {
			System.out.println("select-viewCOUNT 에러!");
			e.printStackTrace();
		} finally {
			session.close();
			System.out.println("DAO에서 나온 res값 : " + res);
		}
		
		return res;
	}
}
