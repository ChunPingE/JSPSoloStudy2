<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% for (int i = 0 ; i< 10 ; i++) {%>
		안녕 Servlet!!<br >
	<%}%>
	
	<%    
		String cnt_ = request.getParameter("cnt");
		int cnt = 100;
		if (cnt_ != null && !cnt_.equals("")) {
		    cnt = Integer.parseInt(cnt_);
		}
		String[] result = new String[cnt];
		for (int i = 0 ; i< result.length ; i++) {
		    result[i] = "안녕 Servlet!!";
		}
	%> 
</body>
</html>