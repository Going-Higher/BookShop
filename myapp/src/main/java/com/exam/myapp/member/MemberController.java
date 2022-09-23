package com.exam.myapp.member;
// 브라우저에서
// http://localhost:8000/myapp/member/list.do 로 요청을 보내면,
// MemberController 클래스의 List() 메서드가 실행되고,
// 브라우저 화면에 "회원목록" 이라고 출력되도록 구현

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String addform(MemberVo vo) {		
		return "member/add";
	}
	
	@RequestMapping(path = "add.do", method = RequestMethod.POST)
	//@RequestMapping 메서드의 매개변수에 @Valid 를 적용하면, 해당 객체의 클래스에 지정한 검증 조건에 맞는지 검증 수행
	//@Valid 매개변수 뒤에 BindingResult (또는 Erros) 타입의 매객변수를 추가하여 검증결과를 받아서 사용 가능
	public String add(@Valid MemberVo vo, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) { //검증결과 에러가 있다면
			System.out.println("검증 실패!");
			return "member/add"; //회원추가 jsp 화면을 다시 출력
		}
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
	
	@RequestMapping(path = "check.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> checkId(MemberVo vo) {	
		
		MemberVo mvo = memberService.select(vo);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("result", mvo==null);//사용가능한경우 {result:true}, 불가능한 경우 {result:false}
		
		return map;
	}
}
