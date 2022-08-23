package com.exam.comm;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//필터 : 다수의 서블릿의 실행 전후에 공통적으로 수행해야 하는 작업을 구현
//필터를 등록하는 방법
// - web.xml 에 <filter>를 사용하여 등록
// - 필터 클래스에 @WebFilter를 적용하여 등록
public class MyFilter implements Filter {

	private String cs;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 필터 객체가 처음 생성된 후, 1회만 실행 : 보통 필터 초기화 작업 구현
		System.out.println("MyFilter : init");
		cs = filterConfig.getInitParameter("enc");
	}
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 필터와 연결된 주소로 요청이 올때마다 1번씩 반복적으로 실행
		System.out.println("MyFilter : 서블릿 실행 전");
		
		request.setCharacterEncoding(cs);
		
		chain.doFilter(request, response); //이후 실행될 다른 필터 또는 서블릿을 실행
		
		System.out.println("MyFilter : 서블릿 실행 후");
		
	}

	@Override
	public void destroy() {
		// 필터 객체가 소멸되기 전에 1회만 실행 : 보통 필터가 사용하던 자원을 정리하고 반납하는 작업 구현
		System.out.println("MyFilter : destroy");
	}

}
