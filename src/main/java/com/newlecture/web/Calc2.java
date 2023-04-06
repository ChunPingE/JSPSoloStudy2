package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		Cookie[] cookies = request.getCookies();

		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");

		int v = 0;
		if (!v_.equals("")) {
			v = Integer.parseInt(v_);
		}

		if (op.equals("=")) {
			int x = 0;
			String operator = "";

			for (Cookie c : cookies) {
				if (c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}

			for (Cookie c : cookies) {
				if (c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}

			int result = 0;
			int y = v;

			if (operator.equals("+")) {
				result = x + y;
			} else if (operator.equals("-")) {
				result = x - y;
			}

			response.getWriter().printf("result is: %d", result);
		} else {
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);

			valueCookie.setPath("/calc2");
			// valueCookie.setMaxAge(60);
			opCookie.setPath("/calc2");

			response.addCookie(valueCookie);
			response.addCookie(opCookie);

			response.sendRedirect("calc2.html");
		}
	}
}
