package com.exam.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/list.do")
public class MemListServlet extends HttpServlet {
	MemberDao memberDao = MemberDaoBatis.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {				
		List<MemberVo> list = memberDao.selectMemberList();		
		req.setAttribute("memList", list);		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/member/MemList.jsp");		
		rd.forward(req, resp);		
	}
}