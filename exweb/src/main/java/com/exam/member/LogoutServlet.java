package com.exam.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout.do")
public class LogoutServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//세션의 속성값을 삭제하는 방법
//		session.setAttribute("loginUser", null); //속성값으로 null을 저장
//		session.removeAttribute("loginUser"); //속성을 삭제
		session.invalidate(); //세션객체 전체를 초기화(삭제 후 재생성)
		
		resp.sendRedirect(req.getContextPath() + "/member/login.do"); //다시 로그인 페이지로 이동	
	}
}
