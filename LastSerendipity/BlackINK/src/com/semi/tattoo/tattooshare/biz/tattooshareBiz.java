package com.semi.tattoo.tattooshare.biz;

import java.util.List;

import com.semi.tattoo.tag.dto.tagDto;
import com.semi.tattoo.tattooshare.dao.tattooshareDao;
import com.semi.tattoo.tattooshare.dto.tattooshareDto;
import com.google.cloud.translate.*;

public class tattooshareBiz {
	
	private tattooshareDao  dao = new tattooshareDao();
	
	public List<tattooshareDto> selectVisionList(List<tagDto> tagList){
		return dao.selectVisionList(tagList);
	}
	
	public List<tattooshareDto> selectTextsearchList(String[] chkArr){
		//검색어 번역 
		Translate translate = TranslateOptions.getDefaultInstance().getService();
		chkArr[chkArr.length-1] = translate.translate(chkArr[chkArr.length-1]).getTranslatedText().toString();
		for(int i=0; i<chkArr.length;i++) {
			String s = chkArr[i].toLowerCase();
			chkArr[i] = s;
			System.out.println(chkArr[i]);

		}
		//System.out.println(chkArr[chkArr.length-1]);
		
		return dao.selectTextsearchList(chkArr);
	}
	
	public List<tattooshareDto> tattooshareList(){
		return dao.tattooshareList();
	}
	
	public void insertTsList(List<tattooshareDto> list) {
		//null값인 경우 임의로 값 넣기 " "
		dao.insertTsList(list);
	}
	
	public int deleteTsList(String[] im_no_list) {
		return dao.deleteTsList(im_no_list);
	}

	public tattooshareDto selectOne(int im_no) {
		return dao.selectOne(im_no);
	}
	
	public int update(tattooshareDto dto) {
		return dao.update(dto);
	}
	
}
