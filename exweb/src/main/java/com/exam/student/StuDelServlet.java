package com.exam.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹브라우저에서 "http://localhost:8000/exweb/student/list/do"로 접속하면
//학생목록이 출력되도록 구현
//학생목록에 학생추가, 학생삭제 기능을 추가

@WebServlet("/student/del.do")
public class StuDelServlet extends HttpServlet {
	StuDao stuDao = new StuDaoBatis();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String stuNo = req.getParameter("stuNo");
		
		int num = stuDao.delStu(stuNo);
		
		resp.sendRedirect(req.getContextPath() + "/student/list.do");
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("<style>table{border : 1px solid black</style>");		
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>학생삭제<h1>");
//		out.println("<form action='" + req.getContextPath() + "/student/add.do' method='post'>");
		out.println(num + "명의 학생이 삭제되었습니다.");
//		out.println("학생번호 : <input type = 'text' name='stuNo' /><br>");
//		out.println("학생이름 : <input type = 'text' name='stuName' /><br>");
//		out.println("학생점수 : <input type = 'text' name='stuScore' /><br>");
		
//		out.println("<input type='submit'/>");
//		out.println("</form>");
			
		
		out.println("</body>");
		out.println("</html>");
	}
}