package com.exam.myapp.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 컨트롤러(의 @RequestMapping 메서드) 실행 전에 공통적으로 수행하는 작업들
		
		HttpSession session = request.getSession();
		MemberVo vo = (MemberVo) session.getAttribute("loginUser");
		
		if(vo == null) { //로그인하지 않은 경우
			response.sendRedirect(request.getContextPath() + "/member/login.do"); //로그인화면으로 리다이렉트
			return false; //컨트롤러 미실행
		}
		//로그인한 경우
		return true; //컨트롤러 실행
	}
	
}
