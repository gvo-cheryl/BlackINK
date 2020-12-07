package com.semi.tattoo.hispay.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.semi.tattoo.hispay.dto.HispayDto;
import com.semi.tattoo.login.dto.LoginDto;
import com.semi.tattoo.mybatis.SqlMapConfig;
import com.semi.tattoo.tattooinfo.dto.tattooInfoDto;

public class HispayDao extends SqlMapConfig {

	private String namespace = "hispay.";

	// 조회
	public HispayDto selectOne(HispayDto dto) {

		SqlSession session = null;
		HispayDto res = null;

		session = getSqlSessionFactory().openSession(false);
		res = session.selectOne(namespace + "selectOne", dto);

		session.commit();
		session.close();

		return res;

	}

	public List<HispayDto> select(int me_no) {

		SqlSession session = null;
		List<HispayDto> list = new ArrayList<HispayDto>();
		
		session = getSqlSessionFactory().openSession(false);
		list = session.selectList(namespace + "select",me_no);

		session.commit();
		session.close();
		
		return list;

	}

	// 입력
	public int insert(HispayDto dto) {

		SqlSession session = null;
		int res = 0;

		session = getSqlSessionFactory().openSession(false);
		res = session.insert(namespace + "insert", dto);

		session.commit();
		session.close();

		return res;

	}

	// 수정
	public int update(HispayDto dto) {

		SqlSession session = null;
		int res = 0;

		session = getSqlSessionFactory().openSession(false);
		res = session.insert(namespace + "updateInfo", dto);

		session.commit();
		session.close();

		return res;

	}

	public int updateBankInfo(HispayDto dto) {

		SqlSession session = null;
		int res = 0;

		session = getSqlSessionFactory().openSession(false);
		res = session.insert(namespace + "updateBankInfo", dto);

		session.commit();
		session.close();

		return res;

	}

	// 검색 : tattooinfo
	public HispayDto selectInfo(HispayDto dto) {

		// System.out.println(dto.getTi_no());

		SqlSession session = null;
		tattooInfoDto selectInfo = null;
		// tattooinfo 타입의 dto 선언하기

		String ti_no = Integer.toString(dto.getTi_no());

		session = getSqlSessionFactory().openSession(false);
		selectInfo = session.selectOne("timapper.selectOnes", ti_no);
		// tattooinfo 정보 받아오기.

		HispayDto res = new HispayDto();
		res.setTi_no(selectInfo.getTi_no());
		res.setMe_no(selectInfo.getMe_no());
		res.setTi_pay(selectInfo.getTi_pay());
		res.setTi_title(selectInfo.getTi_title());

		session.commit();
		session.close();

		return res;

	}
	
	public String selectState(int ti_no) {

		SqlSession session = null;
		String state = null;
		
		session = getSqlSessionFactory().openSession(false);
		state = session.selectOne(namespace + "state", ti_no);

		session.commit();
		session.close();
		
		return state;
	}

}
