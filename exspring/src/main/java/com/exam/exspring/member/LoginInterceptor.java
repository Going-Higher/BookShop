package com.exam.exspring.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//핸들러인터셉터 : 다수의 컨트롤러 실행 전후에 공통적으로 수행해야 하는 작업을 처리
// - HandlerInterceptorAdapter 클래스를 상속하여 구현

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	//컨트롤러 실행 전에 실행되는 메서드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("LoginInterceptor : preHandle");
		
		HttpSession session = request.getSession();
		MemberVo vo = (MemberVo) session.getAttribute("loginUser");	//로그인한 사용자정보를 가져오기		
		if (vo == null) { //로그인한 적이 없다면
			response.sendRedirect(request.getContextPath() + "/member/login.do"); //다시 로그인 페이지로 이동	
			return false; //이후 핸들러(컨트롤러,인터셉터) 실행 금지
		}			
		
		//반환값은 이후 실행될 핸들러(컨트롤러,인터셉터)의 실행 여부를 결정
		return true; //이후 핸들러(컨트롤러,인터셉터) 실행
	}
	
	//컨트롤러 실행 후, 뷰(JSP) 실행 전에 실행되는 메서드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("LoginInterceptor : postHandle");
	}
	
	//뷰 실행(JSP 실행 및 응답 출력) 후 실행되는 메서드
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("LoginInterceptor : afterCompletion");
	}	
	
}
