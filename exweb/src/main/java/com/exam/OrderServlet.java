package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order.do")
public class OrderServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String uname = req.getParameter("user");
		
		String[] foods = req.getParameterValues("ord");
										
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
		out.println("<ul>");
		
		int foodCount = 0;
		if(foods != null) {
			foodCount = foods.length;
			for (int i = 0; i < foods.length; i++) {
				switch (foods[i]) {
				case "p001" :
					out.println("<li>피자</li>");
					break;
				case "p002" :
					out.println("<li>햄버거</li>");
					break;
				case "p003" :
					out.println("<li>돈까스</li>");
					break;
				case "p101" :
					out.println("<li>딸기쥬스</li>");
					break;
				case "p102" :
					out.println("<li>키위쥬스</li>");
					break;			
				}				
			}
		}		
		out.println("</ul>");
		out.println("<h1>" + uname + "님은 총 " + foodCount + "개의 음식을 주문했습니다." + "</h1>");
				
		out.println("</body>");
		out.println("</html>");		
	}
}