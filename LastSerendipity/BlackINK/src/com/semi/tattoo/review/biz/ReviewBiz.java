package com.semi.tattoo.review.biz;

import java.util.List;

import com.semi.tattoo.notice.dto.NoticeDto;
import com.semi.tattoo.review.dao.ReviewDao;
import com.semi.tattoo.review.dto.ReviewDto;



public class ReviewBiz {

	ReviewDao dao = new ReviewDao();
		
		public List<ReviewDto> selectList(){
			return dao.selectList();
		}
		public List<ReviewDto> selectPage(int startCount, int endCount){
			return dao.selectPage(startCount, endCount);
		}
		
		
		public ReviewDto selectOne(int no) {
			return dao.selectOne(no);
		}
		
		public int insert (ReviewDto dto) {
			return dao.insert(dto);
		}
		
		public int update (ReviewDto dto) {
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
