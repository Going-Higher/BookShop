package com.exam.myapp.member;
// 브라우저에서
// http://localhost:8000/myapp/member/list.do 로 요청을 보내면,
// MemberController 클래스의 List() 메서드가 실행되고,
// 브라우저 화면에 "회원목록" 이라고 출력되도록 구현

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/")
public class MemberController {	
	@Autowired
	private MemberService memberService;
	
//	@GetMapping("/member/list.do")
	@RequestMapping(path = "list.do", method = RequestMethod.GET)
	public String list(Model model) {		
		List<MemberVo> list = memberService.selectList();
		model.addAttribute("memList", list);
		return "member/list";
//		return new InternalResourceView("/WEB-INF/views/member/list.jsp");
//		return new JstlView("/WEB-INF/views/member/list.jsp");
	}
	
	@RequestMapping(path = "add.do", method = RequestMethod.GET)
	public String addform() {		
		return "member/add";
	}
	
	@RequestMapping(path = "add.do", method = RequestMethod.POST)
	public String add(MemberVo vo) {
		int num = memberService.insert(vo);
		return "redirect:/member/list.do";
	}
	
	@RequestMapping(path = "edit.do", method = RequestMethod.GET)
	public String editform(MemberVo vo, Model model) {	
		
		MemberVo mvo = memberService.select(vo);
		model.addAttribute("memVo", mvo);
		
		return "member/edit";
	}
	
	@RequestMapping(path = "edit.do", method = RequestMethod.POST)
	public String edit(MemberVo vo) {
		int num = memberService.update(vo);
		return "redirect:/member/list.do";
	}
	
	@RequestMapping(path = "del.do", method = RequestMethod.GET)
	public String del(MemberVo vo) {			
		int num = memberService.delete(vo);		
		return "redirect:/member/list.do";
	}
}
