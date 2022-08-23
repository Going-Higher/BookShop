package com.exam.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//(1)변경하려는 회원아이디가 로그인한 회원의 아이디와 다르다면 변경되지 않도록 구현
//(2)회원정보 화면에서도, 화면의 회원아이디가 로그인한 화면의 아이디와 다르다면, 이름, 포인트 값 변경이 불가능하고 submit 버튼 버튼도 출력되지 않도록 구현

@WebServlet("/member/edit.do")
public class MemEditServlet extends HttpServlet {
	MemberDao memberDao = MemberDaoBatis.getInstance();			
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getParameter("memId");			
		
		MemberVo vo = memberDao.selectMember(memId);
		req.setAttribute("memVo", vo);		
		
		req.getRequestDispatcher("/WEB-INF/jsp/member/MemEdit.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
		if(!mvo.getMemId().equals(req.getParameter("memId"))) {
			//로그인회원아이디와 변경할회원아이디가 다르면	
			throw new RuntimeException("로그인한 사용자와 다른 회원 정보는 변경 불가");
//			return;
		}		
		
//		req.setCharacterEncoding("UTF-8");
		MemberVo vo = new MemberVo();
		vo.setMemId(req.getParameter("memId"));		
//		vo.setMemPass(req.getParameter("memPass"));		
		vo.setMemName(req.getParameter("memName"));		
		vo.setMemPoint(Integer.parseInt(req.getParameter("memPoint")));		
		int num = memberDao.updatetMember(vo);
		
		//resp.sendRedirect("이동할사이트주소");를 사용하여, 웹브라우저에게 특정 사이트로 이동하라는 명령을 담은 응답을 전송
		resp.sendRedirect(req.getContextPath() + "/member/list.do");
	}
}