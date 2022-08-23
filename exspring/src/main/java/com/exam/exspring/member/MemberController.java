package com.exam.exspring.member;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/member/list.do", method = RequestMethod.GET)	
	public String list(Map<String, Object> map) {				
		List<MemberVo> list = memberService.selectMemberList();		
		map.put("memList", list);		
		return "member/memList";	
	}
	
	@RequestMapping(value = "/member/add.do", method = RequestMethod.GET)
	public String addForm() {		
		return "member/memAdd";
	}
	
	@RequestMapping(value = "/member/add.do", method = RequestMethod.POST)
	public String add(MemberVo vo) {			
		int num = memberService.insertMember(vo);
		return "redirect:/member/list.do";
		//뷰 이름에 redirect: 접두어를 사용하여 (포워드가 아닌) 리다이렉트임을 표시
	}
	
	@RequestMapping(value = "/member/edit.do", method = RequestMethod.GET)
	public String editForm(String memId, Map<String, Object> map) {
		MemberVo vo = memberService.selectMember(memId);
		map.put("memVo", vo);				
		return "member/memEdit";
	}
	
	@RequestMapping(value = "/member/edit.do", method = RequestMethod.POST)
	public String edit(MemberVo vo) {
//		HttpSession session = req.getSession();
//		MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
//		if(!mvo.getMemId().equals(req.getParameter("memId"))) {
//			throw new RuntimeException("로그인한 사용자와 다른 회원 정보는 변경 불가");
//		}			
				
		int num = memberService.updatetMember(vo);	
		return "redirect:/member/list.do";
	}
	
	@RequestMapping(value = "/member/del.do", method = RequestMethod.GET)
	protected String del(String memId) {
		int num = memberService.delMember(memId);		
		return "redirect:/member/list.do";
	}	
		
	@RequestMapping(value = "/member/login.do", method = RequestMethod.GET)
	public String loginForm() {			
		return "member/login";
	}
		
	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public String login(MemberVo vo, HttpSession session) {			
			
		MemberVo memVo = memberService.selectLoginMember(vo);
				
		if (memVo == null) { //로그인이 실패한 경우  			
			return "redirect:/member/login.do";			
		}else { //로그인이 성공한 경우
			session.setAttribute("loginUser", memVo); //로그인 성공한 사용자 정보를 세션에 "loginUser"라는 이름으로 저장			
			return "redirect:/member/list.do";			
		}		
	}
	
	@RequestMapping(value = "/member/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {		
		//세션의 속성값을 삭제하는 방법
//		session.setAttribute("loginUser", null); //속성값으로 null을 저장
//		session.removeAttribute("loginUser"); //속성을 삭제
		session.invalidate(); //세션객체 전체를 초기화(삭제 후 재생성)		
		return "redirect:/member/login.do";
	}
}
