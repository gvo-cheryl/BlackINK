package com.semi.tattoo.design.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;
import com.semi.tattoo.design.biz.DesignBiz;
import com.semi.tattoo.design.dto.DesignDto;


@WebServlet("/design")
public class DesignController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DesignController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}
	
	private void dispatch(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {

		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);

	}
	
	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {

		String result = " <script> alert('" + msg + "'); location.href='" + url + "'; </script> ";
		response.getWriter().append(result);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();		
		int me_no = Integer.parseInt(session.getAttribute("me_no").toString());
		
		//이미지업로드에 필요한 변수들
		String filepath = "";
		int maxSize = 1024 * 1024 * 5;
		String savefile = "img";
		ServletContext scontext = getServletContext();
		filepath = scontext.getRealPath(savefile);
		String newfileName = "";

		DesignBiz im_biz = new DesignBiz();
		
		MultipartParser parser = new MultipartParser(request, maxSize);
		parser.setEncoding("UTF-8");
			
		Part part = null;
			
		int cnt = 1;
			
		while((part = parser.readNextPart())!=null) {
			
			String name = part.getName();
			File dir = new File(filepath);
			
			if(part.isFile()) {						
				
				FilePart fPart = (FilePart) part;
				String filename = fPart.getFileName();
				System.out.println("filename: "+filename);
				
				if(filename != null) {
					
//					filename = new String(filename.getBytes(), encType);
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
					// System.out.println("oldfile : "+oldfile);
					// System.out.println("newfile : "+newfile);
					
					if(!oldfile.renameTo(newfile)) {//파일명 변경
						System.out.println("파일명 변경 실패");
					}
					
					DesignDto im_dto = new DesignDto();
					im_dto.setMe_no(me_no);
					im_dto.setCa_filename(filename);
					im_dto.setCa_servername(newfileName);
					im_dto.setCa_filepath(filepath);

					int res = im_biz.insert(im_dto);
					
				} else if(part.isParam()) {
					
					ParamPart paramPart = (ParamPart) part;
					String value = paramPart.getStringValue();
					if(name.equals("filename")) {
						filename = value;
					}

					
				}

				
				
			} 
			
		}

	}
}
