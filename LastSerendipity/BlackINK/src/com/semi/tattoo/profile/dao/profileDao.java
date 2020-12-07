package com.semi.tattoo.profile.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.semi.tattoo.login.dto.LoginDto;
import com.semi.tattoo.mybatis.SqlMapConfig;
import com.semi.tattoo.profile.dto.profileDto;

public class profileDao extends SqlMapConfig{
	
	String namespace = "com.semi.tattoo.profile.";
	
	public profileDto selectOne(int me_no) {
		SqlSession session = null;
		profileDto dto = new profileDto();
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace+"selectOne", me_no);
			System.out.println(dto.getPr_shopname());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}

		return dto;
	}
	
	public void insertProfile(int me_no) {
		SqlSession session = null;		
		
		try {
			session = getSqlSessionFactory().openSession(true);
			session.insert(namespace+"insertProfile", me_no);
			System.out.println("profile 생성 완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	
	public int profileUpdate(profileDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace+"profileUpdate", dto);
			System.out.println("profileUpdate 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}
	
	public int deleteProfile(int me_no) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.delete(namespace+"deleteProfile", me_no);
		
		if(res>0) {
			System.out.println("deleteProfile 성공: " +  res);
		}
		
		
		return res;
	}
	
	

}




































