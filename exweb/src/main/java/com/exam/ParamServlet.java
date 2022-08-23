//http://localhost:8000/exweb/param.do로 요청을 보내면,
//브라우저 화면에 큰 제목으로 파라미터 테스트라고 출력되도록 구현

package com.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹브라우저에서 요청을 보낼 때, 추가적인 정보를 전송 가능
//요청주소?파라미터명=파라미터값
//http://localhost:8000/exweb/param.do?a=123
//서블릿에서는 요청객체.getParameter("파라미터명") 명령으로 파라미터값을 읽어서 사용 가능

@WebServlet("/param.do")
public class ParamServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");//POST방식으로 전송되는 한글파라미터 인코딩
		String aval = req.getParameter("a");//파라미터의 값이 1개일때
		
		String[] bvals = req.getParameterValues("b");//파라미터의 값이 여러개일때
		
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
		out.println("	<h1>파라미터 테스트<h1>");
		out.println("	<h2>" + aval + "<h2>");
		
//		bvals 배열에 들어있는 모든 값들을 하나씩 꺼내서 모두 출력
		if (bvals != null) {//파라미터값이 1개 이상 존재하는 경우에만
			for (int i = 0; i < bvals.length; i++) {
				out.println("	<h2>" + bvals[i] + "<h2>");
			}
		}		
		
		out.println("</body>");
		out.println("</html>");
	}
}