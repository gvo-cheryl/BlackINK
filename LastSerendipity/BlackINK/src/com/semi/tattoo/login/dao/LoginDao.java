package com.semi.tattoo.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.semi.tattoo.login.dto.LoginDto;
import com.semi.tattoo.mybatis.SqlMapConfig;

public class LoginDao extends SqlMapConfig{
	private String namespace="com.semi.tattoo.";
	
	public LoginDto loginCheck(String me_email, String me_pw) {
		SqlSession session = null;
		LoginDto dto = new LoginDto();
		LoginDto logindto= new LoginDto(me_email,me_pw); 
		
		
		try {
		session = getSqlSessionFactory().openSession(true);
		dto = session.selectOne(namespace+"loginCheck",logindto);
		
		}catch  (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	}
	public int insert(LoginDto dto) {
		SqlSession session = null;
		int res= 0; 
		
		session = getSqlSessionFactory().openSession();
		res= session.insert(namespace+"insert",dto);
		session.commit();
		session.close();
		return res;
	}
	public LoginDto emailCheck(String me_email) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url="jdbc:oracle:thin:@qclass.iptime.org:1521:xe";
		String user="master01_semi";
		String password="semi";
		Connection con= null;
		
		try {
			con= DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement pstm = null;
		ResultSet rs = null;
		LoginDto dto = new LoginDto();
		String sql = " SELECT ME_EMAIL FROM MEMBER WHERE ME_EMAIL=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1,me_email);
			
			rs = pstm.executeQuery();
			while(rs.next()) {
				dto.setMe_email(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return dto;
		
	}
	
	public LoginDto myInfo(int me_no) {
		SqlSession session = null;
		LoginDto dto = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace + "myInfo", me_no);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	}
	
	public int update(LoginDto dto) {
		SqlSession session = null;
		int res = 0;
		session = getSqlSessionFactory().openSession(true);
		res = session.update(namespace + "update", dto);
		session.close();
		return res;
	}
	
	public int enabledUpdate(int me_no, String enabled) {
		SqlSession session = null;
		int res = 0;
		LoginDto dto = new LoginDto();
		dto.setMe_no(me_no);
		dto.setMe_enabled(enabled);
		
		session = getSqlSessionFactory().openSession(true);
		res = session.delete(namespace + "enabledUpdate", dto);
		session.close();
		return res;
	}
	
	public String searchEmail(String me_birth, String me_phone) {
		SqlSession session = null;
		String searchEmail = null;
		
		LoginDto searchDto = new LoginDto(); 
		searchDto.setMe_birth(me_birth);
		searchDto.setMe_phone(me_phone);
		
		try {
		session = getSqlSessionFactory().openSession(true);
		searchEmail = session.selectOne(namespace+"searchEmail",searchDto);
		System.out.println("dao searchEmail:::" + searchEmail);
		}catch  (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return searchEmail;
	}
	public String searchPw(String me_email,String me_birth, String me_phone) {
		SqlSession session = null;
		String searchPw = null;
		
		LoginDto searchDto = new LoginDto(); 
		searchDto.setMe_email(me_email);
		searchDto.setMe_birth(me_birth);
		searchDto.setMe_phone(me_phone);
		
		try {
		session = getSqlSessionFactory().openSession(true);
		searchPw = session.selectOne(namespace+"searchPw",searchDto);
		System.out.println("dao searchPw:::" + searchPw);
		}catch  (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return searchPw;
	}
	public LoginDto myhistory(int me_no) {
		SqlSession session = null;
		LoginDto dto = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace + "mypage", me_no);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
		
	}
	public LoginDto interesttattoo(int me_no) {
		SqlSession session = null;
		LoginDto dto = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace + "mypage", me_no);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
		
	}
	public LoginDto paymentDetails(int me_no) {
		SqlSession session = null;
		LoginDto dto = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace + "mypage", me_no);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	}
	public int kakaoAuthInsert(LoginDto dto) {
		SqlSession session = null;
		int res= 0; 
		
		session = getSqlSessionFactory().openSession();
		res= session.insert(namespace+"insert",dto);
		session.commit();
		session.close();
		
		
		return res;
	}
	
	public int naverInsert(LoginDto dto) {
		SqlSession session = null;
		int res= 0; 
		
		session = getSqlSessionFactory().openSession();
		res= session.insert(namespace+"naverInsert",dto);
		session.commit();
		session.close();
		
		return res; 
	}
	
	public LoginDto naverJoinCheck(String me_sns_token) {
		SqlSession session = null;
		LoginDto dto = new LoginDto();
		
		session = getSqlSessionFactory().openSession(true);
		dto = session.selectOne(namespace+"naverJoinCheck", me_sns_token);
		session.close();
		
		return dto;
	}
	
	public LoginDto kakaoCheck (String me_email,String me_sns_type) {
		SqlSession session = null;
		LoginDto dto = new LoginDto();
		LoginDto kakakodto= new LoginDto(me_email,me_sns_type); 
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace + "kakaoCheck", kakakodto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	
	}
	
	public LoginDto naverCheck (String me_email,String me_sns_token) {
		SqlSession session = null;
		LoginDto dto = new LoginDto();
		LoginDto kakaodto= new LoginDto(me_email,me_sns_token); 
		System.out.println(kakaodto.getMe_email());
		System.out.println(kakaodto.getMe_sns_type());
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace + "naverCheck", kakaodto);
			System.out.println("navercheck 완료");
			System.out.println(dto.getMe_email());
			System.out.println(dto.getMe_no());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	
	}
	
	public int kakaoupdate(LoginDto dto) {
		SqlSession session = null;
		int res = 0;
		session = getSqlSessionFactory().openSession(true);
		res = session.update(namespace + "kakaoupdate", dto);
		session.close();
		return res;
	}
	
	public int kakaoUpdatePage(LoginDto dto) {
		SqlSession session = null;
		int res = 0;
		session = getSqlSessionFactory().openSession(true);
		res = session.update(namespace + "kakaoupdatepage", dto);
		session.close();
		return res;
	}
	
	public int naverAuthInsert(LoginDto dto) {
		SqlSession session = null;
		int res= 0; 
		
		session = getSqlSessionFactory().openSession();
		res= session.insert(namespace+"insert",dto);
		session.commit();
		session.close();
		return res;
	}
	
	public int searchMeno(String me_email) {
		SqlSession session = null;
		int me_no = 0;
		
		session = getSqlSessionFactory().openSession(true);
		me_no = session.selectOne(namespace+"searchMeno", me_email);
		System.out.println("searchMeno 성공: " + me_no);
		
		return me_no;
	}
	
	public List<LoginDto> searchTiList(){
	      List<LoginDto> list = new ArrayList<LoginDto>();
	      SqlSession session = null;
	      session = getSqlSessionFactory().openSession();
	      list = session.selectList(namespace+"searchTiList");
	      session.close();
	      return list;
	   }
	
	
}
