package com.exam.comm;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//(이벤트)리스너
//웹 애플리케이션에 특정 사건이 발생했을 때 자동으로 실행되는 클래스
//- ServletContextListener, ServletAttributeListener
//- SessionListener, SessionAttributeListener
//- RequestListener, RequestAttributeListener
//- 기타 등등

//ServletContextListener
//== ServletContext 객체의 생성과 소멸시에 자동 실행
//== 웹 애플리케이션이 처음 실행될 때와 종료될 때 자동 실행

//리스너를 등록하는 방법
//- web.xml 에 <listener> 를 사용하여 등록
//- 리스너 클래스에 @WebListener 를 적용하여 등록

public class MyListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 웹 애플리케이션이 처음 시작될 때 실행
		System.out.println("MyListener : contextInitialized");	
		
		ServletContext sc = sce.getServletContext();
		String jd = sc.getInitParameter("jdbcDriver");
		
		try {
			Class.forName(jd); //"oracle.jdbc.OracleDriver"
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 웹 애플리케이션이 종료될 때 실행
		System.out.println("MyListener: contextDestroyed");
		
	}


}
