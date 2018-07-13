package cn.dao;

import java.util.List;
import cn.bean.BookList;

public interface BookListDao {
	
	//通过读者ID展示订单信息
	List<BookList> showAllBookListByUser_id(int user_id); 
	
	//增加订单
	boolean addBookList(BookList bookList);
	
	//通过id获取订单信息
	BookList showBookListById(int id);
	
	//删除订单
	boolean deleteBookListById(int id);
	
	//修改订单信息，比如支付状态
	BookList UpdateBookListById(BookList bookList);
	
	//获取电影id
	int getFilm_idById(int id);
	
	//判断座位是否已经被预定
	boolean isSeatBought(int seat_id,int user_id);
	
	//根据订单号查询订单
	BookList showBookListByNum(String number);
	
}
