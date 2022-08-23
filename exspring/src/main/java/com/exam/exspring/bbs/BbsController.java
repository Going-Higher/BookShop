package com.exam.exspring.bbs;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.exam.exspring.member.MemberVo;

@Controller
@RequestMapping("/bbs/")//이 컨트롤러 내부의 @RequestMapping 메서드들의 공통경로를 클래스에 설정 가능
public class BbsController {
	@Autowired
	private BbsService bbsService;
	
//	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	@GetMapping("list.do") //스프링4.3이상부터 사용가능
	public String list(SearchInfo info, Map<String, Object> map) {				
		List<BbsVo> list = bbsService.selectBbsList(info);		
		map.put("bbsList", list);		
		return "bbs/bbsList"; //WEB-INF/views/bbs/bbsList.jsp
	}
	
//	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	@GetMapping("add.do") //스프링4.3이상부터 사용가능
	public String addForm() {		
		return "bbs/bbsAdd";
	}
	
//	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@PostMapping("add.do") //스프링4.3이상부터 사용가능
	public String add(BbsVo vo, HttpSession session, @SessionAttribute("loginUser") MemberVo memVO) {	
//		MemberVo memVO = (MemberVo) session.getAttribute("loginUser");
		vo.setBbsWriter(memVO.getMemId());
		
		int num = bbsService.insertBbs(vo);
		return "redirect:/bbs/list.do";
	}
	
//	@RequestMapping(value = "edit.do", method = RequestMethod.GET)
	@GetMapping("edit.do") //스프링4.3이상부터 사용가능
	public String editForm(int bbsNo, Map<String, Object> map) {
		BbsVo vo = bbsService.selectBbs(bbsNo);
		map.put("bbsVo", vo);	
		return "bbs/bbsEdit";
	}
	
//	@RequestMapping(value = "edit.do", method = RequestMethod.POST)
	@PostMapping("edit.do") //스프링4.3이상부터 사용가능
	public String edit(BbsVo vo) {			
		int num= bbsService.updateBbs(vo);
		return "redirect:/bbs/list.do";
	}
	
//	@RequestMapping(value = "del.do", method = RequestMethod.GET)
	@GetMapping("del.do") //스프링4.3이상부터 사용가능
	protected String del(int bbsNo) {
		int num = bbsService.delBbs(bbsNo);	
		return "redirect:/bbs/list.do";
	}
}

