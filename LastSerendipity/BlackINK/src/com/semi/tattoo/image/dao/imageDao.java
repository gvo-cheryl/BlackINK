package com.semi.tattoo.image.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.semi.tattoo.image.controller.visionController;
import com.semi.tattoo.image.dto.imageDto;
import com.semi.tattoo.mybatis.SqlMapConfig;
import com.semi.tattoo.tag.biz.tagBiz;
import com.semi.tattoo.tag.dto.tagDto;
import com.semi.tattoo.tattooshare.biz.tattooshareBiz;
import com.semi.tattoo.tattooshare.dao.tattooshareDao;
import com.semi.tattoo.tattooshare.dto.tattooshareDto;

public class imageDao extends SqlMapConfig{
	
	visionController vision = new visionController();
	String namespace = "com.semi.tattoo.image.";

	public List<imageDto> selectPathList(List<tattooshareDto> filenames){
		List<imageDto> filepath = new ArrayList<imageDto>();
		
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			filepath = session.selectList(namespace + "selectPathList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return filepath;
	}
	
	public int selectOne(imageDto dto){
		SqlSession session = null;
		int im_no = 0;
		List<imageDto> list = new ArrayList<imageDto>();
		list.add(dto);
		Map<String, List> map = new HashMap<String, List>();
		map.put("list", list);
		

		try {
			session = getSqlSessionFactory().openSession(false);
			im_no = session.selectOne(namespace+"selectOne", map);
			System.out.println("selectOne 호출");
			System.out.println("selectOne_im_no : "+im_no);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return im_no;
	}
	
	public List<imageDto> selectBeforeList(imageDto selectDto){
		SqlSession session = null;
		List<imageDto> im_before_list = new ArrayList<imageDto>();
		

		try {
			session = getSqlSessionFactory().openSession(false);
			im_before_list = session.selectList(namespace+"selectBeforeList", selectDto);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return im_before_list;
	}

	public List<imageDto> insertImage(List<imageDto> filelist) {
		// 파라미터: filename, filepath 가 dto에 담긴 filelist
		
		SqlSession session = null;
		int im_no = 0;
		List<imageDto> im_before_list = new ArrayList<imageDto>();
		
		Map<String, List> map = new HashMap<String, List>();
		map.put("list", filelist);
		
		//System.out.println(map.get("list").get(0).toString());

		tattooshareBiz ts_biz = new tattooshareBiz();
		
		List<tattooshareDto> ts_list = new ArrayList<tattooshareDto>();
		
		String [] im_servername_list = new String[filelist.size()];
		imageDto selectDto = new imageDto();

		System.out.println("imageDao: "+filelist.get(0).getIm_filepath());
		
		try {
			session = getSqlSessionFactory().openSession(false);
			session.insert(namespace + "insertImageList", map);
			session.commit();
			System.out.println("insert 완료");
			
			for(int i=0; i<filelist.size(); i++) {
				System.out.println(filelist.get(i).getIm_servername());
				im_servername_list[i] = filelist.get(i).getIm_servername();
				//System.out.println(im_servername_list[i]);
			}
			selectDto.setIm_servername_list(im_servername_list);
			selectDto.setMe_no(filelist.get(0).getMe_no());
			
			//tattooshare 테이블에 담을 값 불러오기
			im_before_list = selectBeforeList(selectDto);
			System.out.println("selectBeforeList 완료");
			//System.out.println(im_before_list.get(0).getIm_no());
			
			
			for(imageDto dto: im_before_list) {
				
				tattooshareDto ts_dto = new tattooshareDto();
				ts_dto.setIm_no(dto.getIm_no());
				ts_dto.setMe_no(dto.getMe_no());
				ts_dto.setTs_writer(dto.getMe_nic());
				ts_list.add(ts_dto);
				
				System.out.println(ts_dto.getIm_no());
				
//				ts_list.get(i).setIm_no(im_before_list.get(i).getIm_no());
//				ts_list.get(i).setMe_no(im_before_list.get(i).getMe_no());
//				ts_list.get(i).setTs_writer(im_before_list.get(i).getMe_nic());
			}
			
			
			ts_biz.insertTsList(ts_list);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return im_before_list;
	}
	
	public List<imageDto> selectSamplelist(int me_no){
		SqlSession session = null;
		List<imageDto> list = new ArrayList<imageDto>();
		
		try {
			session = getSqlSessionFactory().openSession(true);
			list = session.selectList(namespace+"selectSamplelist", me_no);
			System.out.println("sampleList sql 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}
	
	public int deleteImage(String[] im_no_list) {

		SqlSession session = null;
		int res = 0;
		
		imageDto dto = new imageDto();
		dto.setIm_no_list(im_no_list);
		//타투쉐어 삭제 
		tattooshareBiz biz = new tattooshareBiz();
		int ts_res = biz.deleteTsList(im_no_list);
		
		//tag삭제
		tagBiz ts_biz = new tagBiz();
		int t_res = 0;
		
		try {
			if(ts_res>0) {
				t_res = ts_biz.deleteTagList(im_no_list);
				if(t_res>0) {
					session = getSqlSessionFactory().openSession(true);
					res = session.delete(namespace+"deleteImage", dto);
					System.out.println("delete 성공");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return res;
	}
	
	public imageDto selectOneImageDetail(int im_no) {
		SqlSession session = null;
		imageDto dto = new imageDto();
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace+"selectOneImageDetail", im_no);
			System.out.println("image 불러오기 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}
	
}













