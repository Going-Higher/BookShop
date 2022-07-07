package kr.ac.kopo.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.pager.Pager;
import kr.ac.kopo.bookshop.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	final String path = "book/";
	
	@Autowired
	BookService service;
	
	@RequestMapping("dummy")
	String dummy() {
		service.dummy();
		
		return "redirect:list";
	}
	
	@RequestMapping("init")
	String init() {
		service.init();
		
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	String list(Model model, Pager pager) {
		List<Book> list = service.list(pager);
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	//@RequestMapping(value="/add", method=ReqeustMethod.GET)
	@GetMapping("/add")
	String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	String add(Book item) {
		service.add(item);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{bookid}")
	String update(@PathVariable int bookid, Model model) {
		Book item = service.item(bookid);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	@PostMapping("/update/{bookid}")
	String update(@PathVariable int bookid, Book item) {
		item.setBookid(bookid);
		
		service.update(item);
		
		return "redirect:../list";
	}
	
	@RequestMapping("/delete/{bookid}")
	String delete(@PathVariable int bookid) {
		service.delete(bookid);
		
		return "redirect:../list";
	}

}
