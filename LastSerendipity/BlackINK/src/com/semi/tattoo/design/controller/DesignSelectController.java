package com.semi.tattoo.design.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.tattoo.design.biz.DesignBiz;
import com.semi.tattoo.design.dto.DesignDto;

@WebServlet("/designSelect")
public class DesignSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public DesignSelectController() {

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
		
		String command = request.getParameter("command");
		System.out.println("[" + command + "]");
		
		HttpSession session = request.getSession();
		DesignBiz biz = new DesignBiz();
		
		if("mydesign".equals(command)) {
			
			int me_no = Integer.parseInt(session.getAttribute("me_no").toString());
			
			List<DesignDto> list = new ArrayList<DesignDto>();
			
			list = biz.select(me_no);
			
			request.setAttribute("list", list);
			dispatch(request, response, "myDesign.jsp");
			
		} else if ("mydesigndelete".equals(command)) {
			
			int ca_no = Integer.parseInt(request.getParameter("ca_no"));
			
			int res = biz.delete(ca_no);
			
			if(res>0) {
				
				jsResponse("도안이 삭제되었습니다.", "mydesign.jsp", response);
				
			} else {
				
				jsResponse("도안 삭제가 실패하였습니다.", "mydesign.jsp", response);
				
			}
			
		} else if ("mydesigndetail".equals(command)) {
			
			int ca_no = Integer.parseInt(request.getParameter("ca_no"));
			
			DesignDto dto = new DesignDto();
			
			dto = biz.selectOne(ca_no);
			
			request.setAttribute("dto", dto);
			dispatch(request, response, "mydesigndetail.jsp");
			
		}
		
		
	}

}
