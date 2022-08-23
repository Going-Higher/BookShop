package com.exam.core;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//이 클래스의 객체를 생성하여 스프링에 ma 라는 이름으로 등록
//이름을 생략하면, 클래스명의 첫글자만 소문자로 변경하여 이름으로 사용
@Component("ma")
public class MyApp {
	//스프링에 등록된 객체들 중에서 이 변수의 타입에 맞는 객체를 주입(저장)
	@Autowired //@Inject, @Resource도 @Autowired와 동일한 역할(작동방식은 약간 차이 존재)
	//타입이 맞는 객체가 여러개 있는 경우, 그 중 이름이 일치하는 객체를 주입
	//@Qualifier 또는 @Named 으로 특정 객체 지정 가능
	//이름 지정을 생략하면, 변수명을 이름으로 사용
//	@Named("msk")
	private MyService myService;	
	
	public MyService getMyService() {
		return myService;
	}

	public void setMyService(MyService myService) {
		this.myService = myService;
	}

	public void say() {
		System.out.println(myService.getHelloMsg());
		System.out.println(myService.getByeMsg());
	}
}
