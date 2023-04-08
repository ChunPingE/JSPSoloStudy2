package com.newlecture.web.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.newlecture.web.db.*;
import com.newlecture.web.entity.*;

@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		NoticeDAO ndao = new NoticeDAO();
		List<Notice> list = ndao.getAllList();
		request.setAttribute("notice", list);

		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp");
		dis.forward(request, response);
	}
}
