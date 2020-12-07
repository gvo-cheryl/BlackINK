package com.semi.tattoo.image.biz;

import java.util.List;
import java.util.Map;

import com.semi.tattoo.image.dao.imageDao;
import com.semi.tattoo.image.dto.imageDto;
import com.semi.tattoo.tattooshare.dto.tattooshareDto;

public class imageBiz {

	imageDao dao = new imageDao();

	public List<imageDto> selectPathList(List<tattooshareDto> filenames) {
		return dao.selectPathList(filenames);
	}
	
	public int selectOne(imageDto dto){
		return dao.selectOne(dto);
	}

	public List<imageDto> insertImage(List<imageDto> filelist) {
		return dao.insertImage(filelist);
	}
	
	public List<imageDto> selectSamplelist(int me_no){
		return dao.selectSamplelist(me_no);
	}
	
	public int deleteImage(String[] im_no_list) {
		return dao.deleteImage(im_no_list);
	}
	
	public imageDto selectOneImageDetail(int im_no) {
		return dao.selectOneImageDetail(im_no);
	}
}
