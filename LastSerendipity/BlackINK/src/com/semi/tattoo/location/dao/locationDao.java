package com.semi.tattoo.location.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.semi.tattoo.location.dto.locationDto;
import com.semi.tattoo.mybatis.SqlMapConfig;

public class locationDao extends SqlMapConfig{
	
	String namespace = "com.semi.tattoo.location.";
	
	public List<locationDto> searchLocation(String keyword) {
		SqlSession session = null;
		List<locationDto> list = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			list = session.selectList(namespace+"selectOneAddress", keyword);
			System.out.println("adr search 완료");
			
//			int cnt =1;
//			for(locationDto dto: list) {
//				System.out.println(cnt+" : " + dto.getMe_nic());
//				System.out.println(cnt+" : " + dto.getMe_no());
//				System.out.println(cnt+" : " + dto.getPr_adr_main());
//				System.out.println(cnt+" : " + dto.getPr_shopname());
//				cnt++;
//			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
