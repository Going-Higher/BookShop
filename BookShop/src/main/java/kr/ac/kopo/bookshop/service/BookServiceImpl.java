package kr.ac.kopo.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookshop.dao.BookDao;
import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.pager.Pager;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	@Qualifier("bookDaoOracle")
	BookDao dao;

	@Override
	public List<Book> list(Pager pager) {
		int total = dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	public void add(Book item) {
		dao.add(item);		
	}

	@Override
	public Book item(int bookid) {		
		return dao.item(bookid);
	}

	@Override
	public void update(Book item) {
		dao.update(item);		
	}

	@Override
	public void delete(int bookid) {
		dao.delete(bookid);		
	}

	@Override
	public void dummy() {
		for(int index = 11; index < 100; index++) {
				Book item = new Book();
				
				item.setBookid(index);
				item.setBookname("도서명 " + index);
				item.setPublisher("출판사 " + index);
				item.setPrice( ((int)(Math.random() * 10000)) / 100 * 100 );	
				
				dao.add(item);
		}
	}

	@Override
	public void init() {
		for(int index = 11; index < 100; index++) {
			dao.delete(index);
		}
		
	}

}
