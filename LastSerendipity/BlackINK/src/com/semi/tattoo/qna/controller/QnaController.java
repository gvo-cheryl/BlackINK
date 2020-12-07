package com.semi.tattoo.qna.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.tattoo.notice.dto.NoticeDto;
import com.semi.tattoo.qna.biz.QnaBiz;
import com.semi.tattoo.qna.dao.QnaDao;
import com.semi.tattoo.qna.dto.QnaDto;
import com.semi.tattoo.review.dto.ReviewDto;

@WebServlet("/QnaController.do")
public class QnaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QnaController() {
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

		String command = request.getParameter("command");
		System.out.println(command + " command를 실행했습니다.");

		HttpSession session = request.getSession();
		
		if(session.getAttribute("me_no")==null || session.getAttribute("me_no").equals("")) {
			jsResponse("로그인이 필요합니다.", "login.jsp", response);
		} else {
			int me_no = Integer.parseInt(session.getAttribute("me_no").toString());

			QnaBiz biz = new QnaBiz();
			QnaDao dao = new QnaDao();

			String me_role = biz.selectMyrole(me_no);
			System.out.println(me_role);

			if (("qna").equals(command)) {
				int curPage = Integer.parseInt(request.getParameter("curPage"));
				int totalCount = biz.getCount(); // 전체 게시물 수
				System.out.println("totalCount는 : " + totalCount);
				int countPage = 10; // 한 페이지에 보여질 게시물 수

				int startCount = (curPage - 1) * countPage + 1;
				int endCount = curPage * countPage;
				List<QnaDto> list = biz.selectPage(startCount, endCount);

				request.setAttribute("curPage", curPage);
				request.setAttribute("list", list);
				request.setAttribute("totalCount", totalCount);

				dispatch("qna.jsp", request, response);

			} else if (("selectOne").equals(command)) {

				int no = Integer.parseInt(request.getParameter("no"));
				System.out.println(no);
				biz.viewCount(no);
				QnaDto dto = biz.selectOne(no);
				System.out.println(dto.getCategory());
				request.setAttribute("dto", dto);
				request.setAttribute("role", me_role);
				dispatch("qnaSelectOne.jsp", request, response);

			} else if (("reply").equals(command)) {

				int parentno = Integer.parseInt(request.getParameter("parentno"));
				QnaDto dto = biz.selectOne(parentno);
				request.setAttribute("dto", dto);
				dispatch("qnaReply.jsp", request, response);

			} else if (("replyres").equals(command)) {

				int no = Integer.parseInt(request.getParameter("no"));
				String title = request.getParameter("title");
				String writer = request.getParameter("writer");
				String content = request.getParameter("content");
				String category = "답변";
				QnaDto dto = new QnaDto(no, title, writer, content, me_no);
				int res = biz.answerProc(dto);
				if (res > 0) {
					response.sendRedirect("QnaController.do?command=qna&curPage=1");
				} else {
					jsResponse("입력 에러", "QnaController.do?command=qna&curPage=1", response);
				}

			} else if (("insert").equals(command)) {

				response.sendRedirect("qnaInsert.jsp");

			} else if (("insertres").equals(command)) {
				String content = request.getParameter("content");
				String title = request.getParameter("title");
				System.out.println(content + title);

				QnaDto dto = new QnaDto(title, content);

				int res = biz.insert(dto);
				if (res > 0) {
					response.sendRedirect("QnaController.do?command=qna&curPage=1");
				} else {
					jsResponse("입력 에러", "QnaController.do?command=qna&curPage=1", response);

				}
			} else if (("update").equals(command)) {
				int writerno = Integer.parseInt(request.getParameter("writerno"));
				int no = Integer.parseInt(request.getParameter("no"));
				if (writerno != me_no) {
					jsResponse("작성자가 아닙니다.", "QnaController.do?command=qna&curPage=1", response);
				}

				QnaDto dto = biz.selectOne(no);
				request.setAttribute("dto", dto);
				dispatch("qnaUpdate.jsp", request, response);

			} else if (("updateform").equals(command)) {
				int no = Integer.parseInt(request.getParameter("no"));
				String title = request.getParameter("title");
				String content = request.getParameter("content");

				QnaDto dto = new QnaDto(no, title, content);
				int res = biz.update(dto);
				if (res > 0) {
					response.sendRedirect("QnaController.do?command=qna&curPage=1");
				} else {
					jsResponse("에러 발생", "QnaController.do?command=qna&curPage=1", response);
				}

			} else if (("delete").equals(command)) {
				int writerno = Integer.parseInt(request.getParameter("writerno"));
				System.out.println(writerno + "랑" + me_no);
				if (writerno != me_no) {
					jsResponse("작성자가 아닙니다.", "QnaController.do?command=qna&curPage=1", response);
				} else {
					int no = Integer.parseInt(request.getParameter("no"));
					int res = biz.delete(no);
					if (res > 0) {
						response.sendRedirect("QnaController.do?command=qna&curPage=1");
					} else {
						jsResponse("에러 발생", "main.jsp", response);
					}
				}
			} else if (("deleteA").equals(command)) {
				int writerno = Integer.parseInt(request.getParameter("writerno"));
				System.out.println(writerno + "랑" + me_no);
				if (writerno != me_no) {
					jsResponse("관리자가 아닙니다.", "QnaController.do?command=qna&curPage=1", response);
				} else {
					int no = Integer.parseInt(request.getParameter("no"));
					int res = biz.delete(no);
					if (res > 0) {
						response.sendRedirect("QnaController.do?command=qna&curPage=1");
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