package com.newlecture.web.controller.admin.notice;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.newlecture.web.entity.*;
import com.newlecture.web.service.*;

@MultipartConfig(
		fileSizeThreshold=1024*1024,
		maxFileSize=1024*1024*50,
		maxRequestSize=1024*1024*50*5)
@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp");
		dis.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String isOpen = request.getParameter("open");
		
		Part filePart = request.getPart("file");
		filePart.getInputStream();
		
		//"/uploard/
		
		String realPath = request.getServletContext().getRealPath("/upload");
		
		boolean pub = false;
		if(isOpen != null) {
			pub = true;
		}
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setPub(pub);
		notice.setWriterId("newlec");
		
		NoticeService service = new NoticeService();
		service.insertNotice(notice);
		
		response.sendRedirect("list");
	}
}
