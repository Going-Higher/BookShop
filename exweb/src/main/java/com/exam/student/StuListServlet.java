package com.exam.student;

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

//웹브라우저에서 "http://localhost:8000/exweb/student/list.do"로 접속하면
//학생목록이 출력되도록 구현
//학생목록에 학생추가, 학생삭제 기능을 추가

@WebServlet("/student/list.do")
public class StuListServlet extends HttpServlet {
	StuDao stuDao = new StuDaoBatis();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// "http://localhost:8000/exweb/stu/list.do"로 요청을 보내면,
		// 웹브라우저에 학생목록이 출력되도록 구현		
		System.out.println("list서블릿 입장");
		List<StuVo> list = stuDao.selectStuList();
		
		req.setAttribute("stulist", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/student/StuList.jsp");
		rd.forward(req, resp);
				
//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
//		
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<meta charset='UTF-8'>");
//		out.println("<title>Insert title here</title>");			
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>학생목록<h1>");		
//		out.println("<table border=1><tr align='center' bgcolor='lightgreen'>");
//		out.println("<td>학생번호</td><td>학생이름</td><td>학생점수</td><td>비고</td></tr>");
//				
//		for (int i = 0; i < list.size(); i++) {
//			StuVo vo = list.get(i);
////			out.println(vo.getStuNo() + ":" + vo.getStuName() + ":" + vo.getStuScore());
////			out.println("<a href='"+req.getContextPath()+"/student/del.do?stuNo="+vo.getStuNo()+"'>삭제</a><br>");
//			out.println("<tr><td>" + vo.getStuNo() + "</td><td>" + vo.getStuName() + "</td><td>" + vo.getStuScore() + "</td><td>" + "<a href='"+req.getContextPath()+"/student/del.do?stuNo="+vo.getStuNo()+"'>삭제</a><br>" + "</td></tr>");
//		}					
//		out.println("</table>");
//		out.println("<a href='"+req.getContextPath()+"/student/addform.do'>학생추가</a><br>");
//		out.println("</body>");
//		out.println("</html>");
	}
}