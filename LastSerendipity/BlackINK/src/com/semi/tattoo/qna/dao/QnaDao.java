package com.semi.tattoo.qna.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.semi.tattoo.mybatis.SqlMapConfig;
import com.semi.tattoo.notice.dto.NoticeDto;
import com.semi.tattoo.qna.dto.QnaDto;

public class QnaDao extends SqlMapConfig {

	private String namespace = "com.semi.tattoo.qna.";

	public List<QnaDto> selectPage(int startCount, int endCount) {

		List<QnaDto> list = new ArrayList<QnaDto>(); // list 생성
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startCount", startCount);
		map.put("endCount", endCount);

		System.out.println(map);

		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(false); // 상솓받은 메소드 호출, session열음.
			list = session.selectList(namespace + "selectPage", map);
		} catch (Exception e) {
			System.out.println("dao - selectPage 에러!");
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	public QnaDto selectOne(int no) {

		QnaDto dto = new QnaDto();
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace + "selectOne", no);
		} catch (Exception e) {
			System.out.println("dto : " + dto);
			System.out.println("dao - selectone의 결과값 : " + dto);
			System.out.println("dao - selectOne 에러!");
			e.printStackTrace();
		}

		return dto;
	}

	public int insert(QnaDto dto) {

		int res = 0;
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.insert(namespace + "insert", dto);

		} catch (Exception e) {
			System.out.println("insert 에러!");
			e.printStackTrace();
		} finally {
			session.close();
			System.out.println("DAO에서 나온 res값 : " + res);
		}

		return res;
	}

	public int update(QnaDto dto) {

		int res = 0;
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace + "update", dto);

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
			res = session.delete(namespace + "delete", no);

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
			res = session.selectOne(namespace + "getCount");

		} catch (Exception e) {
			System.out.println("select-COUNT 에러!");
			e.printStackTrace();
		} finally {
			session.close();
			System.out.println("DAO에서 나온 res값 : " + res);
		}

		return res;
	}

	public int updateAnswer(int no) {
		int res = 0;
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace + "updateAnswer", no);

		} catch (Exception e) {
			System.out.println("update answer 에러!");
			e.printStackTrace();
		} finally {
			session.close();
			System.out.println("DAO에서 나온 res값 : " + res);
		}

		return res;
	}

	public int insertAnswer(QnaDto dto) {
		int res = 0;
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.insert(namespace + "insertAnswer", dto);

		} catch (Exception e) {
			System.out.println("insert answer 에러!");
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
			res = session.update(namespace + "viewCount", no);

		} catch (Exception e) {
			System.out.println("viewCOunt dao 에러!");
			e.printStackTrace();
		} finally {
			session.close();
			System.out.println("DAO에서 나온 res값 : " + res);
		}

		return res;
	}

	public String selectMyrole(int me_no) {

		String my_role = null;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			my_role = session.selectOne(namespace + "selectMyrole", me_no);
			session.commit();
		} catch (Exception e) {
			System.out.println("role 찾기 에러!");
			e.printStackTrace();
		} finally {
			session.close();
			System.out.println("DAO에서 나온 String : " + my_role);
		}

		return my_role;

	}

}