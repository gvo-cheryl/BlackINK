package com.semi.tattoo.design.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.semi.tattoo.design.dto.DesignDto;
import com.semi.tattoo.mybatis.SqlMapConfig;

public class DesignDao extends SqlMapConfig {

	private String namespace = "design.";

	public int insert(DesignDto dto) {

		SqlSession session = null;
		int res = 0;

		session = getSqlSessionFactory().openSession(false);
		res = session.insert(namespace + "designInsert", dto);

		session.commit();
		session.close();

		return res;

	}

	public List<DesignDto> select(int me_no) {

		SqlSession session = null;
		List<DesignDto> list = new ArrayList<DesignDto>();

		session = getSqlSessionFactory().openSession(false);
		list = session.selectList(namespace + "designSelect", me_no);

		session.commit();
		session.close();

		return list;

	}

	public int delete(int ca_no) {

		SqlSession session = null;
		int res = 0;

		session = getSqlSessionFactory().openSession(false);
		res = session.insert(namespace + "designdelete", ca_no);

		session.commit();
		session.close();

		return res;

	}
	
	public DesignDto selectOne(int ca_no) {

		SqlSession session = null;
		DesignDto dto = new DesignDto();

		session = getSqlSessionFactory().openSession(false);
		dto = session.selectOne(namespace + "designDetail", ca_no);

		session.commit();
		session.close();

		return dto;

	}

}
