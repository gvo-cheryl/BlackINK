package com.semi.tattoo.profile.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import com.oreilly.servlet.multipart.Part;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.semi.tattoo.image.biz.imageBiz;
import com.semi.tattoo.image.controller.visionController;
import com.semi.tattoo.image.dto.imageDto;
import com.semi.tattoo.profile.biz.profileBiz;
import com.semi.tattoo.profile.dto.profileDto;
import com.semi.tattoo.tag.biz.tagBiz;
import com.semi.tattoo.tag.dto.tagDto;
import com.semi.tattoo.tattooshare.biz.tattooshareBiz;
import com.semi.tattoo.tattooshare.dto.tattooshareDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/profileController.do")
public class profileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String command = request.getParameter("command");
		System.out.println(command);
		
		if("detail".equals(command)) {
			int me_no = Integer.parseInt(request.getParameter("me_no"));
			System.out.println(me_no);
			profileBiz pr_biz= new profileBiz();
			profileDto dto = pr_biz.selectOne(me_no);
			
			imageBiz im_biz = new imageBiz();
			List<imageDto> list = im_biz.selectSamplelist(me_no);
			
//			for(imageDto img : list) {
//				System.out.println(img.getIm_no());
//				System.out.println(img.getIm_servername());
//			}
			
			request.setAttribute("dto", dto);
			request.setAttribute("list", list);
			dispatch("profileDetail.jsp", request, response);
		
		}else if("updateForm".equals(command)) {
			int me_no = Integer.parseInt(request.getParameter("me_no"));
			System.out.println("updateForm me_no: " + me_no);
			profileBiz pr_biz= new profileBiz();
			profileDto dto = pr_biz.selectOne(me_no);
			
			request.setAttribute("dto", dto);
			dispatch("profile.jsp", request, response);
		
		} else if("muldel".equals(command)) {	
			String[] chks = request.getParameterValues("chk");
			int me_no = Integer.parseInt(request.getParameter("me_no"));
			
			imageBiz biz = new imageBiz();
			int res = biz.deleteImage(chks);
			
			if(res>0) {
				jsResponse("삭제되었습니다.", "profileController.do?command=detail&me_no="+me_no, response);
			} else {
				
			}
		
		} else if("imageDetail".equals(command)) {	
			int me_no = Integer.parseInt(request.getParameter("me_no"));
			int im_no = Integer.parseInt(request.getParameter("im_no"));
			System.out.println("meno: " + me_no + " im_no: " + im_no); 
			//tattooshare 호출 
			tattooshareBiz ts_biz = new tattooshareBiz();
			tattooshareDto ts_dto = ts_biz.selectOne(im_no);
			
			//tag 호출 
			tagBiz t_biz = new tagBiz();
			List<tagDto> list = t_biz.selectList(im_no);

			
			request.setAttribute("dto", ts_dto);
			request.setAttribute("list", list);
			
			dispatch("imageDetail.jsp", request, response);
			
		} else if("imageDetail_Ts".equals(command)) {
			int me_no = Integer.parseInt(request.getParameter("me_no"));
			int im_no = Integer.parseInt(request.getParameter("im_no"));
			System.out.println("meno: " + me_no + " im_no: " + im_no); 
			//tattooshare 호출 
			tattooshareBiz ts_biz = new tattooshareBiz();
			tattooshareDto ts_dto = ts_biz.selectOne(im_no);
			
			//tag 호출 
			tagBiz t_biz = new tagBiz();
			List<tagDto> list = t_biz.selectList(im_no);

			
			request.setAttribute("dto", ts_dto);
			request.setAttribute("list", list);
			
			dispatch("imageDetail_Ts.jsp", request, response);
		} else if("goProfile".equals(command)) {
			int me_no = Integer.parseInt(request.getParameter("me_no"));
			System.out.println(me_no);
			profileBiz pr_biz= new profileBiz();
			profileDto dto = pr_biz.selectOne(me_no);
			
			imageBiz im_biz = new imageBiz();
			List<imageDto> list = im_biz.selectSamplelist(me_no);
			
			
//			for(imageDto img : list) {
//				System.out.println(img.getIm_no());
//				System.out.println(img.getIm_servername());
//			}
			
			request.setAttribute("dto", dto);
			request.setAttribute("list", list);
			dispatch("profileDetail_Ts.jsp", request, response);
			
		} else {
			
			//이미지업로드에 필요한 변수들
			String filepath = "";
			int maxSize = 1024 * 1024 * 5;
			String encType = "utf-8";
			String savefile = "img";
			ServletContext scontext = getServletContext();
			filepath = scontext.getRealPath(savefile);
			String newfileName = "";
			
			//값 담을 dto 선언
			List<imageDto> filelist = new ArrayList<imageDto>();
			imageBiz im_biz = new imageBiz();
			
			//profileDto 선언
			profileBiz pr_biz = new profileBiz();
			profileDto pr_dto = new profileDto();
			
			// form 담을 변수 선언 
			String shopname = null;
			String open = null;
			String close = null;
			String post = null;
			String adr_main = null;
			String adr_d1 = null;
			String adr_d2 = null;
			String content = null;
			int me_no = 0;
			
			try {
				
//				MultipartRequest multi = new MultipartRequest(request, request.getParameter("open"));
//				String open = multi.getParameter("open");
//				System.out.println(open);
				
				MultipartParser parser = new MultipartParser(request, maxSize);
				parser.setEncoding("UTF-8");
				
				Part part = null;
				
				int cnt = 1;
				while((part = parser.readNextPart())!=null) {
					String name = part.getName();
					File dir = new File(filepath);
				
					if(part.isParam()) {
						ParamPart paramPart = (ParamPart) part;
						
						String value = paramPart.getStringValue();
						//System.out.println(value);
						if(name.equals("shopname")) {
							shopname = value;
						} else if(name.equals("open")) {
							open = value;
							//.out.println(open);
						} else if(name.equals("close")) {
							close = value;
							//System.out.println(close);
						} else if(name.equals("zipNo")) {
							post = value;
						} else if(name.equals("roadAddrPart1")) {
							adr_main = value;
						} else if(name.equals("addrDetail")) {
							adr_d1 = value;
						} else if(name.equals("roadAddrPart2")){
							adr_d2 = value;
						} else if(name.equals("intro")) {
							content = value;
							//System.out.println(intro);
						} else if(name.equals("me_no")) {
							me_no = Integer.parseInt(value);
							System.out.println("controller me_no: " + me_no);
						}
					
					} else if(part.isFile()) {						
							FilePart fPart = (FilePart) part;
							String filename = fPart.getFileName();
							System.out.println("filename: "+filename);
							
							if(filename !=null) {
								
	//							filename = new String(filename.getBytes(), encType);
								long size = fPart.writeTo(dir);
								
								//이미지파일에 사용할 현재날짜
								Date today = new Date();
								SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
								SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
								newfileName = date.format(today) + " " +time.format(today);
								int i = -1;
								
								if((i = filename.lastIndexOf(".")) != -1){//파일 확장자 위치 
									newfileName = newfileName + "(" + cnt + ")" + filename.substring(i, filename.length());// 현재 시간과 확장자
								}
								File oldfile = new File(filepath+ "/" + filename);
								File newfile = new File(filepath+ "/" + newfileName);
								//System.out.println("oldfile : "+oldfile);
								System.out.println("newfile : "+newfile);
								if(!oldfile.renameTo(newfile)) {//파일명 변경
									System.out.println("파일명 변경 실패");
								}
								imageDto im_dto = new imageDto();
								im_dto.setMe_no(me_no);
								im_dto.setIm_filename(filename);
								im_dto.setIm_servername(newfileName);
								im_dto.setIm_filepath(filepath);
								filelist.add(im_dto);
								cnt++;
								
							} 
							
							
						}	
				}
				
				pr_dto.setMe_no(me_no);
				pr_dto.setPr_shopname(shopname);
				pr_dto.setPr_open(open);
				pr_dto.setPr_close(close);
				pr_dto.setPr_post(post);
				pr_dto.setPr_adr_main(adr_main);
				pr_dto.setPr_adr_d1(adr_d1);
				pr_dto.setPr_adr_d2(adr_d2);
				pr_dto.setPr_content(content);
				
				pr_biz.profileUpdate(pr_dto);
				
				for(imageDto dto : filelist) {
					System.out.println("controller for문: "+dto.getIm_servername());
				}
				
				//image테이블에 추가
				if(!filelist.isEmpty()) {
					List<imageDto> image_list = im_biz.insertImage(filelist);
					for(imageDto dto : image_list) {
						System.out.println("profileController im_no: "+dto.getIm_no());	
						// vision 호출
						String fullPath = dto.getIm_filepath() + "/" + dto.getIm_servername();
						List<String> labelList = visionController.labelImage(fullPath);
						String textTag = visionController.detectText(fullPath); 
						//System.out.println(textTag);
						
						List<tagDto> tagList = new ArrayList<tagDto>();
						tagBiz tagbiz = new tagBiz();
						
						for(String label : labelList) {
							tagDto tagDto = new tagDto();
							tagDto.setIm_no(dto.getIm_no());
							tagDto.setTa_labeltag(label);
							tagDto.setTa_texttag(textTag);
							tagList.add(tagDto);	
		//					System.out.println("tagDto_im_no : " +tagDto.getIm_no());
		//					System.out.println("tagDto_ta_label : " +tagDto.getTa_labeltag());
		//					System.out.println("tagDto_ta_text : " +tagDto.getTa_texttag());
							
						}
						tagbiz.insertTag(tagList);
					}
					tattooshareBiz tattooshare_biz = new tattooshareBiz();
				 	List<tattooshareDto> imgList = tattooshare_biz.tattooshareList();
				 	request.setAttribute("imgList", imgList);
					request.setAttribute("pr_dto", pr_dto);
				}
				dispatch("profileController.do?command=detail&me_no="+pr_dto.getMe_no(), request, response);
				
				

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String result = "<script> alert('" + msg + "'); location.href='" + url +  "'; </script>";
		response.getWriter().append(result);
	}
	
	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}

}




























