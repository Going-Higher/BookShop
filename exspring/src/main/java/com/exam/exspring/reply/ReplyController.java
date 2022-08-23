package com.exam.exspring.reply;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.exspring.member.MemberVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(path = "/reply/list.do", method = RequestMethod.GET)
	@ResponseBody
	public List<ReplyVo> list(int repBbsNo) {
		List<ReplyVo> list = replyService.selectReplyList(repBbsNo);
		return list;
	}	
	
	@RequestMapping(path = "/reply/add.do", method = RequestMethod.POST)
	@ResponseBody //이 메서드의 반환값을 그대로 응답으로 전송
	public Map<String, Object> add(ReplyVo vo, HttpSession session) {
		MemberVo memVO = (MemberVo) session.getAttribute("loginUser");
		vo.setRepWriter(memVO.getMemId());
		
		//데이터베이스 댓글 추가(insert)
		int num = replyService.insertReply(vo);		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", num);
		
		return map;
		
//		String jsonStr = ""; 
//		
//		ObjectMapper mapper = new ObjectMapper(); //JAVA객체 <-> JSON문자열 변환 담당 
//		try {
//			jsonStr = mapper.writeValueAsString(map); //JAVA객체 -> JSON문자열 변환
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		} 
//		
//		return jsonStr; //"{ \"no\" : " + num + " }"
	}
	
	 @RequestMapping(path = "/reply/del.do", method = RequestMethod.GET)
	 @ResponseBody
	 public Map<String, Object> del(ReplyVo vo, HttpSession session) {
		 MemberVo memVo = (MemberVo) session.getAttribute("loginUser");		 
		 vo.setRepWriter( memVo.getMemId() );
		 
		int num = replyService.deleteReply(vo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", num);
		
		return map;
	}

}
