//웹브라우저에서 요청을 보낼 때, 추가적인 정보를 전송 가능
//요청주소?파라미터명=파라미터값&파라미터명=파라미터값&파라미터명=파라미터값
//http://localhost:8000/exweb/add.do?x=123&y=456로 요청을 보내면,
//123 + 456 = 579라고 출력되도록 서블릿을 구현

package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add.do")
public class AddServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String x1 = req.getParameter("x");
		String y1 = req.getParameter("y");
		int nx = Integer.parseInt( x1 );
		int ny = Integer.parseInt( y1 );
		
		String opv = req.getParameter("op");
			
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
		switch (opv) {
			case "p": 
				out.println("	<h1>" + x1 + " + " + y1 + " = " + (nx+ny));
				break;
			case "m":
				out.println("	<h1>" + x1 + " * " + y1 + " = " + (nx*ny));
				break;
		}		
		out.println("</body>");
		out.println("</html>");		
	}
}
