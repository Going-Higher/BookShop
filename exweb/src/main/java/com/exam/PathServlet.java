package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿 주소(경로) 지정 방법
//경로는 반드시 / 또는 *. 로 시작
//@WebServlet("/abc/def/ghi")//경로를 파일명까지 정확하게 지정 
//@WebServlet("/abc/*")//특정 디렉토리(폴더) 아래의 모든 경로 지정
@WebServlet("*.action")//특정 확장자로 끝나는 모든 경로 지정
public class PathServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>PathServlet 실행!<h1>");
		out.println("</body>");
		out.println("</html>");
	}
}


