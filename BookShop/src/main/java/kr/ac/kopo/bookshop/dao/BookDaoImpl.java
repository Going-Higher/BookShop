package kr.ac.kopo.bookshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.pager.Pager;

@Repository
public class BookDaoImpl implements BookDao {
	
	private List<Book> list;
	
	public BookDaoImpl() {
		list = new ArrayList<Book>();
		
		Book item = new Book();
		
		item = new Book();
		item.setBookid(1);
		item.setBookname("도서명 1");
		item.setPublisher("출판사 1");
		item.setPrice(1000);
		list.add(item);
		
		item = new Book();
		item.setBookid(2);
		item.setBookname("도서명 2");
		item.setPublisher("출판사 2");
		item.setPrice(2000);
		list.add(item);
		
		item = new Book();
		item.setBookid(3);
		item.setBookname("도서명 3");
		item.setPublisher("출판사 3");
		item.setPrice(3000);
		list.add(item);
	}

	@Override
	public List<Book> list(Pager pager) {
		return list;
	}

	@Override
	public void add(Book item) {
		list.add(item);
		
	}

	@Override
	public Book item(int bookid) {
		for(Book item : list) {
			if(item.getBookid() == bookid) {
				return item;				
			}
		}
		
		return null;
	}

	@Override
	public void update(Book item) {
		for(Book book : list) {
			if(book.getBookid() == item.getBookid()) {
				book.setBookname(item.getBookname());
				book.setPublisher(item.getPublisher());
				book.setPrice(item.getPrice());
			}
		}
		
	}

	@Override
	public void delete(int bookid) {
		for(Book item : list) {
			if(item.getBookid() == bookid) {
				list.remove(item);
				return;
			}
		}
		
	}

	@Override
	public int total(Pager pager) {
		return list.size();
	}

}
