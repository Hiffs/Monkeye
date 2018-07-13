package cn.dao.impl;
import java.util.ArrayList;
import java.util.List;
import cn.bean.BookList;
import cn.dao.BookListDao;
import cn.dbc.Base;

public class BookListDaoImpl implements BookListDao{

	Base base=new Base();
	@Override
	public List<BookList> showAllBookListByUser_id(int user_id) {
		String sql="select * from booklist where user_id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(user_id);
		List<BookList> bookLists=base.getQuery(sql, list, BookList.class);
		return bookLists;
	}

	@Override
	public BookList showBookListById(int id) {
		String sql="select * from booklist where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(id);
		List<BookList> bookLists=base.getQuery(sql, list, BookList.class);
		return bookLists.get(0);
	}

	@Override
	public boolean deleteBookListById(int id) {
		String sql="delete from booklist where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(id);
		boolean flag=base.getUpdate(sql, list);
		return flag;
	}

	@Override
	public BookList UpdateBookListById(BookList bookList) {
		String sql="update booklist set user_id=?,film_id=?,"
				+ "booktime=?,cinema_id=?,theater_id=?,seat_id=?,paystatus=?,showtime=? where number=?";
		List<Object> list=new ArrayList<Object>();
		list.add(bookList.getUser_id());
		list.add(bookList.getFilm_id());
		list.add(bookList.getBooktime());
		list.add(bookList.getCinema_id());
		list.add(bookList.getTheater_id());
		list.add(bookList.getSeat_id());
		list.add(bookList.getPaystatus());
		list.add(bookList.getShowtime());
		list.add(bookList.getNumber());
		if(base.getUpdate(sql, list)) {
			return showBookListById(bookList.getId());
		}
		return null;
	}

	@Override
	public int getFilm_idById(int id) {
		String sql="select * from booklist where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(id);
		BookList bookList=(BookList)base.getQuery(sql, list, BookList.class).get(0);
		return bookList.getFilm_id();
	}

	@Override
	public boolean addBookList(BookList bookList) {
		String sql="insert into booklist(user_id,film_id,number, "+
				"booktime,cinema_id,theater_id,seat_id,paystatus,showtime) values(?,?,?,?,?,?,?,?,?)";
		List<Object> list=new ArrayList<Object>();
		list.add(bookList.getUser_id());
		list.add(bookList.getFilm_id());
		list.add(bookList.getNumber());
		list.add(bookList.getBooktime());
		list.add(bookList.getCinema_id());
		list.add(bookList.getTheater_id());
		list.add(bookList.getSeat_id());
		list.add(bookList.getPaystatus());
		list.add(bookList.getShowtime());
		if(base.getUpdate(sql, list)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isSeatBought(int seat_id,int user_id) {
		List<BookList> bookLists=showAllBookListByUser_id(user_id);
		for(int i=0;i<bookLists.size();i++) {
			if(seat_id==bookLists.get(i).getSeat_id()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public BookList showBookListByNum(String number) {
		String sql="select * from booklist where number=?";
		List<Object> list=new ArrayList<Object>();
		list.add(number);
		List<BookList> bookLists=base.getQuery(sql, list, BookList.class);
		return bookLists.get(0);
	}

}
