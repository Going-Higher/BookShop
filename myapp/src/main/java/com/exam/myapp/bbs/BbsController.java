package com.exam.myapp.bbs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bbs/")
public class BbsController {	
	@Autowired
	private BbsService bbsService;
	
	@RequestMapping(path = "list.do", method = RequestMethod.GET)
	public String list(Model model) {		
		List<BbsVo> list = bbsService.selectList();
		model.addAttribute("bbsList", list);
		return "bbs/list";
	}
	
	@RequestMapping(path = "add.do", method = RequestMethod.GET)
	public String addform(BbsVo vo) {		
		return "bbs/add";
	}
	
	@RequestMapping(path = "add.do", method = RequestMethod.POST)
	public String add(@Valid BbsVo vo, BindingResult bindingResult) {
//		if(bindingResult.hasErrors()) { //검증결과 에러가 있다면
//			System.out.println("검증 실패!");
//			return "bbs/add"; //회원추가 jsp 화면을 다시 출력
//		}
		int num = bbsService.insert(vo);
		return "redirect:/bbs/list.do";
	}
	
	@RequestMapping(path = "edit.do", method = RequestMethod.GET)
	public String editform(BbsVo vo, Model model) {	
		
		BbsVo mvo = bbsService.select(vo);
		model.addAttribute("bbsVo", mvo);
		
		return "bbs/edit";
	}
	
	@RequestMapping(path = "edit.do", method = RequestMethod.POST)
	public String edit(@ModelAttribute("bbsVo") @Valid BbsVo vo, BindingResult bindingResult) {
//		if(bindingResult.hasFieldErrors("bbsName") || bindingResult.hasFieldErrors("bbsPoint")) {
//			return "bbs/edit";
//		}		
		int num = bbsService.update(vo);
		return "redirect:/bbs/list.do";
	}
	
	@RequestMapping(path = "del.do", method = RequestMethod.GET)
	public String del(BbsVo vo) {			
		int num = bbsService.delete(vo);		
		return "redirect:/bbs/list.do";
	}
	
	@RequestMapping(path = "check.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> checkId(BbsVo vo) {	
		
		BbsVo mvo = bbsService.select(vo);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("result", mvo==null);//사용가능한경우 {result:true}, 불가능한 경우 {result:false}
		
		return map;
	}
}
