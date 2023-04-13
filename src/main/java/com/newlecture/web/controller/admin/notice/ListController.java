package com.newlecture.web.controller.admin.notice;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.newlecture.web.entity.*;
import com.newlecture.web.service.*;

@WebServlet("/admin/board/notice/list")
public class ListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p");

		String field = "title";
		if (field_ != null && !field_.equals("")) {
			field = field_;
		}

		String query = "";
		if (query_ != null && !query_.equals("")) {
			query = query_;
		}

		int page = 1;
		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}

		NoticeService service = new NoticeService();
		List<NoticeView> list = service.getNoticeViewList(field, query, page);

		int count = service.getNoticeCount(field, query);

		request.setAttribute("notice", list);
		request.setAttribute("count", count);

		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp");
		dis.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] openIds = request.getParameterValues("open-id");
		String[] delIds = request.getParameterValues("del-id");
		String cmd = request.getParameter("cmd");
		String ids_ = request.getParameter("ids");
		String[] ids = ids_.split(" ");
		
		NoticeService service = new NoticeService();
		
		switch (cmd) {
		case "일괄공개":
			List<String> oids = Arrays.asList(openIds);
			List<String> cids = new ArrayList(Arrays.asList(ids));
			cids.removeAll(oids);
			
			//Transaction
			//service.pubNoitceList(openIds); //update notice set pub = 1 where id in(..);
			//service.closeNoticeList(clsIds); //update notice set pub = 0 where id in(..);
			
			service.pubNoitceAll(oids, cids);
			
			break;
		case "일괄삭제":
			int[] ids1 = new int[delIds.length];
			for (int i = 0; i < delIds.length; i++) {
				ids1[i] = Integer.parseInt(delIds[i]);
			}
			int result = service.deleteNoticeAll(ids1);
			break;
		}response.sendRedirect("list");
}}
