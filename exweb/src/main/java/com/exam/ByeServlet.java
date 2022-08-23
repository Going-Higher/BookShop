package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹애플리케이션서버(톰캣)을 통해서 실행되는 자바 클래스를 작성하기 위해서는 일반적으로 HttpServlet 클래스를 상속
//서블릿 클래스와 요청 주소를 연결하는 방법
//(1)web.xml 파일에 등록
//(2)@WebServlet을 클래스에 사용

//요청을 받았을 때 실행되는 서블릿으로 등록하고, "/bye.do" 주소로 요청이 오면 실행
@WebServlet("/bye.do")
public class ByeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ByeServlet 실행");
		
		//웹브라우저에서 http://localhost:8000/exweb/bye/do로 요청을 보내면,
		//브라우저 화면에 Bye Bye라고 출력되도록 구현
//		PrintWriter out = resp.getWriter();
//		out.println("Bye Bye");
		
		//큰제목으로 Bye Bye
		//작은 제목으로 안녕히를 출력
		
//		//출력스트림을 가져오기 전에 응답객체의 문자인코딩 설정
//		resp.setCharacterEncoding("UTF-8");
//		//응답내용이 HTML 문서 텍스트임을 클라이언트에게 알려줌
//		resp.setContentType("text/html");
//		//응답내용의 문자인코딩과 문서형식을 동시에 설정 가능
		resp.setContentType("text/html;charset=UTF-8");
		//응답객체에 응답내용을 쓸 수 있는 출력스트림 가져오기
		PrintWriter out = resp.getWriter();
		//응답객체에 출력한 내용이 클라이언트(웹브라우저)에게 전송된다
		//out.println("Hello Servlet!");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>Bye Bye<h1>");
		out.println("	<h2>안녕히 가세요<h2>");
		out.println("</body>");
		out.println("</html>");
	}
}


