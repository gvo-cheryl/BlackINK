package com.semi.tattoo.tattooshare.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.tattoo.image.biz.imageBiz;
import com.semi.tattoo.image.dto.imageDto;
import com.semi.tattoo.tattooshare.biz.tattooshareBiz;
import com.semi.tattoo.tattooshare.dto.tattooshareDto;

@WebServlet("/tattooshareController.do")
public class tattooshareController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println(command);
		
		if("list".equals(command)) {
		 	tattooshareBiz tattooshare_biz = new tattooshareBiz();
		 	List<tattooshareDto> list = tattooshare_biz.tattooshareList();
//		 	for(tattooshareDto dto: list) {
//		 		System.out.println(dto.getIm_servername());
//		 	}
		 	request.setAttribute("list", list);

		 	dispatch("tatooShare.jsp", request, response);
		} else if("tsUpdate".equals(command)) {
			String me_no = request.getParameter("me_no");
			int im_no = Integer.parseInt(request.getParameter("im_no"));
			String title = request.getParameter("ts_title");
			String content = request.getParameter("ts_content");
			
			tattooshareBiz biz = new tattooshareBiz();
			tattooshareDto dto = new tattooshareDto();
			dto.setTs_title(title);
			dto.setTs_content(content);
			dto.setIm_no(im_no);
			
			int res = biz.update(dto);
			
			if(res>0) {
				jsResponse("수정되었습니다. ", "profileController.do?command=detail&me_no="+me_no+"&im_no="+im_no, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
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
