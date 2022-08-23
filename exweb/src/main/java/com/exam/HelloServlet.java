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

public class HelloServlet extends HttpServlet {
	
	//현재 서블릿클래스에 맞는 요청이 올때마다 한번씩 실행
	//실행시키면서 요청객체와 응답객체를 인자로 전달
	//요청객체 : 클라이언트(웹브라우저)가 보낸 모든 정보를 담고 있다
	//응답객체 : 클라이언트에게 (응답으로)보낼 정보들을 저장할 수 있다
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet 실행!");
		
		//출력스트림을 가져오기 전에 응답객체의 문자인코딩 설정
		resp.setCharacterEncoding("UTF-8");
		//응답내용이 HTML 문서 텍스트임을 클라이언트에게 알려줌
		resp.setContentType("text/html");
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
		out.println("	<h1>Hello Servlet!<h1>");
		out.println("	<h2>안녕하세요!<h2>");
		out.println("</body>");
		out.println("</html>");
	}
}

