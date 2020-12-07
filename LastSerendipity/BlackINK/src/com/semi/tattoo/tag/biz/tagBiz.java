package com.semi.tattoo.tag.biz;

import java.util.List;

import com.semi.tattoo.image.dto.imageDto;
import com.semi.tattoo.tag.dao.tagDao;
import com.semi.tattoo.tag.dto.tagDto;

public class tagBiz {
	
	tagDao dao = new tagDao();
	
	public void insertTag(List<tagDto> tagList) {
		dao.insertTag(tagList);
	}

	public int deleteTagList(String[] im_no_list) {
		 return dao.deleteTagList(im_no_list);
	}
	
	public List<tagDto> selectList(int im_no){
		return dao.selectList(im_no);
	}
}
