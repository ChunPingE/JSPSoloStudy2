package com.newlecture.web;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/spag")
public class Spag extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = 0;

		String num_ = request.getParameter("n");
		if (num_ != null && !num_.equals("")) {
			num = Integer.parseInt(num_);
		}

		String result = "";

		if (num % 2 != 0) {
			result = "홀수";
		} else {
			result = "짝수";
		}

		request.setAttribute("result", result);
		RequestDispatcher dis = request.getRequestDispatcher("spag.jsp");
		dis.forward(request, response);
	}
}
