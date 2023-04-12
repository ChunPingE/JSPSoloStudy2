package com.newlecture.web.controller.admin.notice;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.newlecture.web.entity.*;
import com.newlecture.web.service.*;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50 * 5)
@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp");
		dis.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String isOpen = request.getParameter("open");

		Collection<Part> parts = request.getParts();
		StringBuilder builder = new StringBuilder();
		for (Part p : parts) {
			if (!p.getName().equals("file")) {
				continue;
			}
			if (p.getSize() == 0) {
				continue;
			}
			Part filePart = p;
			InputStream fis = filePart.getInputStream();

			String fileName = filePart.getSubmittedFileName();
			String realPath = request.getServletContext().getRealPath("/upload");
			String filePath = realPath + File.separator + fileName;

			File path = new File(realPath);
			if (!path.exists()) {
				path.mkdirs();
			}

			builder.append(fileName);
			builder.append(",");

			FileOutputStream fos = new FileOutputStream(filePath);

			byte[] data = new byte[1024];
			while (true) {
				int size = fis.read(data);
				if (size == -1) {
					break;
				}
				fos.write(data, 0, size);
			}
			fos.flush();

			fos.close();
			fis.close();
		}

		builder.delete(builder.length() - 1, builder.length());

		boolean pub = false;
		if (isOpen != null) {
			pub = true;
		}

		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setPub(pub);
		notice.setWriterId("newlec");
		notice.setFiles(builder.toString());

		NoticeService service = new NoticeService();
		service.insertNotice(notice);

		response.sendRedirect("list");
	}
}
