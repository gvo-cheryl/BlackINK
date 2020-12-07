package com.semi.tattoo.qna.biz;

import java.util.List;

import com.semi.tattoo.notice.dto.NoticeDto;
import com.semi.tattoo.qna.dao.QnaDao;
import com.semi.tattoo.qna.dto.QnaDto;

public class QnaBiz {

   QnaDao dao = new QnaDao();
   
   public List<QnaDto> selectPage(int startCount, int endCount){
      return dao.selectPage(startCount, endCount);
   }

   public QnaDto selectOne(int no) {
	   System.out.println(no);
      return dao.selectOne(no);
   }
   
   public int insert (QnaDto dto) {
      return dao.insert(dto);
   }
   
   public int update (QnaDto dto) {
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
   public int answerProc(QnaDto dto) {
      int update = dao.updateAnswer(dto.getNo());
      int insert = dao.insertAnswer(dto);
      return update + insert;
   }
   public String selectMyrole(int me_no) {
	   return dao.selectMyrole(me_no);
   }
   

}