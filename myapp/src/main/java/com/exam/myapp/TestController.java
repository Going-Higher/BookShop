package com.exam.myapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//웹브라우저에서 
//http://localhost:8000/myapp/test.do 로 요청을 보내면
//이클립스 콘솔에 "TEST!"라고 출력되도록 구현
//System.out.print("TEST!");

//웹브라우저 화면에 "테스트 화면"이라고 출력되도록 구현
//=="테스트 화면"이라고 출력하는 JSP 파일을 만들고,
//컨트롤러 실행 후 그 JSP 파일이 실행되도록 구현

//http://localhost:8000/myapp/test.do?x=3&y=4 로 요청을 보내면
//웹브라우저 화면에 "x + y = 7"이라고 출력되도록 변경

//한글 파라미터 인코딩 설정
//GET 방식 요청의 파라미터 인코딩 설정
//	서버(톰캣)의 설정파일(server.xml) 파일에 설정
//	HTTP를 담당하는 <Connector>에 URIEncoding="UTF-8" 추가
//POST 방식 요청의 파라미터 인코딩 설정
//	web.xml 파일에 톰캣 또는 스프링이 제공하는 인코딩필터를 등록

@Controller //웹 요청이 왔을 때 실행되는 코드를 담고 있는 클래스를 의미
public class TestController {
	
	//스프링이 컨트롤러 실행 후 뷰에 대한 정보를 받지 못하면,
	//DefaultRequestToViewNameTranslator를 사용하여 뷰이름을 자동생성
	//현재 요청경로에서 컨텍스트패스까지 삭제하고,
	//맨 앞의 / 와 맨 뒤의 확장자를 제거하여 뷰이름으로 사용
	@RequestMapping(path = "/test.do", method = RequestMethod.POST)
//	public String test(int x, int y, Map map) {
	public String test(TestVo vo, Map map) {
		System.out.println("TEST!");
		
		for (LicenseVO lvo : vo.getLicense()) {
			System.out.println(lvo.getLicenseName());
			System.out.println(lvo.getLicenseOrg());
			System.out.println(lvo.getLicenseDate());			
		}
		
		for(String f : vo.getFood()) {
			System.out.println(f);			
		}
		
//		int sum = x + y;
		int sum = vo.getX() + vo.getY();
		map.put("result", sum);		
//		map.put("testVo", vo);		
		
		return "test";
	}
	
	@RequestMapping(path = "/param.do")
	public String param(TestVo vo, Model model) {
		List<CodeVo> list = new ArrayList<CodeVo>();
		list.add(new CodeVo("f001", "피자"));
		list.add(new CodeVo("f002", "햄버거"));
		list.add(new CodeVo("f003", "스파게티"));
		model.addAttribute("codeList", list);
		
//		TestVo vo = new TestVo();
//		vo.setLunch("f002");
//		vo.setDinner("f001");
//		List<String> list2 = new ArrayList<String>();
//		list2.add("f001");
//		list2.add("f003");
//		vo.setFood(list2);
//		model.addAttribute("testVo", vo);
		
		return "param";
	}
}
