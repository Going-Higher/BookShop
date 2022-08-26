package com.exam.myapp.member;
// 브라우저에서
// http://localhost:8000/myapp/member/list.do 로 요청을 보내면,
// MemberController 클래스의 List() 메서드가 실행되고,
// 브라우저 화면에 "회원목록" 이라고 출력되도록 구현

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {	
//	@GetMapping("/member/list.do")
	@RequestMapping(path = "/member/list.do", method = RequestMethod.GET)
	public String list() {			
		return "member/list";
//		return new InternalResourceView("/WEB-INF/views/member/list.jsp");
//		return new JstlView("/WEB-INF/views/member/list.jsp");
	}
}
