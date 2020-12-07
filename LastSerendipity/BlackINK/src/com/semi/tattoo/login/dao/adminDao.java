package com.semi.tattoo.login.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.semi.tattoo.login.dto.LoginDto;
import com.semi.tattoo.mybatis.SqlMapConfig;

public class adminDao extends SqlMapConfig {

	String namespace = "com.semi.tattoo.login.allList.";
	
	public List<LoginDto> userList(){
		SqlSession session = null;
		List<LoginDto> list = new ArrayList<LoginDto>();
		
		try {
			session = getSqlSessionFactory().openSession(false);
			list = session.selectList(namespace+"userList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}
	
	public LoginDto selectOne(int me_no) {
		SqlSession session = null;
		LoginDto dto = new LoginDto();
		
		try {
			session = getSqlSessionFactory().openSession(false);
			dto = session.selectOne(namespace+"selectOne", me_no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return dto;
	}
	
	public int updateRole(LoginDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace+"updateRole", dto);
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}
	
	public List<LoginDto> selectDetailSearch(LoginDto dto){
		SqlSession session = null;
		List<LoginDto> list = new ArrayList<LoginDto>();
		
		try {
			session = getSqlSessionFactory().openSession(true);
			list = session.selectList(namespace+"selectDetailSearch", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return list;
	}
}
