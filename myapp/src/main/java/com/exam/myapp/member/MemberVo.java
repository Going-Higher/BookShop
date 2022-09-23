package com.exam.myapp.member;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberVo {
	@NotNull //이 변수의 값이 null이 되어서는 안된다는 검증조건
	@Size(max = 50, min = 1) //최소 1글자 이상, 최대 50글자 이하여야 한다는 검증조건
	private String memId;
	@NotNull @Size(max = 50, min = 1)
	private String memPass;
	@NotNull @Size(max = 50, min = 1)
	private String memName;
	@Digits(integer = 3, fraction = 0, message = "최대 3자리 정수까지 입력가능") //정수 3자리, 소수이하 0자리
	private int memPoint;	
}
