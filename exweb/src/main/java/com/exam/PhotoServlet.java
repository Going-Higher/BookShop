//http://localhost:8000/exweb/photo.do?img=동물이름
//	동물이름이 "bear"이면
//		화면에 https://picsum.photos/id/1020/200/300 이미지 출력
//	동물이름이 "eagle"이면
//		화면에 https://picsum.photos/id/1024/200/300 이미지 출력
//	동물이름이 "dog"이면
//		화면에 https://picsum.photos/id/1025/200/300 이미지 출력
//	그 밖에 다른 이름이면,
//		"알 수 없는 동물입니다."라고 출력

package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/photo.do")
public class PhotoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String s = req.getParameter("img");
										
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
		
		if (s.equals("bear")) out.println("	<img src='https://picsum.photos/id/1020/200/300' />");
		else if (s.equals("eagle")) out.println("	<img src='https://picsum.photos/id/1024/200/300' />");
		else if (s.equals("dog")) out.println("	<img src='https://picsum.photos/id/1025/200/300' />");
		else out.println("	<h1>알 수 없는 동물입니다.</h1>");		
		
		out.println("</body>");
		out.println("</html>");		
	}
}