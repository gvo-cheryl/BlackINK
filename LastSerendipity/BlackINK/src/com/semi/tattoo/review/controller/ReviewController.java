package com.semi.tattoo.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.tattoo.notice.dto.NoticeDto;
import com.semi.tattoo.review.biz.ReviewBiz;
import com.semi.tattoo.review.dto.ReviewDto;

@WebServlet("/ReviewController.do")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReviewController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println(command + " command 를 실행했습니다.");
		
		ReviewBiz biz = new ReviewBiz();
		MultipartRequest multi = null;	// 업로드를 위한 변수
		int sizeLimit = 10 * 1024 * 1024; // 업로드 될 파일의 크기 제한, 10mb임
		
		if(("review").equals(command)) {
			int curPage = Integer.parseInt(request.getParameter("curPage")); // 현재 페이지
			int totalCount = biz.getCount(); // 전체 게시물 수
			System.out.println("값은 : " + totalCount);
			int countPage = 10; // 한 페이지에 보여질 게시물 수
			
			int startCount = (curPage - 1)* countPage + 1;
			int endCount = curPage * countPage;
			List<ReviewDto> list = biz.selectPage(startCount, endCount);
			
			request.setAttribute("curPage", curPage);
			request.setAttribute("list", list);
			request.setAttribute("totalCount", totalCount);
			
			dispatch("review.jsp",request, response);
			
		} else if(("selectOne").equals(command)) {
			int no = Integer.parseInt(request.getParameter("no"));
			biz.viewCount(no);
			ReviewDto dto = biz.selectOne(no);
			request.setAttribute("dto", dto);
			dispatch("reviewSelectOne.jsp",request, response);
		} else if(("update").equals(command)) {
			int no = Integer.parseInt(request.getParameter("no"));
			ReviewDto dto = biz.selectOne(no);
			request.setAttribute("dto", dto);
			dispatch("reviewUpdate.jsp",request, response);
		} else if(("updateform").equals(command)) {

			int no = Integer.parseInt(request.getParameter("no"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			
			ReviewDto dto = new ReviewDto(no, title, content);
			int res = biz.update(dto);
			if(res > 0) {
				 response.sendRedirect("ReviewController.do?command=review&curPage=1");
			} else {
				jsResponse("에러 발생","main.jsp",response);
			}
		} else if(("delete").equals(command)) {
			String name = request.getParameter("name");
			String writer = request.getParameter("writer");
			System.out.println(name + "랑" + writer);
			if(name.equals(writer) ? false : true) {
				jsResponse("작성자가 아닙니다.","ReviewController.do?command=review&curPage=1",response);
			} else {

				int no = Integer.parseInt(request.getParameter("no"));
				int res = biz.delete(no);
				if(res > 0) {
					 response.sendRedirect("ReviewController.do?command=review&curPage=1");
				} else {
					jsResponse("에러 발생","main.jsp",response);
				}
				
			}
		} else if(("insert").equals(command)) {
			dispatch("reviewInsert.jsp",request,response);
		} else if(("insertform").equals(command)) {
			
			
			String savePath = request.getRealPath("/upload"); // 저장 될 경로명 변수
			System.out.println(savePath);
			
			multi = new MultipartRequest(request, savePath, sizeLimit, "euc-kr", new DefaultFileRenamePolicy());
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String filename = multi.getParameter("filename");
			
			ReviewDto dto = new ReviewDto(title, content);
			int res = biz.insert(dto);
			System.out.println("컨트롤러에서 나온 res값 : " + res);
			if(res > 0) {
				 response.sendRedirect("ReviewController.do?command=review&curPage=1");
			} else {
				jsResponse("에러 발생","main.jsp",response);
			}
		}
	}

	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch=  request.getRequestDispatcher(path);	
		dispatch.forward(request,response);
	}
	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String result = "<script> alert ('" + msg + "'); location.href=\"" + url + "\"; </script>";
		response.getWriter().append(result);
	}	
}