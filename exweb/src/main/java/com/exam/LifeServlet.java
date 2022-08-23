package com.exam;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿 클래스는 Servlet 인터페이스를 직접 구현하거나, Servlet 인터페이스를 구현해 놓은 HttpServlet 클래스를 상속하여 작성

//서블릿의 생명주기(Life cycle) : 서블릿 객체가 생성부터 소멸되기까지 자동으로 실행되는 메서드들

//톰캣은 서블릿 주소로 요청을 받으면, 실행할 서블릿 객체(인스턴스)가 존재하는지 찾아보고,
//객체가 존재하지 않으면 객체를 생성 후 init() service()를 실행
//객체가 존재하면 객체의 service()를 실행

public class LifeServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		//서블릿 객체가 처음 생성된 후 1회만 실행
		//보통 서블릿 작업을 실행
		System.out.println("LIfeServlet : init()!");
		
		//현재 서블릿의 설정정보 가져오기
		ServletConfig config = getServletConfig();
		System.out.println(config.getServletName());//서블릿 이름
		//web.xml에 <init-param>로 설정한 서블릿 초기화 파라미터 값 읽기
		//초기화파라미터를 사용하면, 자바 코드의 변경 및 재컴파일 없이 값 변경
		System.out.println(config.getInitParameter("id"));//서블릿 초기화 파라미터
	}		
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//서블릿의 주소와 일치하는 요청이 올 때마다 1번씩 실행
		System.out.println("LifeServlet : service()!");
	}		
	
	@Override
	public void destroy() {
		//서블릿 객체가 소멸하기 전에 1회만 실행
		//보통 서블릿에서 사용하던 자원을 반납하는 작업을 수행
		System.out.println("LifeServlet : destroy()!");
	}		
}

