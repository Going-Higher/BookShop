package com.exam.exspring;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	// http://localhost:8000/exspring/hello.do?x=3&y=4 로 요청을 보내면,
	// 화면에 
	// 계산결과 : 3 + 4 = 7
	// 현재서버시간 : 2022년 6월 9일 16시 01분
	// 라고 출력되도록 구현
	// 파라미터 값은 MyValue 객체로 받고,
	// 계산결과는 MyValue 객체의 sum 변수에 저장
	// hello.jsp 파일에서 화면 출력	
	
	@RequestMapping(value = "/hello.do", method = RequestMethod.GET)
	public String hello(MyValue mv, Map<String, Object> map) {
		mv.setSum(mv.getX() + mv.getY()); 
		map.put("now", new Date());
		return "hw/hello";
	}		
}
