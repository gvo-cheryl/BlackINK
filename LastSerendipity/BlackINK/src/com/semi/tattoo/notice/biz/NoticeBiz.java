package com.semi.tattoo.notice.biz;

import java.util.List;

import com.semi.tattoo.notice.dao.NoticeDao;
import com.semi.tattoo.notice.dto.NoticeDto;

public class NoticeBiz {

	NoticeDao dao = new NoticeDao();
	
	public List<NoticeDto> selectList(){
		return dao.selectList();
	}
	public List<NoticeDto> selectPage(int startCount, int endCount){
		return dao.selectPage(startCount, endCount);
	}
	
	public NoticeDto selectOne(int no) {
		return dao.selectOne(no);
	}
	
	public int insert (NoticeDto dto) {
		return dao.insert(dto);
	}
	
	public int update (NoticeDto dto) {
		return dao.update(dto);
	}
	
	public int delete (int no) {
		return dao.delete(no);
	}
	
	public int getCount() {
		return dao.getCount();
	}
	
	public int viewCount(int no) {
		return dao.viewCount(no);
	}
	
	
}
