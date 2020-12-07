package com.semi.tattoo.notice.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;
import com.oreilly.servlet.multipart.Part;
import com.semi.tattoo.notice.biz.NoticeBiz;
import com.semi.tattoo.notice.dao.NoticeDao;
import com.semi.tattoo.notice.dto.NoticeDto;

@WebServlet("/NoticeController.do")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String path = request.getServletContext().getRealPath("img");
		// 파일이 저장될 경로, request.getServletContext().getRealPath();는 Document_root
		int maxsize = 1024 * 1024 * 100;
		// 업로드 허용 용량

		// MultipartRequest multi = new
		// MultipartRequest(request,path,maxsize,"UTF-8",new DefaultFileRenamePolicy());
		// 파일 업로드 객체

		String command = request.getParameter("command");
		System.out.println(command + " command를 실행했습니다.");
		HttpSession session = request.getSession();

		NoticeBiz biz = new NoticeBiz();
		NoticeDao dao = new NoticeDao();

		if (session.getAttribute("me_no") == null || session.getAttribute("me_no").equals("")) {
			jsResponse("로그인이 필요합니다.", "login.jsp", response);
		} else {

			if (("notice").equals(command)) {
				System.out.println("inside notice command");
				System.out.println("curPage: " + request.getParameter("curPage"));
				int curPage = Integer.parseInt(request.getParameter("curPage")); // 현재 페이지
				int totalCount = biz.getCount(); // 전체 게시물 수
				int countPage = 10; // 한 페이지에 보여질 게시물 수

				int startCount = (curPage - 1) * countPage + 1;
				int endCount = curPage * countPage;
				List<NoticeDto> list = biz.selectPage(startCount, endCount);
				request.setAttribute("curPage", curPage);
				request.setAttribute("list", list);
				request.setAttribute("totalCount", totalCount);

				dispatch("notice.jsp", request, response);

			} else if (("insert").equals(command)) {
				dispatch("noticeInsert.jsp", request, response);

			} else if (("insertform").equals(command)) {
				String title = request.getParameter("title");
				String writer = request.getParameter("writer");
				String content = request.getParameter("content");

				NoticeDto dto = new NoticeDto(title, writer, content);
				int res = biz.insert(dto);
				System.out.println("컨트롤러에서 나온 res값 : " + res);
				if (res > 0) {
					response.sendRedirect("NoticeController.do?command=notice&curPage=1");
				} else {
					jsResponse("에러 발생", "main.jsp", response);
				}
			} else if (("selectOne").equals(command)) {
				int no = Integer.parseInt(request.getParameter("no"));
				int res = biz.viewCount(no);
				NoticeDto dto = new NoticeDto();
				dto = biz.selectOne(no);
				request.setAttribute("dto", dto);
				dispatch("noticeSelectOne.jsp", request, response);
			} else if (("update").equals(command)) {
				int no = Integer.parseInt(request.getParameter("no"));
				NoticeDto dto = new NoticeDto();
				dto = biz.selectOne(no);
				request.setAttribute("dto", dto);
				dispatch("noticeUpdate.jsp", request, response);
			} else if (("updateform").equals(command)) {
				int no = Integer.parseInt(request.getParameter("no"));
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				NoticeDto dto = new NoticeDto(no, title, content);
				int res = biz.update(dto);
				if (res > 0) {
					response.sendRedirect("NoticeController.do?command=notice&curPage=1");
				} else {
					jsResponse("에러 발생", "main.jsp", response);
				}
			} else if (("delete").equals(command)) {
				String role = (String) session.getAttribute("me_role");
				String A = "A";
				if (!role.equals(A)) {
					jsResponse("작성자가 아닙니다.", "NoticeController.do?command=notice&curPage=1", response);
				} else {
					int no = Integer.parseInt(request.getParameter("no"));
					int res = biz.delete(no);
					if (res > 0) {
						response.sendRedirect("NoticeController.do?command=notice&curPage=1");
					} else {
						jsResponse("에러 발생", "main.jsp", response);
					}
				}
			}
		}

	}

	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}

	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String result = "<script> alert ('" + msg + "'); location.href=\"" + url + "\"; </script>";
		response.getWriter().append(result);

	}

}